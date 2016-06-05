<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Cliente" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
<link href="CSS/CadastroCliente.css" style="text" rel="stylesheet">
<link href="CSS/botao.css" style="text" rel="stylesheet">
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<%session = request.getSession();%>
		<c:url var="url" value ="/clienteController/salvar"/>
		
		<form:form method = 'post' action="${url}" modelAttribute = "cliente">
		<form:input type='hidden' path='id'/>
		<div class="cadastro_Cliente">
	 	<h2>Novo Login</h2>
    		<table width="100%" border="0" cellpadding="2" cellspacing="5">
	    	<tbody>
	     		<tr>
					<td width="12%">Login:</td>
	        		<td width="39%"><form:input path ="login.usuario" type = "text" name="usuario" 
	        		placeholder="Login" size="25" maxlength="50"/></td>
	        		<td width="12%">Rua:</td>
	        		<td width="37%"><form:input path = "ende.rua" type = "text" name="rua"
	        		placeholder="Rua" size="25" maxlength="50"/></td>
          		</tr>
          		
          		<tr>
	        		<td>Senha:</td>
	        		<td><form:input path ="login.senha" type = "password" name="senha"
	        		placeholder="Senha" size="25" maxlength="50"/></td>
	        		<td>Complemento:</td>
	        		<td><form:input path = "ende.complemento" type = "text" name="complemento"
	        		placeholder="Complemento" size="25" maxlength="50"/></td>
          		</tr>
          		
          		<tr>
	        		<td>Nome:</td>
	        		<td><form:input path = "nome" type = "text" name="nome"
	        		placeholder="Nome" size="25" maxlength="50"/></td>
	        		<td>Bairro:</td>
	        		<td><form:input path = "ende.bairro" type = "text" name="bairro"
	        		placeholder="Bairro" size="25" maxlength="50"/></td>
          		</tr>
          		
          		<tr>
	        		<td>Telefone:</td>
	        		<td><form:input path= "telefone" type = "text" name="telefone"
	        		placeholder="Telefone" size="25" maxlength="50"/></td>
	        		<td>CEP:</td>
	        		<td><form:input path = "ende.cep" type = "text" name="cep"
	        		placeholder="CEP" size="25" maxlength="50"/></td>
          		</tr>
          		
          		<tr>
	        		<td>Email:</td>
	        		<td><form:input path ="email" type = "text" name="email"
	        		placeholder="Email" size="25" maxlength="50"/></td>
	        		<td>Número:</td>
	        		<td><form:input path = "ende.num" type = "text" name="numero"
	        		placeholder="Número" size="25" maxlength="20"/></td>
          		</tr>
          		
				<tr>
					<td><input type = "submit" value="Salvar" target="_self" class="btn"></td>
					<td><c:choose>
						<c:when test='${empty sessaoUsuario}'>
							<a href='<c:url value ="/loginForm"/>' target="_self" class="btn">Voltar</a>
						</c:when>	
						<c:otherwise>	
							<a href='<c:url value ="/clienteController/listar"/>' target="_self" class="btn">Voltar</a>	
						</c:otherwise>		
					</c:choose>	
					</td>
				</tr>
			</table>
		
		</div>
		</form:form>
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>