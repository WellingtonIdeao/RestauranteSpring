package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Produto;
import service.CategoriaService;
import service.ProdutoService;

@WebServlet("/listarCardapioServlet")
public class ListarCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userLogado")== null){
			request.getRequestDispatcher("login").forward(request, response);
			
		}else{
				doPost(request, response);
	
		}		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoService Proserv = new ProdutoService();
		CategoriaService catServ = new CategoriaService();
		
		List<Produto> cardapios = Proserv.listar();
		List<Categoria> categorias =  catServ.listar();
		request.setAttribute("cardapios", cardapios);
		request.setAttribute("categorias", categorias);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCardapios");
		requestDispatcher.forward(request, response);
		
		
	}

}
