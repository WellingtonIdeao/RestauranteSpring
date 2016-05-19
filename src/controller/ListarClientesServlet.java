package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;
@WebServlet("/listarClienteServlet")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
		}else{
			doPost(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteService cliServ = new ClienteService(); 
		List<Cliente> clientes = cliServ.listar();
		req.setAttribute("clientes", clientes);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("listarClientes");
		requestDispatcher.forward(req, resp);
	}

}
