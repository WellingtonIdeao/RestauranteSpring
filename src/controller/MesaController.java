package controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Mesa;
import service.MesaService;

@Controller
@RequestMapping("/mesaController")
public class MesaController {
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Mesa> mesas = mesaService.listar();
		map.addAttribute("mesas", mesas);
		map.addAttribute("selectIsReserva",selectIsReserva());
		map.addAttribute("filtro", new Mesa());
		return "listarMesas";
	  
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		map.addAttribute("mesa",new Mesa());
		return "cadastroMesa";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(@ModelAttribute("mesa") Mesa m){
		
		if(m.getId()>0){
			mesaService.atualizar(m);
		}
		else{
			try {
				mesaService.inserir(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/mesaController/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
	public String update(@PathVariable Long id, ModelMap map){
		Mesa m = new Mesa();
		m.setId(id);
		m = mesaService.buscar(m);
		map.addAttribute("mesa", m);
		return "cadastroMesa";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
	public String remove(@PathVariable Long id, ModelMap map){
		Mesa m = new Mesa();
		m.setId(id);
		m = mesaService.buscar(m);
		mesaService.remover(m);
		return "redirect:/mesaController/listar";
	}
	
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Mesa m, ModelMap map){
		List<Mesa> mesas = mesaService.buscarFiltro(m);
		map.addAttribute("mesas",mesas);
		map.addAttribute("selectIsReserva",selectIsReserva());
		map.addAttribute("filtro",m);
		return "listarMesas";
	}
	@RequestMapping(value="{id}/disposicao/{isAtivo}",method=RequestMethod.GET)
	public String disposicao(@PathVariable long id,@PathVariable boolean isAtivo){
		Mesa m = new Mesa();
		m.setId(id);
		m = mesaService.buscar(m);
		m.setIsAtivo(isAtivo);
		mesaService.atualizar(m);
		return "redirect:/mesaController/listar";	
	}
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(){
			return "index";
	}
	public Map<Boolean,String> selectIsReserva(){
		 Map<Boolean,String> mapa = new TreeMap<>();
		 mapa.put(true,"sim");
		 mapa.put(false,"nao");
		return mapa;
	}

}
