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
<title>Pedido tradicional</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<c:url var="url" value ="/tradicionalController/addItem"/>		
		<c:url var="urlfinalizar" value ="/tradicionalController/salvar"/>
		<h1>Novo Pedido Tradicional</h1>
		<br>
				
		<form:form method='get' action='${url}' modelAttribute = "itempedido">
			<table>
				<tr> 
					<td>Produto<form:select path="produto">
								<c:forEach var ="p" items= "${produtos}"> 	
									<form:option value ='${p.id}' label='${p}'> </form:option>					 
								</c:forEach>
							</form:select>
							<form:input path="qtd" type='text' name ="qtd"/>	
							<input type='submit' value='adicionar item' />
								
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
				
				 
				<c:forEach var ="i" items="${tradicional.itens}" varStatus="c">
			<tr>
				<td>${i.produto}</td>	
				<td>${i.qtd}</td>
				<td>R$: ${i.subTotal()}</td>
				<td><a href ="<c:url value ="/tradicionalController/${c.count}/remover"/>">Excluir</a></td>					
			</tr>
				</c:forEach>
			<tr>
				<td>Valor Total</td>
				<td>${tradicional.total()}</td>
				<td></td>
				<td><a href ='<c:url value="/tradicionalController/listar"/>'>Voltar</a></td>						
			</tr>

		</table>
								
		
		<form:form method = "post" action="${urlfinalizar}" modelAttribute = "tradicional" >
			<table>
				<tr>
					<td>Mesa:<form:select path ="mesa.id" items="${selectMesas}"></form:select></td>
					<td>Status:<form:select path ="status" items="${selectStatus}"></form:select></td>
				</tr>
				<tr>
					<td><input type = "submit" value="Finalizar Pedido"></td>
					<td><a href='<c:url value="/tradicionalController/listar"/>'>Voltar</a></td>	
				</tr>
				
			</table>
		</form:form>		
			
		<%@ include file="../HTML/rodape.html"%>
		
</body>
</html>