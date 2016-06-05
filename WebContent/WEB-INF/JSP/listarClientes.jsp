<%@page import="javax.xml.ws.Dispatch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Cliente,java.util.List,javax.servlet.RequestDispatcher" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/Cliente.css" style="text" rel="stylesheet">
<link href="CSS/botao.css" style="text" rel="stylesheet">
<title>Lista de Clientes</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url  var = "url" value ="/clienteController/criar"/>
		<c:url var= "urlFiltro" value="/clienteController/filtrar"/>
		<c:url var= "urlIndex" value="/clienteController/index"/>
		
		<div class="cliente">
		<h2>Clientes</h2>
		<div class="linha">
		<a href="${urlIndex}" target="_self" class="btn">Home</a>
		<a href="${url}" target="_self" class="btn">NovoCliente</a>
		</div>
		
		<form:form method="get" action="${urlFiltro}" modelAttribute="filtro">							
		<div class="linha">
    	<label>Filtrar por:</label>
    	<form:input path ="nome" placeholder="Nome" type="text" min="0" size="25" maxlength="25"/>
    	<input type="submit" value="Pesquisar" target="_self" class="btn">
    	</div>
    	</form:form>
		
		
		<table width="100%" border="1" cellpadding="1" cellspacing="3">
			<tbody>	
				<tr>
					<td width="20%" align="center">Nome</td>
					<td width="20%" align="center">Email</td>
					<td width="20%" align="center">Telefone</td>
					<td width="20%" align="center">Ações</td>
				</tr>
					
				<c:forEach var="c" items ="${clientes}">
					<tr>
						<td height="30" align="center">${c.nome}</td>
						<td align="center">${c.email}</td>
						<td align="center">${c.telefone}</td>
						<td align="center">
						<a href='<c:url value="/clienteController/${c.id}/atualizar"/>' target="_self" class="btn" >Editar</a>
						<a href='<c:url value="/clienteController/${c.id}/remover"/>' target="_self" class="btn" >Excluir</a></td>	
					</tr>
					
				</c:forEach>	
			</tbody>
				
		</table>
		</div>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>