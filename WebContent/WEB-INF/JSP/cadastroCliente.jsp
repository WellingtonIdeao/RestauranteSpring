<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Cliente" %>    
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
		<%Cliente cliente = (Cliente)request.getAttribute("cliente");%>
		<form method = 'post' action="cadastroClienteServlet">
		<input type='hidden' name='id' value="<%=cliente == null ? "" : cliente.getId()%>"/>
		<div class="cadastro_Cliente">
	 	<h2>Novo Login</h2>
    		<table width="100%" border="0" cellpadding="2" cellspacing="5">
	    	<tbody>
	     		<tr>
					<td width="12%">Login:</td>
	        		<td width="39%"><input type = "text" name="usuario" value="<%=cliente == null?"":cliente.getLogin().getUsuario()%>" 
	        		placeholder="Login" size="25" maxlength="50"></td>
	        		<td width="12%">Rua:</td>
	        		<td width="37%"><input type = "text" name="rua" value="<%=cliente == null?"":cliente.getEnde().getRua()%>"
	        		placeholder="Rua" size="25" maxlength="50"></td>
          		</tr>
          		
          		<tr>
	        		<td>Senha:</td>
	        		<td><input type = "password" name="senha" value="<%=cliente == null?"":cliente.getLogin().getSenha()%>"
	        		placeholder="Senha" size="25" maxlength="50"></td>
	        		<td>Complemento:</td>
	        		<td><input type = "text" name="complemento" value="<%=cliente == null?"":cliente.getEnde().getComplemento()%>"
	        		placeholder="Numero e Complemento" size="25" maxlength="50"></td>
          		</tr>
          		
          		<tr>
	        		<td>Nome:</td>
	        		<td><input type = "text" name="nome" value="<%=cliente == null?"":cliente.getNome()%>"
	        		placeholder="Nome" size="25" maxlength="50"></td>
	        		<td>Bairro:</td>
	        		<td><input type = "text" name="bairro" value="<%=cliente == null?"":cliente.getEnde().getBairro()%>"
	        		placeholder="Bairro" size="25" maxlength="50"></td>
          		</tr>
          		
          		<tr>
	        		<td>Telefone:</td>
	        		<td><input type = "text" name="telefone" value="<%=cliente == null?"":cliente.getTelefone()%>"
	        		placeholder="Telefone" size="25" maxlength="50"></td>
	        		<td>CEP:</td>
	        		<td><input type = "text" name="cep" value="<%=cliente == null?"":cliente.getEnde().getCep()%>"
	        		placeholder="CEP" size="25" maxlength="50"></td>
          		</tr>
          		
          		<tr>
	        		<td>Email:</td>
	        		<td><input type = "text" name="email" value="<%=cliente == null?"":cliente.getEmail()%>"
	        		placeholder="Email" size="25" maxlength="50"></td>
	        		<td>Número:</td>
	        		<td><input type = "text" name="numero" value="<%=cliente == null?"":cliente.getEnde().getNum()%>"
	        		placeholder="Número" size="25" maxlength="20"></td>
          		</tr>
          		
				<tr>
					<td><input type = "submit" value="Salvar" target="_self" class="btn"></td>
					<td><a href ="listarClienteServlet" target="_self" class="btn">Voltar</a></td>
				</tr>
			</table>
		
		</div>
		</form>
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>