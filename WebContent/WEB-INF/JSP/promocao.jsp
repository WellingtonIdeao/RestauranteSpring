<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	info="Escrito por Jos� Wellington Ide�o de Paiva em 03/05/2016"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- para fun��es -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Promo��o</title>
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<c:url var="url" value="/categoriaController/salvar" />

	<form:form method="post" action="${url}" modelAttribute="promocao">
		<form:hidden path="id" />
		<table>
			<%--<tr> = linha <td> = coluna--%>
			<tr>
				<td>Name</td>
				<td><form:input path="nome"/></td>
			</tr>
			<tr>
				<td>Desconto</td>
				<td><select name='descontoSelected'>
						<option value="*">*</option>
						<option value="**">**</option>
						<option value="***">***</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Salvar"></td>
			</tr>


		</table>
	</form:form>
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>