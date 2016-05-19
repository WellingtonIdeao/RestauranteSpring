<%@page import="jdk.nashorn.internal.runtime.RewriteException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Delivery, model.Produto,model.Cardapio,model.ItemPedido,java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido Delivery</title>
</head>
<body>
		<%@ include file="../HTML/cabecalho.html"%>
		<%Delivery delivery = (Delivery)request.getAttribute("delivery");
			List<Produto> itens = (List<Produto>)request.getAttribute("produtos");
			
		%>
		
		<form method='get' action='carrinhoDeliveryServlet'>
			<table>
				<tr> 
					<td>Item <select name='itemSelected'>
								<% for(Produto p: itens){%>	
									<option value ="<%=p.getId()%>"><%=p%></option>					 
								<%}%>
								</select>
								<input type='text' name ="qtd" value ="" />	
								<input type='submit' value='adicionar' />
					</td>			 
				</tr>
							
		 
		</table> 			
		</form>	
	 	<table>
			<tr>
				<td>Item</td>	
				<td>Quantidade</td>
				<td>SubTotal</td>
				<td>Ações</td>					
			</tr>
				
				<% 
				for(ItemPedido item: delivery.getItens()){ %>
			<tr>
				<td><%=item.getProduto()%></td>	
				<td><%=item.getQtd()%></td>
				<td><%=item.subTotal()%></td>
				<td><a href ="removerCarrinhoServlet?index=<%=delivery.produtoPosition(item)%>">Excluir</a></td>					
			</tr>
				<%
				}%>
			<tr>
				<td>Valor Total</td>
				<td><%=delivery.total()%></td>
				<td></td>
				<td><a href ="index">Voltar</a></td>						
			</tr>

		</table>
		<form method= "post" action= "carrinhoDeliveryServlet">
			<input type = "hidden" name="finalizar" value ="<%=true%>">
			<input type = "submit" value="Finalizar Pedido">
		</form>
			
		
		
	<%--<form method='post' action='efetuarDeliveryServlet'>
		<table>
			<tr>
				<td>Itens<td>		
					<select name='itensSelected'>
						<% for(Produto p: itens){ %>
								<option value ="<%=p.getId()%>"><%=p.getNome()%></option>					 
						<%}%>		
					</select>
				<td><input type='submit' value='adicionar' /></td>
			</tr>
			<tr>
				<td><input type='submit' value='adicionar' /></td>
				<td></td>
			</tr>

		</table>
	</form>
	--%>	
		
		<%@ include file="../HTML/rodape.html"%>
</body>
</html>