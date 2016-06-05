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
<title>Detalhe delivery</title>
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<h1>Detalhe pedido</h1>	
       <a>Número: ${delivery.id} Tipo: ${delivery} Status: ${delivery.status} Troco para: R$ ${delivery.trocoPara}</a>  		
	
	<table>
    		<tr>
       			<td>Código</td>
       			<td>Descrição</td>
       			<td>Quantidade</td>
       			<td>Total</td>
       		</tr>
			
			<c:forEach var ="i" items= "${delivery.itens}">
			    	<tr>
        				<td>${i.produto.id} </td>
        				<td>${i.produto.nome}</td>
						<td>${i.qtd}</td>
						<td>R$: ${i.subTotal()}</td>
						
        			</tr>
 			</c:forEach>
 				<tr>
 					<td></td>
 					<td></td>
 					<td></td>
					<td><a href='<c:url value="/deliveryController/${sessaoUsuario.id}/listarPorCliente"/>'>Voltar</a><td>
				</tr>					       
		</table>
	<%@ include file="../HTML/rodape.html"%>
</body>
</html>