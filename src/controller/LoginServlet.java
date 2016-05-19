package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Funcionario;
import model.Login;
import model.Usuario;
import service.UsuarioService;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario =  req.getParameter("usuario");
		String senha =  req.getParameter("senha");
		
		Login login = new Login(usuario,senha);
		UsuarioService userService = new UsuarioService();
		Usuario userLogado = userService.buscarLoginSenha(login);
			if(userLogado!=null){
				
				if(userLogado instanceof Cliente){
				req.getSession().setAttribute("telaPrincipal", "Cliente");
				req.getSession().setAttribute("userLogado", userLogado);
				}
				if(userLogado instanceof Funcionario){
					req.getSession().setAttribute("telaPrincipal","Funcionario");
					req.getSession().setAttribute("userLogado", userLogado);		
				}
				req.getRequestDispatcher("index").forward(req, resp);
			}else{
				req.setAttribute("mensagem", "Usuário ou senha inválido!");
				req.getRequestDispatcher("login").forward(req, resp);
			}	
	}
}
