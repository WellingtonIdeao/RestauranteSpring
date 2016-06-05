<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
		<c:url var="urlFuncionario" value ="/gerenteController/listar"/>
		<c:url var="urlProduto" value ="/produtoController/listar"/>
		<c:url var="urlCategoria" value ="/categoriaController/listar"/>
		<c:url var="urlMesa" value ="/mesaController/listar"/>
		
		<div class="linha">
			<a href="${urlFuncionario}" target="_self" class="btn">Funcion�rios</a>
			<a href="${urlProduto}" target="_self" class="btn">Cardapios</a>
			<a href="${urlCategoria}" target="_self" class="btn">Categorias</a>
			<a href="${urlMesa}" target="_self" class="btn">Mesas</a>
		</div>	
</body>
</html>