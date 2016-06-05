package controller;

import java.util.ArrayList;
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
import model.Delivery;
import model.Funcionario;
import model.ItemPedido;
import model.Mesa;
import model.Pedido;
import model.Produto;
import model.ProdutoEditor;
import model.Status;
import model.Tradicional;
import service.DeliveryService;
import service.MesaService;
import service.ProdutoService;
import service.TradicionalService;

@Controller
@RequestMapping("/tradicionalController")
public class TradicionalController {
	@Autowired
	private ProdutoService produtService;
	@Autowired
	private TradicionalService tradService;
	@Autowired
	private MesaService mesaService;
	@Autowired
	private DeliveryService delService;
	
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Tradicional> tradicionais = tradService.listar();
		List<Delivery> deliverys = delService.listar(); 
		List<Pedido> pedidos = new ArrayList<>();
			pedidos.addAll(tradicionais);
			pedidos.addAll(deliverys);
		map.addAttribute("selectTipos",selectTipos());
		map.addAttribute("selectStatus",TradicionalController.selectStatus());
		map.addAttribute("pedidos",pedidos);
		map.addAttribute("filtro", new Delivery());
		
		return "listarTradicional";
	  
	}
	@RequestMapping(value="addItem", method = RequestMethod.GET)
	public String addItemCarrinho(@ModelAttribute ("itempedido") ItemPedido item, ModelMap map,HttpSession session){

		 
		Tradicional tradicional =(Tradicional) session.getAttribute("sessaoCarrinhoTradicional");
		if(tradicional ==null){
			tradicional = new Tradicional();
			session.setAttribute("sessaoCarrinhoTradicional",tradicional) ;
		}
		
		tradicional.addProduto(item.getQtd(),item.getProduto());
		
		map.addAttribute("itempedido",new ItemPedido());
		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		map.addAttribute("tradicional",tradicional);
		map.addAttribute("selectMesas",selectMesas());
		map.addAttribute("selectStatus",TradicionalController.selectStatus());
		return "efetuarTradicional";
	
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map, HttpSession session){
		
		Tradicional tradicional =(Tradicional) session.getAttribute("sessaoCarrinhoTradicional");
		if(tradicional ==null){
			tradicional = new Tradicional();
			session.setAttribute("sessaoCarrinhoTradicional",tradicional) ;
		}
		map.addAttribute("itempedido",new ItemPedido());
		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		map.addAttribute("tradicional",tradicional);
		map.addAttribute("selectMesas",selectMesas());
		map.addAttribute("selectStatus",TradicionalController.selectStatus());
		return "efetuarTradicional";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(HttpSession session, @ModelAttribute ("tradicional") Tradicional tradicional){
		Tradicional trad = (Tradicional) session.getAttribute("sessaoCarrinhoTradicional");
		Funcionario f = null;
		if(trad!=null){
			f=	(Funcionario) session.getAttribute("sessaoUsuario");
			if(f!=null){
				trad.setandoMesa(tradicional.getMesa());
				trad.setStatus(tradicional.getStatus());
				trad.setFuncionario(f);
				
				tradService.inserir(trad);
			}	
		}
		session.removeAttribute("sessaoCarrinhoTradicional");
		return "redirect:/tradicionalController/criar";
	}
	
	@RequestMapping(method =RequestMethod.GET, value="{count}/remover")
	public String remove(@PathVariable int count, ModelMap map, HttpSession sessao){
		Tradicional tradicional =  (Tradicional)sessao.getAttribute("sessaoCarrinhoTradicional");
		if(tradicional== null){
			tradicional = new Tradicional();
			sessao.setAttribute("sessaoCarrinhoTradicional",tradicional);
		}	
		tradicional.removerProduto(count-1);
		map.addAttribute("itempedido",new ItemPedido());

		map.addAttribute("produtos",produtos());
		map.addAttribute("produto",new Cardapio());
		map.addAttribute("tradicional", tradicional);
		return "efetuarTradicional";
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
		Tradicional tradicional = new Tradicional();
		tradicional.setId(id);
		tradicional = tradService.buscar(tradicional);
		map.addAttribute("tradicional",tradicional);
		return "detalharTradicional";
	}
	public List<Produto> produtos(){
		 List<Produto> prts = produtService.listar();
		 return prts;
	}
	public Map<Long,String> selectMesas(){
		List<Mesa> mesas = mesaService.listar();
		Map<Long,String> mapa = new TreeMap<Long,String>();
		mapa.put(0L, "selecione");
		for(Mesa m: mesas){
			mapa.put(m.getId(), m.getDescricao());
		}
		return mapa;
	}
	public static Map<Status,String> selectStatus(){
		Map<Status, String> mapa = new TreeMap<Status,String>();
		mapa.put(Status.PENDENTE, "selecione");
		for(Status s: Status.values()){
			mapa.put(s, s.name());
		}
		return mapa;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/detalheTotal")
	public String detailTotal(@PathVariable Long id, ModelMap map){
		Tradicional tradicional = new Tradicional();
		tradicional.setId(id);
		tradicional = tradService.buscar(tradicional);
		if(tradicional!= null){
			map.addAttribute("pedido", tradicional);
		}else{
			Delivery delivery = new Delivery();
			delivery.setId(id);
			delivery = delService.buscar(delivery);
			map.addAttribute("pedido", delivery);
		}	
			return "detalharTradicional";
			
	}
	@RequestMapping(method =RequestMethod.GET, value= "{id}/atender")
	public String atender(@PathVariable Long id){
		Delivery delivery = new  Delivery();
		delivery.setId(id);
		delivery = delService.buscar(delivery);
		if(delivery!= null){
			delivery.setStatus(Status.ATENDIDO);
			delService.atualizar(delivery);
		}	
		
		return"redirect:/tradicionalController/listar";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/cancelar")
	public String cancelar(@PathVariable Long id){
		Delivery delivery = new  Delivery();
		delivery.setId(id);
		delivery = delService.buscar(delivery);
		if(delivery!= null){
			delivery.setStatus(Status.CANCELADO);
			delService.atualizar(delivery);
		}else{
			Tradicional tradicional = new  Tradicional();
			tradicional.setId(id);
			tradicional = tradService.buscar(tradicional);
			tradicional.setStatus(Status.CANCELADO);
			tradService.atualizar(tradicional);
		}	
		return "redirect:/tradicionalController/listar";
	}
	public Map <String ,String> selectTipos(){
		List<Tradicional> tradicionais = tradService.listar();
		List<Delivery> deliverys = delService.listar(); 
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.addAll(tradicionais);
		pedidos.addAll(deliverys);
		Map <String ,String> mapa = new TreeMap<String, String>();
		mapa.put("", "Todos");
		for(Pedido ped:pedidos){
			mapa.put(ped.toString(),ped.toString());
		}
		return mapa;
	}
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Delivery filtro, ModelMap map){
		
		List<Pedido> pedidos = null;		
		pedidos = delService.buscarFiltro(filtro);
		if(pedidos.isEmpty())
			pedidos = tradService.buscarFiltro(filtro);
		if(pedidos.isEmpty()||filtro.getId()==0){
			List<Tradicional> tradicionais = tradService.listar();
			List<Delivery> deliverys = delService.listar();
			pedidos = new ArrayList<>();
			pedidos.addAll(tradicionais);
			pedidos.addAll(deliverys);
		}	
		map.addAttribute("pedidos",pedidos);
		map.addAttribute("filtro",filtro);
		return "listarTradicional";
	}
	
	
}
