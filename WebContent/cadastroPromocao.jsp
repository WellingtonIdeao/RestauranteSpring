<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Promocao, java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% 
    	Promocao promocao = (Promocao) request.getAttribute("promocao");
		%>
		<br />
	<form method='post' action='cadastroPromocao'>
	
	    <input type='hidden' name='id' value="<%=promocao == null ? "" : promocao.getId()%>" />
		
		<table>
			
			<tr>
				<td>Nome</td>
				<td><input type='text' name='nome' value="<%=promocao == null ? "" :promocao.getDescricao()%>" /></td>
			</tr>

			<tr>
				<td>Desconto</td>
				<td><input type='text' name='desconto' value="<%=promocao == null ? "" : promocao.getDesconto()%>"/></td>
			</tr>
			<tr>
				<td><input type='submit' value='Salvar' /></td>
				<td></td>
			</tr>

		</table>
	</form>
</body>
</html>