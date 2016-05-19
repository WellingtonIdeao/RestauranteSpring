<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Categoria,java.util.List" %>
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
		<div class="Categorias">
		<h2>Categoria</h2>
		<a href='index' target="_self" class="btn">Home</a>
		<a href="cadastroCategoria" target="_self" class="btn">Nova Categoria</a>
		<% 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){
		%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<%}
		
		String isAtivo = null;
		%>
		
		<div class="linha">
    	<label>Filtrar por:</label>
    	<input placeholder="Descrição" type="text" min="0" size="25" maxlength="25">
    	<input type="submit" value="Pesquisar" target="_self" class="btn">
    	</div>
    	
		
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
						<c:when test="${cat.isAtivo()}">
							<c:out value = "Ativo"/>
						</c:when>	
						<c:otherwise >
							<c:out value = "Desativo"/>
						</c:otherwise>
					</c:choose>	
					</td>
				</tr>
				
			</c:forEach>

			</tbody>
		</table>
		</div>
		</div>
		
		
	<%@ include file="../HTML/rodape.html"%>
		
		<!--if(c.isAtivo())
				isAtivo = "Ativo";
				else 
				isAtivo = "Desativo";
				<td><isAtivo%></td> 
			<td><a href='removerCategoriaServlet?id=<c.getId()>'>remover</a>
					<a href="cadastroCategoriaServlet?id=<c.getId()%>">editar</a></td>	
				-->
	
</body>
</html>