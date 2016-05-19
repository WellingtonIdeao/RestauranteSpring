package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cardapio;
import model.Categoria;
import model.Promocao;
import service.CategoriaService;
import service.ProdutoService;
import service.PromocaoService;
@WebServlet("/cadastroCardapioServlet")
public class CadastroCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(req.getSession().getAttribute("userLogado")== null){
			req.getRequestDispatcher("login").forward(req, resp);
		}else{
			if(id != null){
				ProdutoService ProServ = new ProdutoService();
				Cardapio cardapio = new Cardapio();
				cardapio.setId(new Long(id)); 
				cardapio = (Cardapio) ProServ.buscar(cardapio);
				
				req.setAttribute("cardapio", cardapio);
			}
			CategoriaService catServ = new CategoriaService();
			PromocaoService promoServ = new PromocaoService();
			
			List<Promocao> promocoes = promoServ.listar();
			List<Categoria> categorias = catServ.listar();
			req.setAttribute("categorias", categorias);
			req.setAttribute("promocoes", promocoes);
			req.getRequestDispatcher("cadastroCardapio").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =  req.getParameter("id");
		String nome =  req.getParameter("nome");
		String preco =  req.getParameter("preco");
		String catId = req.getParameter("catSelected");
		String status = req.getParameter("statusSelected");
		String promoId = req.getParameter("promoSelected");
		
		Categoria cat = new Categoria();
		cat.setId(new Long (catId));
		CategoriaService catServ = new CategoriaService();
		cat = catServ.buscar(cat);
		
		Promocao promocao = new Promocao();
		promocao.setId(new Long(promoId));
		PromocaoService promoServ = new PromocaoService();
		promocao = promoServ.buscar(promocao);
		
		Cardapio cardapio = new Cardapio(promocao);
		cardapio.setCategoria(cat);
		cardapio.setNome(nome);
		cardapio.setPreco(new BigDecimal(preco));
		cardapio.setAtivo(new Boolean(status));
		ProdutoService ProServ = new ProdutoService();
		if(id != null && !id.equals("")){
			cardapio.setId(new Long(id));
			ProServ.atualizar(cardapio);
			req.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			ProServ.inserir(cardapio);
			req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}
		
		req.getRequestDispatcher("listarCardapioServlet").forward(req, resp);
				
	}
	
}
