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
<title>Cadastro de Mesas</title>
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
			<c:url var="url" value ="/mesaController/salvar"/>
		<h1>Nova Mesa</h1>	
		<form:form method="post" action="${url}" modelAttribute="mesa">
			<form:hidden path="id"/>
			<form:hidden path ="isAtivo"/>
			 <table>
			 	<tr>
					<td>Descrição: <form:input path="descricao"/> </td>			 
			 	</tr>
				<tr>
					<td>Capacidade: <form:input path="capacidade"/> </td>			 
			 	</tr>
			 	<tr>
					<td>De Reserva?
						<form:select path="isReserva">
						<form:option value="true" label ="Sim"/>
						<form:option value="false" label ="Não"/>	
						</form:select>
					</td>
				</tr>
			</table>	
				<input type = "submit" value ="adicionar"/>
				<a href='<c:url value="/mesaController/listar"/>'>Voltar</a>
				 
		</form:form>
			
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>