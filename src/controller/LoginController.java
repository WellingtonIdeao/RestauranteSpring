package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Cliente;
import model.Funcionario;
import model.Usuario;
import service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/","loginForm"}, method=RequestMethod.GET)
	public String form(ModelMap map){
		map.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, HttpSession sessao, ModelMap map){
		
		if(usuario.getLogin().getUsuario() == null || usuario.getLogin().getSenha() == null ){
			map.addAttribute("usuario", usuario);
			return "login";
		}
		Usuario usuarioLogado = usuarioService.buscarLoginSenha(usuario.getLogin()); 
		if(usuarioLogado != null){
			if(usuarioLogado instanceof Cliente){
				sessao.setAttribute("telaPrincipal", "Cliente");
				sessao.setAttribute("sessaoUsuario", usuarioLogado);
				
			}
			else if(usuarioLogado instanceof Funcionario){
					if(((Funcionario) usuarioLogado).getCargo().name() == "ADMIN" ){
						sessao.setAttribute("telaPrincipal","Admin");
					}else if(((Funcionario) usuarioLogado).getCargo().name() == "GERENTE"){
							sessao.setAttribute("telaPrincipal","Gerente");
					}else if(((Funcionario) usuarioLogado).getCargo().name() == "FUNCIONARIO" ){
							sessao.setAttribute("telaPrincipal","Funcionario");
					}
				sessao.setAttribute("sessaoUsuario", usuarioLogado);
			}
			return "index";	
		}
		
		return "login";		
		
	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession sessao){
			sessao.invalidate();
			return "redirect:/";
	}
	

}
