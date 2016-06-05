<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List,model.Delivery"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Delivery</title>
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<c:url  var = "url" value ="/deliveryController/criar"/>
	<c:url  var = "urlfiltro" value ="/deliveryController/${sessaoUsuario.id}/filtrar"/>
	<c:url var= "urlIndex" value="/deliveryController/index"/>
	<h1>Meus pedidos</h1>
	<a href='${urlIndex}'>Home</a> <a href="${url}">Novo pedido</a>
	<form:form method = "get" action="${urlfiltro}" modelAttribute = "filtro">
			Numero do pedido:<form:input path ="id"/> <form:select path="status" items= "${selectStatus}"></form:select>
			<input type="submit" value="pesquisar" />
	</form:form>
	 
	<table>
    		<tr>
       			<td>Número</td>
       				<td>Data</td>
       				<td>Total</td>
       				<td>Situação</td>
                   	<td>Ações</td>
       			</tr>
			
			<c:forEach var ="del" items= "${deliverys}">
			    	<tr>
        				<td>${del.id}</td>
        				<td>${del.data}</td>
						<td>R$: ${del.total()}</td>
						<td>${del.status}</td>
						<td>
							<a href='<c:url value="/deliveryController/${del.id}/detalhe"/>'>Detalhar</a>
						</td>
        			</tr>
 			</c:forEach>				       
		</table>

		<%@ include file="../HTML/rodape.html"%>
	
	
	
</body>
</html>