<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Promocao"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Promoções</title>
<link href="CSS/CadastroPromocao.css" style="text" rel="stylesheet">
<link href="CSS/botao.css" style="text" rel="stylesheet">
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<c:url var="url" value ="/promocaoController/salvar"/>
	
	<form:form method='post' action="${url}" modelAttribute = "promocao">
		<form:hidden path ="id"/>
		
		<div class="cadastro_Promocao">
			<h2>Novo Promoção</h2>
			
			<table width="100%" border="0" cellpadding="2" cellspacing="5">
 				<tbody>
    				<tr>
      					<td width="11%" align="left">Nome:</td>
      					<td width="89%" align="left"><form:input path="nome" /></td>
    				</tr>
    				<tr>
    					<td align="left">Desconto(%):</td>
      					<td align="left"><form:input path="valor" /></td>
    				</tr>
    				<tr>
    					<td align="left"><input type="submit" value="Salvar" target="_self" class="btn"></td>
    					<td align="left"><a href='<c:url value="/promocaoController/listar"/>' target="_self" class="btn">Voltar</a></td>
    				</tr>
  				</tbody>
			</table>
		</div>
	</form:form>
			<%@ include file="../HTML/rodape.html"%>
</body>
</html>