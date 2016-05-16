package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Delivery;

@WebServlet("/removerCarrinhoServlet")
public class RemoverCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		
		HttpSession sessao =req.getSession();
		Delivery delivery =  (Delivery)sessao.getAttribute("carrinhoDelivery");
		if(delivery ==null){
			delivery = new Delivery();
			sessao.setAttribute("carrinhoDelivery", delivery);
		}
		
		if(index!= null){
			delivery.removerProduto(new Integer(index));
		}
		req.setAttribute("delivery", delivery);
		req.getRequestDispatcher("carrinhoDeliveryServlet").forward(req, resp);
		

	}


}
