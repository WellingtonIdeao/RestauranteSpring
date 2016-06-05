package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Categoria;
import service.CategoriaService;

@Controller
@RequestMapping("/categoriaController")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Categoria> categorias = catService.listar();
		map.addAttribute("categorias", categorias);
		map.addAttribute("filtro", new Categoria());
		return "listarCategorias";
	  
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		map.addAttribute("categoria",new Categoria());
		return "cadastroCategoria";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(@ModelAttribute("categoria") Categoria cat){
		
		if(cat.getId()>0){
			catService.atualizar(cat);
		}
		else{
			catService.inserir(cat);
		}
		return "redirect:/categoriaController/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
	public String update(@PathVariable Long id, ModelMap map){
		Categoria cat = new Categoria();
		cat.setId(id);
		cat = catService.buscar(cat);
		map.addAttribute("categoria", cat);
		return "cadastroCategoria";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
	public String remove(@PathVariable Long id, ModelMap map){
		Categoria cat = new Categoria();
		cat.setId(id);
		cat = catService.buscar(cat);
		catService.remover(cat);
		return "redirect:/categoriaController/listar";
	}
	
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Categoria cat, ModelMap map){
		List<Categoria> categorias = catService.buscarFiltro(cat);
		map.addAttribute("categorias",categorias);
		map.addAttribute("filtro",cat);
		return "listarCategorias";
	}
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(){
			return "index";
	}

}
