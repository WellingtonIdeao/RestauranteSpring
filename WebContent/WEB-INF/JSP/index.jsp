<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Usuario"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="<c:url value="/CSS/botao.css" />">
<link rel="stylesheet" href="<c:url value="/CSS/.css" />">
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url var="url" value ="/logout"/>
		
		<div class="index">
		<h2>Bem Vindo</h2>
		<table>
			<tr>
        		<td colspan="2" style="text-align: right">${sessaoUsuario.login.usuario}
        		<a href="${url}" target="_self" class="btn">Sair</a></td>
      		</tr>
      	</table>	
				
		<%if(session.getAttribute("telaPrincipal")=="Cliente"){ %>
			<c:import url="telaCliente.jsp"></c:import>
		<%}else if(session.getAttribute("telaPrincipal")=="Funcionario"){%>	
			<c:import url="telaFuncionario.jsp"></c:import>
		<%} else if(session.getAttribute("telaPrincipal")=="Gerente"){%>	
			 <c:import url="telaGerente.jsp"></c:import>
		<%} else if(session.getAttribute("telaPrincipal")=="Admin"){%>	
		 <c:import url="telaAdmin.jsp"></c:import>
		<%}%>
		</div>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>