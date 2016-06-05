<%@page import="jdk.nashorn.internal.runtime.RewriteException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Delivery, model.Produto,model.Cardapio,model.ItemPedido,java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido Delivery</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url var="url" value ="/deliveryController/addItem"/>		
		<c:url var="urlfinalizar" value ="/deliveryController/salvar"/>		
		<c:url var="urlIndex" value ="/deliveryController/index"/>
		
		
		<form:form method='get' action='${url}' modelAttribute = "itempedido">
			<table>
				<tr> 
					<td>Produto<form:select path="produto">
								<c:forEach var ="p" items= "${produtos}"> 	
									<form:option value ='${p.id}' label='${p}'> </form:option>					 
								</c:forEach>
							</form:select>
							<form:input path="qtd" type='text' name ="qtd"/>	
							<input type='submit' value='adicionar' />
								
					</td>			 
				</tr>						
			</table> 			
		</form:form>	
	 	<table>
	 		<h2>Carrinho</h2>
			<tr>
				<td>Item</td>	
				<td>Quantidade</td>
				<td>Total</td>
				<td>Ações</td>					
			</tr>
				
				 
				<c:forEach var ="i" items="${delivery.itens}" varStatus="c">
			<tr>
				<td>${i.produto}</td>	
				<td>${i.qtd}</td>
				<td>R$: ${i.subTotal()}</td>
				<td><a href ='<c:url value ="/deliveryController/${c.count}/remover"/>'>Excluir</a></td>					
			</tr>
				</c:forEach>
			<tr>
				<td>Valor Total</td>
				<td>${delivery.total()}</td>
				<td></td>
				<td><a href ='<c:url value="/deliveryController/${sessaoUsuario.id}/listarPorCliente"/>'>Voltar</a></td>						
			</tr>

		</table>
		<form:form method= "post" action= "${urlfinalizar}" modelAttribute ="delivery">
			<form:hidden path="tipo"/>
			Pagamento: <form:input path="trocoPara"/>
			<input type = "submit" value="Finalizar Pedido">
		</form:form>
				
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>