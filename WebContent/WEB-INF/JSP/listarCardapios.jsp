<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.Produto, model.Cardapio"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Cardapios </title>
<link href="CSS/botao.css" style="text" rel="stylesheet">
<link href="CSS/Cardápio.css" style="text" rel="stylesheet">
</head>
<body>
	<%@ include file="../HTML/cabecalho.html"%>
	<c:url  var = "url" value ="/produtoController/criar"/>
	<c:url var= "urlFiltro" value="/produtoController/filtrar"/>
	<c:url var= "urlIndex" value="/funcionarioController/index"/>
	
	<br />
		<div class="cardapio1">
		<h2>Cardápio</h2>
		<form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
			<div class="linha">
    	<label>Filtrar por:</label>
    		<filter class="filter" id="filter">
				<form:input path ="nome" placeholder="Nome" type="text" min="0" size="25" maxlength="25"/>
			</filter>
			<form:select path="categoria" items="${selectCategoria}"></form:select>
        </form:form>
        <label>Status:</label>   
    		<pesquisa class="pesquisa" id="pesquisa">
				<input type="submit" onClick="" value="Pesquisar">
			</pesquisa>
        </div>
        
		<div class="novo">
		<a href='${urlIndex}' target="_self" class="btn">Home</a>
   		<a href="${url}" target="_self" class="btn">Novo Cardapio</a>
   		</div>
	
    	<div class="tabela">
    		<table width="100%" border="1">
    			<tbody>
    				<tr>
        				<td>Nome</td>
        				<td>Preço</td>
        				<td>Situação</td>
        				<td>Categoria</td>
        				<td>Promoção</td>
                    	<td>Ações</td>
        			</tr>
			
			<c:forEach var ="c" items= "${cardapios}">
			    	<tr>
        				<td>${c.nome} </td>
						<td>${c.preco}</td>
						<td><c:choose>
								<c:when test ="${c.isAtivo}"><c:out value ="Ativo"/></c:when>
								<c:otherwise><c:out value ="Desativo"/></c:otherwise>
							</c:choose>
						</td>			
						<td>${c.categoria}</td>
						<td>${c.promocao}</td>
					<td>
						<a href='<c:url value="/produtoController/${c.id}/atualizar"/>'>Editar</a>
						<a href='<c:url value ="/produtoController/${c.id}/remover"/>'>remover</a>
						
					</td>
        			</tr>
 			</c:forEach>				
			</tbody>        
		</table>
		</div>
		</div>

		<%@ include file="../HTML/rodape.html"%>
</body>
</html>