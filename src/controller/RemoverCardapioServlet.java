package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cardapio;
import service.ProdutoService;

@WebServlet("/removerCardapioServlet")
public class RemoverCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ProdutoService ProServ = new ProdutoService();
		Cardapio car = new Cardapio();
		car.setId(new Long(id));
		ProServ.remover(car);
		response.sendRedirect("listarCardapioServlet");
	}
}
