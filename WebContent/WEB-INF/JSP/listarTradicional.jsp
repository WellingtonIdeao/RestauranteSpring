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
<title>lista de Pedidos</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
	<c:url  var = "url" value ="/tradicionalController/criar"/>
	<c:url  var = "urlfiltro" value ="/tradicionalController/filtrar"/>
	<h1>Pedidos</h1>
	<a href="${url}">Novo</a>
	<form:form method = "get" action="${urlfiltro}" modelAttribute = "filtro">
			Nº do pedido:<form:input path ="id"/>
			Tipos:<form:select path ="tipo" items="${selectTipos}"></form:select>
			Status:<form:select path ="status" items="${selectStatus}"></form:select>
			<input type="submit" value="pesquisar" />
	</form:form>
			 
	<table>
    		<tr>
       				<td>Número</td>
       				<td>Data</td>
       				<td>Total(R$)</td>
       				<td>Situação</td>
       				<td>Cliente</td>
       				<td>Atendido por</td>
       				<td>Tipo</td>
                   	<td>Ações</td>
       			</tr>
			
			<c:forEach var ="pe" items= "${pedidos}">
			    	<tr>
        				<td>${pe.id}</td>
        				<td>${pe.data}</td>
						<td>${pe.total()}</td>
						<td>${pe.status}</td>
						<c:choose>
								<c:when test="${pe =='Delivery'}">
									<td>${pe.cliente}</td>			
								</c:when>
								<c:otherwise>
									<td>${pe.mesa}</td>
								</c:otherwise>
						</c:choose>		
						<c:choose>
								<c:when test="${pe =='Delivery'}">
									<td></td>
								</c:when>
								<c:otherwise>
									<td>${pe.funcionario}</td>
								</c:otherwise>
						</c:choose>
					
						<td>${pe}</td>
						<td>
							<a href='<c:url value="/tradicionalController/${pe.id}/detalheTotal"/>'>Detalhar</a>
						</td>
        			</tr>
 			</c:forEach>
 						<tr>
 							<td><a href='<c:url value="/tradicionalController/index"/>'>Voltar</a></td>	
 						</tr>					       
		 </table>

		<%@ include file="../HTML/rodape.html"%>
	
	
</body>
</html>