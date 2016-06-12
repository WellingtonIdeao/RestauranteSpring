package interceptors;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import model.Cliente;
import model.Funcionario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override 
	 public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object controller) throws  	Exception{

	       HttpSession session = req.getSession();
	       Map<String, String> urls = null;	      
	       String uri = req.getRequestURI(); 
	       
	       if(uri.endsWith("loginForm")|| uri.endsWith("logar")|| uri.endsWith("clienteController/criar") ||uri.endsWith("clienteController/salvar")){
	           return true; 
	       }
    	  
	       if(session.getAttribute("sessaoUsuario") != null ) {
	    	   	urls = urlPermitidas(session);
	    	   for(String u: urls.values()){
	    		   if(urlIsValid(uri, u))
	    			   return true;
	    	   }   
	       } 
	       
	       resp.sendRedirect("/RestauranteManager/loginForm"); 
	       return false; 
	   }
		
	public Map<String, String> urlPermitidas(HttpSession session){
		Map<String, String> urls = new TreeMap<String, String>();
		
			if(session.getAttribute("sessaoUsuario") instanceof Funcionario){
				Funcionario f = (Funcionario) session.getAttribute("sessaoUsuario");
				if(f.getCargo().name().equals("GERENTE")||f.getCargo().name().equals("ADMIN")){
					
					if(f.getCargo().name().equals("GERENTE")){
						
						urls.put("listarFuncionarios","/gerenteController/listar");
						urls.put("criarFuncionarios","/gerenteController/criar");
						urls.put("removFuncionario","/gerenteController/[0-9]+/remover");
						urls.put("updateFuncionario","/gerenteController/[0-9]+/atualizar");
						urls.put("funcionarioFiltro","/gerenteController/filtrar");
						urls.put("salvarFuncionario","/gerenteController/salvar");
					}
					if(f.getCargo().name().equals("ADMIN")){
						//FUNCIONARIO
						urls.put("listarFuncionarios","/funcionarioController/listar");
						urls.put("criarFuncionarios","/funcionarioController/criar");
						urls.put("removFuncionario","/funcionarioController/[0-9]+/remover");
						urls.put("updateFuncionario","/funcionarioController/[0-9]+/atualizar");
						urls.put("funcionarioFiltro","/funcionarioController/filtrar");
						urls.put("salvarFuncionario","/funcionarioController/salvar");
						//RESERVA
						urls.put("reservas","/reservaController/listar");
						urls.put("removReserva","/reservaController/[0-9]+/remover");
						urls.put("salvarReservas","/reservaController/salvar");
						urls.put("criarReservas","/reservaController/criar");
						urls.put("reservaFiltro","/reservaController/filtrar");
						urls.put("indexReserva","/reservaController/index");
						
						//PEDIDOS
						urls.put("listarPedidos","/tradicionalController/listar");
						urls.put("criarPedidos","/tradicionalController/criar");
						urls.put("addItemTradicional","/tradicionalController/addItem");
						urls.put("removItemTradicional","/tradicionalController/[0-9]+/remover");
						urls.put("efetuarTradicional","/tradicionalController/salvar");
						urls.put("pedidosFiltro","/tradicionalController/filtrar");
						urls.put("indexPedido","/tradicionalController/index");
						urls.put("detalharPedidos","/tradicionalController/[0-9]+/detalheTotal");
						urls.put("cancelarPedido","/tradicionalController/[0-9]+/cancelar");
						urls.put("atenderPedido","/tradicionalController/[0-9]+/atender");
						
						//CLIENTE
						urls.put("listarClientes","/clienteController/listar"); //clienteController/criar já é permitido
						urls.put("removCliente","/clienteController/[0-9]+/remover");
						urls.put("updateCliente","/clienteController/[0-9]+/atualizar");
						urls.put("clientesFiltro","/clienteController/filtrar");
											
					}	
					// GERENTE E ADMIN
					
					//PRODUTO
					urls.put("listarProdutos","/produtoController/listar");
					urls.put("criarProdutos","/produtoController/criar");
					urls.put("removProdutos","/produtoController/[0-9]+/remover");
					urls.put("updateProdutos","/produtoController/[0-9]+/atualizar");
					urls.put("produtofiltro","/produtoController/filtrar");
					urls.put("salvarProduto","/produtoController/salvar");
					// CATEGORIA
					urls.put("listarCategorias","/categoriaController/listar");
					urls.put("criarCategorias","/categoriaController/criar");
					urls.put("removCategorias","/categoriaController/[0-9]+/remover");
					urls.put("updateCategorias","/categoriaController/[0-9]+/atualizar");
					urls.put("categoriaFiltro","/categoriaController/filtrar");
					urls.put("salvarCategoria","/categoriaController/salvar");
					urls.put("indexCategoria","/categoriaController/index");
					//MESA
					urls.put("listarMesa","/mesaController/listar");
					urls.put("criarMesa","/mesaController/criar");
					urls.put("indexMesa","/mesaController/index");
					urls.put("removMesas","/mesaController/[0-9]+/remover");
					urls.put("updateMesas","/mesaController/[0-9]+/atualizar");
					urls.put("mesaFiltro","/mesaController/filtrar");
					urls.put("salvarMesa","/mesaController/salvar");
					urls.put("mesaAtivar","/mesaController/[0-9]+/disposicao/true");
					urls.put("mesaInativar","/mesaController/[0-9]+/disposicao/false");
					
				}else{
				// OUTROS FUNCIONARIOS
					
				//PEDIDOS
				urls.put("listarPedidos","/tradicionalController/listar");
				urls.put("criarPedidos","/tradicionalController/criar");
				urls.put("addItemTradicional","/tradicionalController/addItem");
				urls.put("removItemTradicional","/tradicionalController/[0-9]+/remover");
				urls.put("efetuarTradicional","/tradicionalController/salvar");
				urls.put("pedidosFiltro","/tradicionalController/filtrar");
				urls.put("indexPedido","/tradicionalController/index");
				urls.put("detalharPedidos","/tradicionalController/[0-9]+/detalheTotal");
				urls.put("cancelarPedido","/tradicionalController/[0-9]+/cancelar");
				urls.put("atenderPedido","/tradicionalController/[0-9]+/atender");
				//RESERVA
				urls.put("reservas","/reservaController/listar");
				urls.put("removReserva","/reservaController/[0-9]+/remover");
				urls.put("salvarReservas","/reservaController/salvar");
				urls.put("criarReservas","/reservaController/criar");
				urls.put("reservaFiltro","/reservaController/filtrar");
				urls.put("indexReserva","/reservaController/index");
				//CLIENTE
				urls.put("listarClientes","/clienteController/listar"); //clienteController/criar já é permitido
				urls.put("removCliente","/clienteController/[0-9]+/remover");
				urls.put("updateCliente","/clienteController/[0-9]+/atualizar");
				urls.put("clientesFiltro","/clienteController/filtrar");
				
				}
				urls.put("indexCliente","/clienteController/index");
				urls.put("indexFuncionario","/funcionarioController/index");
				urls.put("sair","/logout");
			}
			if(session.getAttribute("sessaoUsuario") instanceof Cliente){
				//Delivery
				urls.put("listarDeliverys","/deliveryController/[0-9]+/listar");
				urls.put("detalharPedidos","/deliveryController/[0-9]+/detalhe");
				urls.put("sair","/logout");
				urls.put("criarDelivery","/deliveryController/criar");
				urls.put("salvarDelivery","/deliveryController/salvar");
				urls.put("addItemDelivery","/deliveryController/addItem");
				urls.put("removItemDelivery","/deliveryController/[0-9]+/remover");
				urls.put("indexDelivery","/deliveryController/index");
				urls.put("deliveryFiltro","/deliveryController/[0-9]+/filtrar");
				
			}
			return urls;
	}
	public boolean urlIsValid(String uri, String url){
		boolean isUrl =urlRegex(uri,url); // RETORNA TRUE SE REGEX == URL 
	    
		 if(isUrl)
	    	return true;
		if(url.contains("filtrar?")){
			return uri.contains(url);
		}	
		return uri.endsWith(url);
	}
	public boolean urlRegex(String uri,String regex){ //TESTA REGEX == URL
		 Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(uri.toString());
	        
	    if(matcher.find())
	    	return true;
	    else
	    	return false;
	}
}
