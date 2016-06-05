<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Promocao, java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Promoções</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/Promocao.css" style="text" rel="stylesheet">
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<c:url  var = "url" value ="/promocaoController/criar"/>
	<c:url var= "urlFiltro" value="/promocaoController/filtrar"/>
	
	<div class="lista_Promocao">
	<h2>Promoções</h2>
	
	<a href='index' target="_self" class="btn">Home</a>
	<a href="${url}" target="_self" class="btn">Nova Promocao</a>
	
	
	<form:form method="get" action="${urlFiltro}" modelAttribute="filtro">							
		<div class="linha">
    	<label>Filtrar por:</label>
    	<form:input path ="nome" placeholder="nome" type="text" min="0" size="25" maxlength="25"/>
    	<input type="submit" value="Pesquisar" target="_self" class="btn">
    	</div>
    </form:form>
		

	<table width="100%" border="0" cellpadding="2" cellspacing="5">
		<tbody>
		<tr>
			<td width="50%" align="center">Nome</td>
			<td width="50%" align="center">Desconto</td>
		</tr>


		<c:forEach var="pro" items= "${promocoes}">
				<tr>
						<td width="50%" align="center">${pro.nome}</td>
						<td width="50%" align="center">${pro.valor}</td>
						<td> <a href='<c:url value="/promocaoController/${pro.id}/atualizar"/>'>Editar</a></td>
						<td> <a href='<c:url value="/promocaoController/${pro.id}/remover"/>'>Excluir</a></td>		
				</tr>	
		</c:forEach>

		</tbody>	
	</table>
	</div>
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>