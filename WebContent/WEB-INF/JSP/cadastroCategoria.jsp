<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Categoria"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Categorias</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/CadastroCategoria.css" style="text" rel="stylesheet">
</head>
<body>
<%@ include file="../HTML/cabecalho.html"%>
		<c:url var="url" value ="/categoriaController/salvar"/>
		
		<form:form method = "post" action="${url}" modelAttribute ="categoria">
			<form:hidden path ="id"/>
		
	<div class="novaCategoria">
	<h2>Categoria</h2>

	<div class="linha">
    <label>Nome:</label>
    <cat class="newCat" id="newCat">
		<form:input path="nome" placeholder="Categoria"  type="text" size="25" maxlength="25" />
	</cat>
    
    <label>Status:</label>
	<form:select path = "isAtivo" >
		 <form:option value = "true" label="Ativo" ></form:option>	
		 <form:option value = "false" label="Desativo"></form:option>	 
	</form:select>
	</div>
    
    <div class="linha">
        <div class="botao1">
		<add class="add" id="adicionar">
			<input type = "submit" value="Salvar" target="_self" class="btn">
        </add>
            
		<voltar class="Voltar" id="voltar">
			<a href = '<c:url value="/categoriaController/listar"/>' target="_self" class="btn">Voltar</a>
		</voltar>
    	</div>
	</div>
	</div>
	</form:form>
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>