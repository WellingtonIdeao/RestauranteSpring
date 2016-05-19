package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Login;
import service.ClienteService;
@WebServlet("/cadastroClienteServlet")
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if(req.getSession().getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
		}else{
		
			if(id != null){
				ClienteService cliServ = new ClienteService();
				Cliente cliente = new Cliente();
				cliente.setId(new Long(id)); 
				cliente = cliServ.buscar(cliente);
				
				req.setAttribute("cliente", cliente);
			}
			req.getRequestDispatcher("cadastroCliente").forward(req, resp);
		}	
	
	}
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String usuario =  req.getParameter("usuario");
		String senha =  req.getParameter("senha");
		String nome =  req.getParameter("nome");
		String telefone =  req.getParameter("telefone");
		String rua =  req.getParameter("rua");
		String bairro = req.getParameter("bairro");
		String dataNasc =  req.getParameter("dataNasc");
		String email =  req.getParameter("email");
		String numero =  req.getParameter("numero");
		String cep =  req.getParameter("cep");
		String complemento =  req.getParameter("complemento");
		Date data = null;
		
		try {
			data = new SimpleDateFormat("dd/mm/yyyy").parse(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClienteService  cliServ = new ClienteService();
		Cliente cliente = new Cliente();
		cliente.setLogin(usuario,senha);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setEnde(rua, bairro, numero, cep, complemento);
		cliente.setEmail(email);
		cliente.setDataNasc(data);
		
		if(id != null && !id.equals("")){
			cliente.setId(new Long(id));
			cliServ.atualizar(cliente);
			req.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			try {
				cliServ.inserir(cliente);
				req.setAttribute("mensagem", "Cadastro efetuado com sucesso. Faça Login");
			} catch (Exception e) {
				req.setAttribute("mensagem","Nome de usuário já Cadastrado");
			}
			
		}
		
		req.getRequestDispatcher("login").forward(req, resp);
				
	}


}
