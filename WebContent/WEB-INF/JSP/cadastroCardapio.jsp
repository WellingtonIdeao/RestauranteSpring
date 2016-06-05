<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Cardapio,model.Promocao,java.util.List,model.Categoria"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
   
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
		<c:url var="url" value ="/produtoController/salvar"/>
	
		
	<form:form method="post" action="${url}" modelAttribute="cardapio">
		<form:hidden path="id"/>
		
		<div class="novoCardapio">
		<h2>Novo Cardápio</h2>
        
			<div class="linha">
    		<label>Categoria:</label>
			<form:select path ="categoria">
				<c:forEach var="c" items="${categorias}">
					<c:if test = "${c.isAtivo}">
						<form:option value = "${c.id}" label = "${c.nome}"></form:option>
					</c:if>				
				</c:forEach>				
			</form:select>
			
			<div class="linha">
    		<label>Nome:</label>
    			<card class="newNome">
					<form:input path ="nome" placeholder="Nome" size="25" maxlength="25" /> 
				</card>
   			</div>
		
			 <div class="linha">
			 <label>Preço:</label>
    		 	<card class="preco">
			 		<form:input path ="preco" placeholder="Preço" size="25" maxlength="25" />
				</card>
			 </div>
		
			<div class="linha">
    		<label>Situação:</label>
				<form:select path ="isAtivo">	
					<form:option value = "true" label="Ativo"></form:option>	
					<form:option value ="false" label="Desativo"></form:option>
				</form:select>
			</div>
			
			<div class="linha">
    		<label>Promoção:</label>
				<form:select path = "promocao">
					<c:forEach var="p" items ="${promocoes}">
						<form:option value ="${p.id}" label="${p.nome}"></form:option>					 
					</c:forEach>		
				</form:select>
			</div>
			
			<div class="linha">
        		<div class="botao1">
          			<input type="submit" value="Salvar" target="_self" class="btn">
            		<a href='<c:url value ="/produtoController/listar"/>' target="_self" class="btn">Voltar </a>
				</div>
			</div>
			</div>	
		</div>
		
	</form:form>	
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>