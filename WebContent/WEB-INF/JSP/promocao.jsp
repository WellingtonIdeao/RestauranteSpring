<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    info="Escrito por José Wellington Ideão de Paiva em 03/05/2016"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Promoção</title>
</head>
<body>
	 	<%@ include file="../HTML/cabecalho.html"%> 
		<%String nome = request.getParameter("nome"); %>
		
		<form method="post" action="/PaginaPromocao">
			<table>
				<%--<tr> = linha <td> = coluna--%>
				<tr> 
					<td>Name</td> 
					<td><input type ="text" name='nome' value=""></td>
				</tr>
				<tr>
						<td>Desconto</td>
						<td><select name = 'descontoSelected'>
								<option value="*"> *</option>
								<option value="**">**</option>
								<option value="***">***</option>
							</select> </td>
				</tr>
				<tr>		
						<td> <input type ="submit" value="Salvar"></td>
				</tr>
				
				
			</table>
		</form>
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>