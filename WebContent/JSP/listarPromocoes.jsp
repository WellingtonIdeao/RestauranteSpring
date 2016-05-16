<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Promocao, java.util.List"%>
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
	<div class="lista_Promocao">
	<h2>Promoções</h2>
	
	<a href='index' target="_self" class="btn">Home</a>
	<a href="cadastroPromocao" target="_self" class="btn">Nova Promocao</a>
	<% 
		String mensagem = (String) request.getAttribute("mensagem");
		if(mensagem != null){
	%>		
		<script>
			alert('<%=mensagem%>');
		</script>
	<%}
		List<Promocao> promocoes = (List<Promocao>) request.getAttribute("promocoes");
	%>

	<table width="100%" border="0" cellpadding="2" cellspacing="5">
		<tbody>
		<tr>
			<td width="50%" align="center">Nome</td>
			<td width="50%" align="center">Desconto</td>
		</tr>

		<%
			for (Promocao p : promocoes) {
		%>
		<tr>
			<td width="50%" align="center"><%=p.getDescricao()%></td>
			<td width="50%" align="center"><%=p.getDesconto()%></td>
			<td><a href="removerPromocaoServlet?id=<%=p.getId()%>">remover</a>
				<a href="cadastroPromocaoServlet?id=<%=p.getId()%>">editar</a></td>

		</tr>
		<%
			}
		%>
		</tbody>	
	</table>
	</div>
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>