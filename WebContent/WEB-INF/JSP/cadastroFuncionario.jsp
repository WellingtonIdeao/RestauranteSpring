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
<title>Cadastro Funcionário</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:choose>
			<c:when test="${sessaoUsuario.cargo == 'GERENTE'}">
				<c:url var="url" value ="/gerenteController/salvar"/>
				<c:url var= "urlvoltar" value="/gerenteController/listar"/>
			</c:when>
			<c:otherwise>
				<c:url var="url" value ="/funcionarioController/salvar"/>
				<c:url var= "urlvoltar" value="/funcionarioController/listar"/>
			</c:otherwise>
		</c:choose>
			
		<h1>Nova Funcionario</h1>	
		<form:form method="post" action="${url}" modelAttribute="funcionario">
			<form:hidden path="id"/>
			 <table>
			 	<tr>
					<td>Login:<form:input path="login.usuario"/> </td>
					<td>CPF: <form:input path="cpf"/> </td>			 
			 	</tr>
				<tr>
					<td>Senha: <form:input path="login.senha"/> </td>
					<td>Cargo: <form:select path="cargo" items="${selectCargo}"></form:select> 
							
					</td>			 
			 	</tr>
			 	<tr>
					<td>Nome: <form:input path="nome"/></td>
					<td>Salário: <form:input path="salario"/> </td>				 
			 	</tr>
			 	<tr>
					<td>Telefone: <form:input path="telefone"/> </td> 	
				</tr>
				<tr>
					<td>Email: <form:input path="email"/> </td> 	
				</tr>
				
			</table>	
				<input type = "submit" value ="Salvar"/>
				<tr>
					<td><a href='${urlvoltar}'>Voltar</a></td>
				</tr>
		
		</form:form>
			
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>