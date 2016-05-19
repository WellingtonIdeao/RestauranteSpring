package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Promocao;
import service.PromocaoService;
@WebServlet("/listarPromocaoServlet")
public class ListarPromocaoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userLogado")== null){
			request.getRequestDispatcher("login").forward(request, response);
		}else{
			doPost(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PromocaoService Proserv = new PromocaoService();
		
		List<Promocao> promocoes = Proserv.listar();
		request.setAttribute("promocoes", promocoes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarPromocoes");
		requestDispatcher.forward(request, response);
		
		
	}

}
