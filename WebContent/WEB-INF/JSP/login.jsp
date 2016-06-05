<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
    
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
		<c:url var="url" value ="/logar"/>	
		<c:url var="urlCadastroCliente" value ="/clienteController/criar"/>	
		<form:form method='post' action="${url}" modelAttribute="usuario">
		<div class="formulario_login">
			<h1>Faça seu Login</h1>
			<div class="linha">
				<label>Login:</label>
				<login class="Login" id="login">
					<form:input path = "login.usuario" placeholder="Login" name="usuario" type="text" size="20" maxlength="25"/>
				</login>
			</div>
			
			<div class="linha">
				<label>Senha:</label>
				<senha class="Senha" id="senha">
					<form:input path ="login.senha" placeholder="Senha" name="senha" type="password"  size="20" maxlength="25"/>
				</senha>
			</div>
	
			<div class="botao">
        		<div class="botao1">
					<input type='submit' value='Entrar' target="_self" class="btn"/>
				</div>
        
				<div class="botao2">
					<a href ="${urlCadastroCliente}" target="_self" class="btn">Novo Usuario</a>
				</div>
			</div>
			</div>
		</form:form>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>