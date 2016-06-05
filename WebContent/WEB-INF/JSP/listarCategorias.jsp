<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Categoria,java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Categorias</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/Categoria.css" style="text" rel="stylesheet">
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url  var = "url" value ="/categoriaController/criar"/>
		<c:url var= "urlFiltro" value="/categoriaController/filtrar"/>
		
		<div class="Categorias">
		<h2>Categoria</h2>
		<a href='index' target="_self" class="btn">Home</a>
		<a href="${url}" target="_self" class="btn">Nova Categoria</a>
		
		<form:form method="get" action="${urlFiltro}" modelAttribute="filtro">							
		<div class="linha">
    	<label>Filtrar por:</label>
    	<form:input path ="nome" placeholder="Descrição" type="text" min="0" size="25" maxlength="25"/>
    	<input type="submit" value="Pesquisar" target="_self" class="btn">
    	</div>
    	</form:form>
					
					
		<div class="tabela">
		<table width="100%" border="1">
			<tbody>
				<tr>
					<td>Nome</td>
					<td>Status</td>
					
				</tr>
			<c:forEach var="cat" items= "${categorias}">
				<tr>
					<td>${cat.nome}</td>
					<td>
					<c:choose>
						<c:when test="${cat.getIsAtivo()}">
							<c:out value = "Ativo"/>
						</c:when>	
						<c:otherwise >
							<c:out value = "Desativo"/>
						</c:otherwise>
					</c:choose>	
					</td>
					<td>
						<a href='<c:url value="/categoriaController/${cat.id}/atualizar"/>'>Editar</a>
						<a href='<c:url value="/categoriaController/${cat.id}/remover"/>'>Excluir</a>
					</td>
				</tr>
				
			</c:forEach>

			</tbody>
		</table>
		</div>
		</div>
		
		
	<%@ include file="../HTML/rodape.html"%>
		
</body>
</html>