<%@page import="javax.xml.ws.Dispatch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Cliente,java.util.List,javax.servlet.RequestDispatcher" %>    

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
		
		<div class="cliente">
		<h2>Clientes</h2>
		<div class="linha">
		<a href='index' target="_self" class="btn">Home</a>
		<a href="cadastroCliente" target="_self" class="btn">NovoCliente</a>
		</div>
		<% 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){
		%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<%}%>	
		
		<%List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");%>
		<table width="100%" border="1" cellpadding="1" cellspacing="3">
			<tbody>	
				<tr>
					<td width="20%" align="center">Nome</td>
					<td width="20%" align="center">Email</td>
					<td width="20%" align="center">DataNascimento</td>
					<td width="20%" align="center">Telefone</td>
					<td width="20%" align="center">Ações</td>
				</tr>
				<%if(clientes!=null){	
				for (Cliente c : clientes) {	%>
				<tr>
					<td height="30" align="center"><%=c.getNome()%></td>
					<td align="center"><%=c.getEmail()%></td>
					<td align="center"><%=c.getDataNasc()%></td>
					<td align="center"><%=c.getTelefone()%></td>
					<td align="center"><a href="removerClienteServlet?id=<%=c.getId()%>" target="_self" class="btn">remover</a>
					<a href="cadastroClienteServlet?id=<%=c.getId()%>" target="_self" class="btn">editar</a></td>	
				</tr>
				<%}
				}%>
			</tbody>
		</table>
		</div>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>