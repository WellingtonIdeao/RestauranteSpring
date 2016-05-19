package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

@WebServlet("/removerClienteServlet")
public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ClienteService cliServ = new ClienteService();
		Cliente cliente = new Cliente();
		cliente.setId(new Long(id));
		cliServ.remover(cliente);
		response.sendRedirect("listarClienteServlet");
	}
}
