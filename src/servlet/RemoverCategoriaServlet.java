package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import service.CategoriaService;
@WebServlet("/removerCategoriaServlet")
public class RemoverCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CategoriaService catServ = new CategoriaService();
		Categoria cat = new Categoria();
		cat.setId(new Long(id));
		catServ.remover(cat);
		response.sendRedirect("listarCategoriaServlet");
	}
}
