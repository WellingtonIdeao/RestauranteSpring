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
<title>Nova reserva</title>
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
			<c:url var="url" value ="/reservaController/salvar"/>
		<h1>Nova Reserva</h1>	
		<form:form method="post" action="${url}" modelAttribute="reserva">
			<form:hidden path="id"/>
			 <table>
			 	<tr>
					<td>Data Início: <form:input path="horarioInicial"/> </td>			 
			 	</tr>
				<tr>
					<td>Data Fim: <form:input path="horarioFinal"/> </td>		 
			 	</tr>
			 	<tr>
					<td>Responsável: <form:input path="responsavel"/> </td>			 
			 	</tr>
			 	<tr>
					<td>Mesa:
					<form:select path="mesa.id" items="${selectMesas}" >
				   	</form:select>
				    </td>  	
                    
				</tr>
			</table>	
				<input type = "submit" value ="reservar"/>
				<a href='<c:url value="/reservaController/listar"/>'>Voltar</a>
		</form:form>
			
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>