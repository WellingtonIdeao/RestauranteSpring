package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Promocao;
import service.PromocaoService;

@Controller
@RequestMapping("/promocaoController")
public class PromocaoController {
		
		@Autowired
		private PromocaoService promoService;
		
		@RequestMapping(value="listar", method = RequestMethod.GET)
		public String list(ModelMap map) {
			List<Promocao> promocoes = promoService.listar();
			map.addAttribute("promocoes", promocoes);
			map.addAttribute("filtro",new Promocao());
			return "listarPromocoes";
		  
		}
		@RequestMapping(value ="criar",method = RequestMethod.GET)
		public String create(ModelMap map){
			map.addAttribute("promocao",new Promocao());
			return "cadastroPromocao";
		}
		@RequestMapping(value ="salvar",method = RequestMethod.POST)
		public String save(@ModelAttribute("promocao") Promocao pro){
			
			if(pro.getId()>0){
				promoService.atualizar(pro);
			}
			else{
				promoService.inserir(pro);
			}
			return "redirect:/promocaoController/listar";
		}
		
		@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
		public String update(@PathVariable Long id, ModelMap map){
			Promocao pro = new Promocao();
			pro.setId(id);
			pro = promoService.buscar(pro);
			map.addAttribute("promocao", pro);
			return "cadastroPromocao";
		}
		@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
		public String remove(@PathVariable Long id, ModelMap map){
			Promocao pro = new Promocao();
			pro.setId(id);
			pro = promoService.buscar(pro);
			promoService.remover(pro);
			return "redirect:/promocaoController/listar";
		}
		
		@RequestMapping(value="filtrar",method=RequestMethod.GET)
		public String filtrar(@ModelAttribute("filtro")Promocao pro, ModelMap map){
			List<Promocao> promocoes = promoService.buscarFiltro(pro);
			map.addAttribute("promocoes",promocoes);
			map.addAttribute("filtro",pro);
			return "listarPromocoes";
		}
		
}
