<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "model.Usuario"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/Index.css" style="text" rel="stylesheet">

</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		
		<%Usuario userLogado  = (Usuario)session.getAttribute("userLogado");
			session = request.getSession();
			if(session.getAttribute("userLogado")== null){%>
				request.getRequestDispatcher("login").forward(request, response);
		<%} 
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem != null){%>		
			<script>
				alert('<%=mensagem%>');
			</script> 		
		<%}%>
		
		<div class="index">
		<h2>Bem Vindo</h2>
		<table>
			<tr>
        		<td colspan="2" style="text-align: right"><%=userLogado%>
        		<a href="logoutServlet" target="_self" class="btn">Sair</a></td>
      		</tr>
      	</table>	
			
				
		<%if(session.getAttribute("telaPrincipal")=="Cliente"){ %>
		<%@include file ="telaCliente.jsp"%>
			
		<%}else if(session.getAttribute("telaPrincipal")=="Funcionario"){%>	
			<%@include file ="telaFuncionario.jsp"%>
		<%}%>
		</div>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>