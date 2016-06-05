package controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import model.Categoria;
import model.CategoriaEditor;
import model.Produto;
import model.Promocao;
import model.PromocaoEditor;
import service.CategoriaService;
import service.ProdutoService;
import service.PromocaoService;

@Controller
@RequestMapping("/produtoController")
public class ProdutoController {
	@Autowired
	private ProdutoService produtService;
	@Autowired
	private CategoriaService catService;
	@Autowired
	private PromocaoService promoService;
	
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Produto> cardapios = produtService.listar();
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("selectCategoria",selectCategoria());
		map.addAttribute("filtro",new Cardapio());
		return "listarCardapios";
	  
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		List<Categoria> categorias = catService.listar();
		List<Promocao> promocoes = promoService.listar();
		map.addAttribute("categorias", categorias);
		map.addAttribute("promocoes", promocoes);
		map.addAttribute("cardapio",new Cardapio());
		return "cadastroCardapio";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(@ModelAttribute("cardapio") Cardapio card){
		if(card.getId()>0){
			produtService.atualizar(card);
		}
		else{
			produtService.inserir(card);
		}
		return "redirect:/produtoController/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
	public String update(@PathVariable Long id, ModelMap map){
		Produto card = new Cardapio();
		card.setId(id);
		card = produtService.buscar(card);
		List<Categoria> categorias = catService.listar();
		List<Promocao> promocoes = promoService.listar();
		map.addAttribute("categorias", categorias);
		map.addAttribute("promocoes", promocoes);
		map.addAttribute("cardapio", card);
		return "cadastroCardapio";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
	public String remove(@PathVariable Long id, ModelMap map){
		Cardapio card = new Cardapio();
		card.setId(id);
		card = (Cardapio) produtService.buscar(card);
		produtService.remover(card);
		return "redirect:/produtoController/listar";
	}
	
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Cardapio card, ModelMap map){
		List<Produto> cardapios = produtService.buscarFiltro(card);
		map.addAttribute("cardapios",cardapios);
		map.addAttribute("selectCategoria",selectCategoria());
		map.addAttribute("filtro",card);
		return "listarCardapios";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)     {
	      binder.registerCustomEditor(Promocao.class, new PromocaoEditor(promoService));
	      binder.registerCustomEditor(Categoria.class, new CategoriaEditor(catService));
	}
	public Map<Long,String> selectCategoria(){
		Map<Long,String> mapa = new TreeMap<>();
		List<Categoria> categorias = catService.listar();
		for(Categoria cat: categorias){
			mapa.put(cat.getId(),cat.getNome());
		}	
		return mapa;
	}

}
