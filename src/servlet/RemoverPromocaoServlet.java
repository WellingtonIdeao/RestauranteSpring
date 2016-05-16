package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Promocao;
import service.PromocaoService;

@WebServlet("/removerPromocaoServlet")
public class RemoverPromocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		PromocaoService PromoServ = new PromocaoService();
		Promocao pro = new Promocao();
		pro.setId(new Long(id));
		PromoServ.remover(pro);
		response.sendRedirect("listarPromocaoServlet");
	}

}
