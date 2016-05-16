<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Categoria"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Categorias</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/CadastroCategoria.css" style="text" rel="stylesheet">
</head>
<body>
<%@ include file="../HTML/cabecalho.html"%>
		<%Categoria categoria = (Categoria)request.getAttribute("categoria");
		%>
		<form method = 'post' action="cadastroCategoriaServlet">
			<input type='hidden' name='id' value="<%=categoria == null ? "" : categoria.getId()%>"/>
		
	<div class="novaCategoria">
	<h2>Nova Categoria</h2>

	<div class="linha">
    <label>Nome:</label>
    <cat class="newCat" id="newCat">
		<input placeholder="Categoria" name="nome" type="text" size="25" maxlength="25" value="<%=categoria == null?"":categoria.getNome()%>">
	</cat>
    
    <label>Status:</label>
	<select name = statusSelected>	
		<option value ="<%=true%>">Ativo</option>	
		<option value ="<%=false%>">Desativo</option>
	</select>
	</div>
    
    <div class="linha">
        <div class="botao1">
		<add class="add" id="adicionar">
			<input type = "submit" value="Salvar" target="_self" class="btn">
        </add>
            
		<voltar class="Voltar" id="voltar">
			<a href ="listarCategoriaServlet" target="_self" class="btn">Voltar</a>
		</voltar>
    	</div>
	</div>

	</div>
		</form>
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>