package controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Cardapio;
import model.Cliente;
import model.Delivery;
import model.ItemPedido;
import model.Produto;
import model.ProdutoEditor;
import model.Status;
import model.Usuario;
import service.DeliveryService;
import service.ProdutoService;

@Controller
@RequestMapping("/deliveryController")
public class DeliveryController {
	@Autowired
	ProdutoService produtService;
	@Autowired
	DeliveryService delService;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Delivery> deliverys = delService.listar();
		map.addAttribute("deliverys",deliverys);
		map.addAttribute("filtro",new Delivery());
		return "listarDeliverys";
	  
	}
	@RequestMapping(value="{id}/listarPorCliente", method = RequestMethod.GET)
	public String list(ModelMap map, @PathVariable Long id) {
		Usuario user = new Cliente();
		user.setId(id);
		Delivery delivery = new Delivery();
		delivery.setStatus(Status.TODOS);
		List<Delivery> deliverys = delService.listarPorCliente(user);
		map.addAttribute("deliverys",deliverys);
		map.addAttribute("selectStatus",selectStatus());
		
		map.addAttribute("filtro",delivery);
		return "listarDeliverys";
	  
	}
	@RequestMapping(value="addItem", method = RequestMethod.GET)
	public String addItemCarrinho(@ModelAttribute ("itempedido") ItemPedido item, ModelMap map,HttpSession session){

		 
		Delivery delivery =(Delivery) session.getAttribute("sessaoCarrinhoDelivery");
		if(delivery ==null){
			delivery = new Delivery();
			session.setAttribute("sessaoCarrinhoDelivery", delivery);
		}
		
		delivery.addProduto(item.getQtd(),item.getProduto());
		
		map.addAttribute("itempedido",new ItemPedido());
		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		map.addAttribute("delivery",delivery);
		return "efetuarDelivery";
	
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		
		map.addAttribute("itempedido",new ItemPedido());
		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		Delivery delivery = new Delivery();
		map.addAttribute("delivery",delivery);
		return "efetuarDelivery";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(HttpSession session, @ModelAttribute Delivery delivery){
		Delivery del = (Delivery) session.getAttribute("sessaoCarrinhoDelivery");
		Cliente c = null;
		if(del!=null){
			c=	(Cliente) session.getAttribute("sessaoUsuario");
			if(c!=null){
				del.setCliente(c);
				del.setTipo(delivery.getTipo());
				del.setTrocoPara(delivery.getTrocoPara());
				delService.inserir(del);
			}	
		}
		session.removeAttribute("sessaoCarrinhoDelivery");
		return "redirect:/deliveryController/"+c.getId()+"/listarPorCliente";
	}
	
	@RequestMapping(method =RequestMethod.GET, value="{count}/remover")
	public String remove(@PathVariable int count, ModelMap map, HttpSession sessao){
		Delivery delivery =  (Delivery)sessao.getAttribute("sessaoCarrinhoDelivery");
		if(delivery== null){
			
			delivery = new Delivery();
			sessao.setAttribute("sessaoCarrinhoDelivery",delivery);
		}	
		delivery.removerProduto(count-1);
		map.addAttribute("itempedido",new ItemPedido());

		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		map.addAttribute("delivery", delivery);
		return "efetuarDelivery";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)     {
	      binder.registerCustomEditor(Produto.class, new ProdutoEditor(produtService));
	      
	}
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(){
			return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/detalhe")
	public String detail(@PathVariable long id, ModelMap map){
		Delivery delivery = new Delivery();
		delivery.setId(id);
		delivery = delService.buscar(delivery);
		map.addAttribute("delivery",delivery);
		return "detalharDelivery";
	}
	public List<Produto> produtos(){
		 List<Produto> prts = produtService.listar();
		 return prts;
	}
	
	@RequestMapping(value="{id}/filtrar",method=RequestMethod.GET)
	public String filtrar(@PathVariable Long id, @ModelAttribute("filtro")Delivery del, ModelMap map){
		Cliente c = new Cliente();
		c.setId(id);
		del.setCliente(c);
		List<Delivery> deliverys = delService.buscarFiltroDelivery(del);
		map.addAttribute("deliverys",deliverys);
		map.addAttribute("selectStatus",selectStatus());
		map.addAttribute("filtro",del);
		return "listarDeliverys";
	}
	
	public Map<String,String> selectStatus(){
		Map<String,String> mapa = new TreeMap<>();
		for(Status s: Status.values()){
			mapa.put(s.name(),s.name());
		}
		return mapa;
	}

}
