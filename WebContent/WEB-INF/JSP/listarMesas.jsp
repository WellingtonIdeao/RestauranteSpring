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
<title>Lista de mesas</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<h1>Mesas</h1>
		<c:url  var = "url" value ="/mesaController/criar"/>
		<c:url  var = "urlfiltro" value ="/mesaController/filtrar"/>
		<c:url  var = "urlIndex" value ="/mesaController/index"/>
		<form:form method = "get" action="${urlfiltro}" modelAttribute = "filtro">
			Filtra por Descrição:<form:input path ="descricao"/> De Reserva? <form:select path="isReserva" items="${selectIsReserva}"></form:select>
			<input type="submit" value="pesquisar" />
		</form:form>

		<a href ="${urlIndex}">Home</a><a href="${url}">Nova mesa</a> 
		<table>
    			<tr>
    				<td>Número</td>
       				<td>Descricao</td>
       				<td>Capacidade</td>
       				<td>De reserva?</td>
                   	<td>Ações</td>
       			</tr>
			
			<c:forEach var ="ms" items= "${mesas}">
			    	<tr>
        				<td>${ms.id}</td>
        				<td>${ms.descricao}</td>
						<td>${ms.capacidade}</td>
						<td>
							<c:choose>
								<c:when test="${ms.isReserva}">
									<c:out value = "Sim"/>
								</c:when>	
								<c:otherwise >
									<c:out value = "Não"/>
							</c:otherwise>
							</c:choose>	
						</td>
						<td>
							<c:choose>
								<c:when test="${ms.isAtivo}">
									<a href='<c:url value="/mesaController/${ms.id}/disposicao/${Boolean.FALSE}"/>'>Inativar</a>
								</c:when>	
								<c:otherwise >
									<a href='<c:url value="/mesaController/${ms.id}/disposicao/${Boolean.TRUE}"/>'>Ativar</a>
							</c:otherwise>
							</c:choose>
							<a href='<c:url value="/mesaController/${ms.id}/atualizar"/>'>Editar</a>
							<a href='<c:url value="/mesaController/${ms.id}/remover"/>'>Excluir</a>
						</td>
        			</tr>
 			</c:forEach>				       
		</table>

		<%@ include file="../HTML/rodape.html"%>
	
</body>
</html>