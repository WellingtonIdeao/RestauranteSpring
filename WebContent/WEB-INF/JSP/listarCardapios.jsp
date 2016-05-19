<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.Produto, model.Cardapio"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Cardapios </title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/Cardápio.css" style="text" rel="stylesheet">
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	
	
	<br />
		<% 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){
		%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<% 		
			}
		%>
	
		<div class="cardapio1">
		<h2>Cardápio</h2>
		<div class="linha">
    	<label>Filtrar por:</label>
    		<filter class="filter" id="filter">
				<input placeholder="Descrição" type="text" min="0" size="25" maxlength="25">
			</filter>
        
        <label>Status:</label>
			
    	</select>
                
    	<pesquisa class="pesquisa" id="pesquisa">
			<input type="submit" onClick="" value="Pesquisar">
		</pesquisa>
        </div>
        
		<div class="novo">
		<a href='index' target="_self" class="btn">Home</a>
   		<a href='cadastroCardapioServlet' target="_self" class="btn">Novo Cardapio</a>
   		</div>
	
    	<div class="tabela">
    		<table width="100%" border="1">
    			<tbody>
    				<tr>
        				<td>Nome</td>
        				<td>Preço</td>
        				<td>Situação</td>
        				<td>Categoria</td>
        				<td>Promoção</td>
                    	<td>Ações</td>
        			</tr>
        	<%
		   	List<Produto> cardapios =(List<Produto>)request.getAttribute("cardapios");
			String isAtivo = null;
			%>
			
			<%for (Produto p : cardapios) {
			Cardapio c = (Cardapio)p;
			%>
                	<tr>
        				<td><%=c.getNome()%> </td>
						<td><%=c.getPreco()%></td>
						<td><%=c.isAtivo()?"Ativo":"Desativo"%></td>			
						<td><%=c.getCategoria()%></td>
						<td><%=c.getPromocao()%></td>
					<td>
						<a href='removerCardapioServlet?id=<%=c.getId()%>'>remover</a>
						<a href='cadastroCardapioServlet?id=<%=c.getId()%>'>editar</a>
					</td>
        			</tr>
 			<%} %>				
			</tbody>        
		</table>
		</div>
		</div>

		<%@ include file="../HTML/rodape.html"%>
</body>
</html>