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
<title>Funcionarios</title>
</head>
<body>
			<%@ include file="../HTML/cabecalho.html"%>
			<%@ include file="../HTML/rodape.html"%>
			<c:url var = "urlIndex" value ="/funcionarioController/index"/>
			<c:choose>
				<c:when test="${sessaoUsuario.cargo == 'GERENTE'}">
					<c:url var="url" value ="/gerenteController/criar"/>
					<c:url var = "urlfiltro" value ="/gerenteController/filtrar"/>
					
				</c:when>
				<c:when test="${sessaoUsuario.cargo == 'ADMIN'}">
					<c:url var="url" value ="/funcionarioController/criar"/>
					<c:url var = "urlfiltro" value ="/funcionarioController/filtrar"/>	
				</c:when>	
			</c:choose>
			
			<a href="${url}">Novo</a><br>
			
			<form:form method = "get" action="${urlfiltro}" modelAttribute = "filtro">
				Buscar Por nome:<form:input path ="nome"/>
				<input type="submit" value="pesquisar" />
			</form:form>
			<table>
					<tr>
						<td>Nome</td>
       					<td>CPF</td>
       					<td>Cargo</td>
       					<td>Salário</td>
                   		<td>Ações</td>
					</tr>	
				<c:forEach var="f" items="${funcionarios}">
					<tr>	
						<td>${f.nome}</td>
       					<td>${f.cpf}</td>
       					<td>${f.cargo}</td>
       					<td>${f.salario}</td>
                   		<td>
                   			<c:choose>
                   				<c:when test="${sessaoUsuario.cargo=='GERENTE'}">
                   					<a href='<c:url value="/gerenteController/${f.id}/atualizar"/>'>Editar</a>
									<a href='<c:url value="/gerenteController/${f.id}/remover"/>'>Excluir</a>
								</c:when>
								<c:when test="${sessaoUsuario.cargo=='ADMIN'}">
                   					<a href='<c:url value="/funcionarioController/${f.id}/atualizar"/>'>Editar</a>
									<a href='<c:url value="/funcionarioController/${f.id}/remover"/>'>Excluir</a>
								</c:when>
							</c:choose>
							
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td><a href ='${urlIndex}'>Voltar</a></td>
					</tr>
			</table>
			
			
			
			<%@ include file="../HTML/rodape.html"%>
</body>
</html>