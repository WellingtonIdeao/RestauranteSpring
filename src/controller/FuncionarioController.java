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

import model.Cargo;
import model.Funcionario;
import service.FuncionarioService;

@Controller
@RequestMapping("/funcionarioController")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value="listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Funcionario> funcionarios = funcionarioService.listar();
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", new Funcionario());
		return "listarFuncionarios";
	  
	}
	
	@RequestMapping(value ="criar",method = RequestMethod.GET)
	public String create(ModelMap map){
		map.addAttribute("funcionario",new Funcionario());
		map.addAttribute("selectCargo",FuncionarioController.selectCargo());
		return "cadastroFuncionario";
	}
	
	@RequestMapping(value ="salvar",method = RequestMethod.POST)
	public String save(@ModelAttribute("funcionario") Funcionario f){
		
		if(f.getId()>0){
			funcionarioService.atualizar(f);
		}
		else{
			try {
				funcionarioService.inserir(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/funcionarioController/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
	public String update(@PathVariable Long id, ModelMap map){
		Funcionario f = new Funcionario();
		f.setId(id);
		f = funcionarioService.buscar(f);
		map.addAttribute("funcionario", f);	
		map.addAttribute("selectCargo",FuncionarioController.selectCargo());
		return "cadastroFuncionario";
	}
	@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
	public String remove(@PathVariable Long id, ModelMap map){
		Funcionario f = new Funcionario();
		f.setId(id);
		f = funcionarioService.buscar(f);
		funcionarioService.remover(f);
		return "redirect:/funcionarioController/listar";
	}
	
	@RequestMapping(value="filtrar",method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro")Funcionario f, ModelMap map){
		List<Funcionario> funcionarios = funcionarioService.buscarFiltro(f);
		map.addAttribute("funcionarios",funcionarios);
		map.addAttribute("filtro",f);
		return "listarFuncionarios";
	}
	
	public static Map<Cargo, String> selectCargo(){
	
		Map<Cargo, String> mapa = new TreeMap<Cargo, String>();
		for ( Cargo c: Cargo.values()) {
				mapa.put(c,c.name());	
		}
		return mapa;
	}
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(){
			return "index";
	}

	

}
