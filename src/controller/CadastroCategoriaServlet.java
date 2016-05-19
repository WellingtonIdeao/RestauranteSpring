package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import service.CategoriaService;

@WebServlet("/cadastroCategoriaServlet")
public class CadastroCategoriaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(req.getSession().getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
		}else{
		
			if(id != null){
				CategoriaService cliServ = new CategoriaService();
				Categoria categoria = new Categoria();
				categoria.setId(new Long(id)); 
				categoria = cliServ.buscar(categoria);
				
				req.setAttribute("categoria", categoria);
			}
			req.getRequestDispatcher("cadastroCategoria").forward(req, resp);
			
		}
	}
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String status = req.getParameter("statusSelected");
		
		CategoriaService  catServ = new CategoriaService();
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setAtivo(new Boolean(status));
		
		
		if(id != null && !id.equals("")){
			categoria.setId(new Long(id));
			catServ.atualizar(categoria);
			req.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			catServ.inserir(categoria);
			req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}
		
		req.getRequestDispatcher("listarCategoriaServlet").forward(req, resp);
				
	}

}
