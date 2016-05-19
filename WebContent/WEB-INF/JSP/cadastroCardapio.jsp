<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Cardapio,model.Promocao,java.util.List,model.Categoria"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Cardapio</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/CadastroCardápio.css" style="text" rel="stylesheet">
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<% 
    	Cardapio cardapio = (Cardapio) request.getAttribute("cardapio");
		List<Categoria> categorias =(List<Categoria>) request.getAttribute("categorias");
		List<Promocao> promocoes = (List<Promocao>) request.getAttribute("promocoes");
		%>
		
	<form method='post' action="cadastroCardapioServlet">
		<input type='hidden' name='id' value= "<%=cardapio == null ? "" : cardapio.getId()%>"/>
		
		<div class="novoCardapio">
		<h2>Novo Cardápio</h2>
        
			<div class="linha">
    		<label>Categoria:</label>
			<select name='catSelected'>
				<% for(Categoria c: categorias){
					if(c.isAtivo()){
				%>
					<option value ="<%=c.getId()%>"><%=c.getNome()%></option>			
				<%}		 
				}%>
			</select>
			
			<div class="linha">
    		<label>Nome:</label>
    			<card class="newNome">
					<input placeholder="Nome" name="nome" type="text" size="25" maxlength="25" 
					value="<%=cardapio == null ? "" : cardapio.getNome()%>">
				</card>
   			</div>
		
			 <div class="linha">
			 <label>Preço:</label>
    		 	<card class="preco">
			 		<input placeholder="Preço" name="preco" type="text" size="25" maxlength="25" 
			 		value="<%=cardapio == null ? "" : cardapio.getPreco()%>">
				</card>
			 </div>
		
			<div class="linha">
    		<label>Situação:</label>
				<select name = 'statusSelected'>	
					<option value ="<%=true%>">Ativo</option>	
					<option value ="<%=false%>">Desativo</option>
				</select>
			</div>
			
			<div class="linha">
    		<label>Promoção:</label>
				<select name='promoSelected'>
					<% for(Promocao p: promocoes){ %>
						<option value ="<%=p.getId()%>"><%=p.getDescricao()%></option>					 
					<%}%>		
				</select>
			</div>
			
			<div class="linha">
        		<div class="botao1">
          			<input type="submit" value="Adicionar" target="_self" class="btn">
            		<a href="listarCardapioServlet" target="_self" class="btn">Voltar </a>
				</div>
			</div>
			</div>	
		</div>
		
	</form>
	
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>