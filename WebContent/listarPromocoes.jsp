<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.Promocao, java.util.List" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Promocao</title>
<link >
</head>
<body>

		<a href='cadastroPromocao' >Nova Promocao</a>
		<br/>
		<%String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<%}%>
	<table>
		<tr>
			<td>Nome</td>
			<td>Desconto</td>
			<td><a href = "listarCardapios">Voltar</a></td>
			
		</tr>
		<%
		   List<Promocao> promocoes =(List<Promocao>)request.getAttribute("promocoes"); 	
		%>
			
		<%for (Promocao p : promocoes) {%>
		<tr>
			<td><%=p.getDescricao()%> </td>
			<td><%=p.getDesconto()%> </td>
			<td>
				<a href='removerPromocao?id=<%=p.getId()%>'>remover</a>
				<a href='cadastroPromocao?id=<%=p.getId()%>'>editar</a>
			</td>
		</tr>
		<%} %>
		<tr>	
			
		</tr>
		
		
</body>
</html>