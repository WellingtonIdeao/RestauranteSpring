package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cardapio;
import model.Promocao;
import service.ProdutoService;
import service.PromocaoService;


@WebServlet("/cadastroPromocaoServlet")
public class CadastroPromocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(req.getSession().getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
			
		}else{
			if (id != null) {
				PromocaoService ProServ = new PromocaoService();
				Promocao promocao = new Promocao();
				promocao.setId(new Long(id));
				promocao = (Promocao) ProServ.buscar(promocao);
	
				req.setAttribute("promocao", promocao);
			}
	
			req.getRequestDispatcher("cadastroPromocao").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String desconto = req.getParameter("desconto");

		PromocaoService ProServ = new PromocaoService();
		Promocao promocao = new Promocao();
		if(!id.equals("")){
			promocao.setId(new Long(id));
			promocao = (Promocao) ProServ.buscar(promocao);
		}
		promocao.setDesconto(new BigDecimal(desconto));
		promocao.setDescricao(nome);
		PromocaoService promoServ = new PromocaoService();
		
		if (id != null && !id.equals("")) {
			promocao.setId(new Long(id));
			promoServ.atualizar(promocao);
			req.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			promoServ.inserir(promocao);
			req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		req.getRequestDispatcher("listarPromocaoServlet").forward(req, resp);

	}

}
