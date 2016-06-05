package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Cliente;
import service.ClienteService;

@Controller
@RequestMapping("/clienteController")
public class ClienteController {
	@Autowired
	private ClienteService cService;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Cliente> clientes = cService.listar();
		map.addAttribute("clientes", clientes);
		map.addAttribute("filtro", new Cliente());
		return "listarClientes";
	  
	}
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		map.addAttribute("cliente",new Cliente());
		return "cadastroCliente";
	}
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(@ModelAttribute("cliente") Cliente c){
		
		if(c.getId()>0){
			cService.atualizar(c);
		}
		else{
			try {
				cService.inserir(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/clienteController/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
	public String update(@PathVariable Long id, ModelMap map){
		Cliente c = new Cliente();
		c.setId(id);
		c = cService.buscar(c);
		map.addAttribute("cliente", c);
		return "cadastroCliente";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
	public String remove(@PathVariable Long id, ModelMap map){
		Cliente c = new Cliente();
		c.setId(id);
		c = cService.buscar(c);
		cService.remover(c);
		return "redirect:/clienteController/listar";
	}
	
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Cliente c, ModelMap map){
		List<Cliente> clientes = cService.buscarFiltro(c);
		map.addAttribute("clientes",clientes);
		map.addAttribute("filtro",c);
		return "listarClientes";
	}
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(){
			return "index";
	}

}
