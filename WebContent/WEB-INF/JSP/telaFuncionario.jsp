<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->      
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="CSS/Promocao.css" style="text" rel="stylesheet">
</head>
<body>
		<c:url var="urlPedidos" value ="/tradicionalController/listar"/>
		<c:url var="urlReserva" value ="/reservaController/listar"/>
		<c:url var="urlCliente" value ="/clienteController/listar"/>
		<div class="linha">		
			<a href="${urlPedidos}" target="_self" class="btn">Pedidos</a>
			<a href="${urlReserva}" target="_self" class="btn">Reservas</a>
			<a href="${urlCliente}" target="_self" class="btn">Clientes</a>
		</div>	
</body>
</html>