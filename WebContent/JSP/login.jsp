<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Login</title>
<link href="CSS/TelaLogin.css" style="text" rel="stylesheet">
<link href="CSS/botao.css" style="text" rel="stylesheet">
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<% 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){
		%>		
			<script>
				alert('<%=mensagem%>');
			</script>
		<%}%>
		
		<form method='post' action="loginServlet">
		<div class="formulario_login">
			<h1>Faça seu Login</h1>
			<div class="linha">
				<label>Login:</label>
				<login class="Login" id="login">
					<input placeholder="Login" name="usuario" value="" type="text" size="20" maxlength="25">
				</login>
			</div>
			
			<div class="linha">
				<label>Senha:</label>
				<senha class="Senha" id="senha">
					<input placeholder="Senha" name="senha" type="password" value="" size="20" maxlength="25">
				</senha>
			</div>
	
			<div class="botao">
        		<div class="botao1">
					<input type='submit' value='Entrar' target="_self" class="btn"/>
				</div>
        
				<div class="botao2">
					<a href ="cadastroCliente" target="_self" class="btn">Novo Usuario</a>
				</div>
			</div>
			</div>
		</form>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>