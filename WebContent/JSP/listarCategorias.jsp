<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Categoria,java.util.List" %>    
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
		List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
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
			<%
				for (Categoria c : categorias) {
			%>
				<tr>
					<td><%=c.getNome()%></td>
				<%if(c.isAtivo())
				isAtivo = "Ativo";
				else 
				isAtivo = "Desativo";
				%>
					<td><%=isAtivo%></td>	
					<td><a href='removerCategoriaServlet?id=<%=c.getId()%>'>remover</a>
					<a href="cadastroCategoriaServlet?id=<%=c.getId()%>">editar</a></td>
				</tr>
			<%
			}
			%>
			</tbody>
		</table>
		</div>
		</div>
	
	<%@ include file="../HTML/rodape.html"%>
		
</body>
</html>