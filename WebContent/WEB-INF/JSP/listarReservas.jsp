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
<title>Lista de Reservas</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url  var = "url" value ="/reservaController/criar"/>
		<c:url  var = "urlfiltro" value ="/reservaController/filtrar"/>
		<h1>Reservas</h1>
		<a href="${url}">Nova reserva</a><br>
		Filtrar por:
		<form:form method = "get" action="${urlfiltro}" modelAttribute = "filtro">
			<table>
				<tr>
					<td>Data Início:<form:input path ="horarioInicial"/></td>
					<td>Data Fim: <form:input path ="horarioFinal"/></td>
					<td>Mesa:
						<form:select path="mesa.id" items="${selectMesas}" ></form:select>
				    </td>
				</tr> 
				<tr>
					<td>Responsável:<form:input path ="responsavel"/></td>
				</tr>
				
			</table>
			<input type="submit" value="pesquisar" />
		</form:form>
		
		<table>
    			<tr>
    				<td>Data Início</td>
       				<td>Data Fim</td>
       				<td>Mesa</td>
       				<td>Responsável</td>
                   	<td>Ações</td>
       			</tr>
			
			<c:forEach var ="re" items= "${reservas}">
			    	<tr>
        				<td><fmt:formatDate type = "DATE" pattern="dd/MM/yyyy" value="${re.horarioInicial}"/></td>
        				<td><fmt:formatDate type= "DATE" pattern="dd/MM/yyyy" value="${re.horarioFinal}"/></td>
						<td>${re.mesa}</td>
						<td>${re.responsavel}</td>
						<td>
							<a href='<c:url value="/reservaController/${re.id}/remover"/>'>Excluir</a>
						</td>
        			</tr>
 			</c:forEach>
 					<tr>
 						<td><a href='<c:url value="/reservaController/index"/>'>Voltar</a></td>	
 					</tr>					       
		</table>
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>