package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cardapio;
import model.Cliente;
import model.Delivery;
import model.Produto;
import service.DeliveryService;
import service.ProdutoService;

@WebServlet("/carrinhoDeliveryServlet")
public class EfetuarDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		if(sessao.getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
		}else{
			String itemID = req.getParameter("itemSelected");
			String qtd = req.getParameter("qtd");
			ProdutoService proServ = new ProdutoService();
			List<Produto> produtos = proServ.listar();
			req.setAttribute("produtos", produtos);
			
			Delivery delivery =  (Delivery)sessao.getAttribute("carrinhoDelivery");
			if(delivery ==null){
				delivery = new Delivery();
				sessao.setAttribute("carrinhoDelivery", delivery);
			}
			req.getAttribute("qtd");
			
			if(itemID!= null && qtd!=null){
				Produto produto = new Cardapio();
				produto.setId(new Long(itemID));
				produto = proServ.buscar(produto);
				delivery.addProduto(new Integer(qtd), produto);
			}
			req.setAttribute("delivery", delivery);
			req.getRequestDispatcher("efetuarDelivery").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String finalizar = req.getParameter("finalizar");
		Delivery delivery = (Delivery)req.getSession().getAttribute("carrinhoDelivery");
		Cliente cliente = (Cliente)req.getSession().getAttribute("userLogado");
		delivery.setCliente(cliente);
		
		boolean finalize = new Boolean(finalizar);
		DeliveryService delServ = new DeliveryService();
		 
		 
		if(finalize){
			delServ.inserir(delivery);
			req.setAttribute("mensagem", "Pedido finalizado com sucesso");
		}else
			req.setAttribute("mensagem", "Pedido não finalizado com sucesso");
		req.getRequestDispatcher("index").forward(req, resp);

	}
}	