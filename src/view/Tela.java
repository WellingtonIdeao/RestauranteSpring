package view;

import model.Cardapio;
import model.Categoria;
import model.Cliente;
import model.Mesa;
import model.Produto;
import model.Promocao;
import model.Reserva;
import model.Tradicional;
import service.CategoriaService;
import service.ClienteService;
import service.MesaService;
import service.ProdutoService;
import service.PromocaoService;
import service.ReservaService;
import service.TradicionalService;

public class Tela {

	public static void main(String[] args)  {
	
		// FUNCIONARIO//
		
		// CADASTRA
//		Funcionario f = new Funcionario();
//		FuncionarioService fService = new FuncionarioService();
//		f.setNome("Jose wellington");
//		f.setCargo("Atendente");
//		f.setSalario(3000);
//		f.setEmail("gugaboy3@gmail.com");
//		fService.inserir(f);

		//REMOVE
//		f.setId(2);
//		f = fService.buscar(f);
//		fService.remover(f)
		
		//ATUALIZA
//		f.setId(1);
//		f = fService.buscar(f);
//		f.setSalario(4000);
//		f.setCpf("777777777777-77");
//		fService.atualizar(f);
//		System.out.println(fService.listar());
		
		
		//CADASTRAR CLIENTE//
		
//		Cliente c = new Cliente();
//		ClienteService cService = new ClienteService();
		
		//CADASTRA
//		c.setNome("guga");
//		c.setEnde("miguel inacio", "jose americo", "João pessoa", 10, "5800-000", "casa");
//		c.setCpf("777777777777-77");
//		Date data = Calendar.getInstance().getTime();
//		c.setDataNasc(data);
//		cService.inserir(c);
//		System.out.println(cService.listar());
		
		//ATUALIZA
//		c.setId(10);
//		c = cService.buscar(c);
//		c.setNome("Wellington Ideao");
//		cService.atualizar(c);
//		System.out.println(cService.listar());
		
		//REMOVE
//		c.setId(4);
//		c = cService.buscar(c);
//		cService.remover(c);
//		System.out.println(cService.listar());
		
		// CADASTRAR MESA
		
//		Mesa m = new Mesa();
//		MesaService mService = new MesaService();
//		//CADASTRA
//		m.setCapacidade(6);
//		m.setDescricao("Mesa 1");
//		mService.inserir(m);
//		System.out.println(mService.listar());
		
		//ATUALIZA
		
//		m.setId(1);
//		m = mService.buscar(m);
//		m.setCapacidade(2);
//		mService.atualizar(m);
//		System.out.println(mService.listar());
		
		//REMOVE
//		m.setId(1);
//		m = mService.buscar(m);
//		mService.remover(m);
//		System.out.println(mService.listar());
		
		//CADASTRAR CATEGORIA
		Categoria ca = new Categoria();
		CategoriaService caService = new CategoriaService();
		
//		CADASTRA
		ca.setNome("Doces123");
		caService.inserir(ca);
		System.out.println(caService.listar());
		
		//ATUALIZA
//		ca.setId(1);
//		ca = caService.buscar(ca);
//		ca.setNome("Salgado");
//		caService.atualizar(ca);
//		System.out.println(caService.listar());
		
		//REMOVE
//		ca.setId(2);
//		ca = caService.buscar(ca);
//		caService.remover(ca);
//		System.out.println(caService.listar());
		
				
//		//CADASTRAR RESERVA
//		Reserva re = new Reserva();
//		ReservaService reService = new ReservaService();
//		Mesa me = new Mesa();
//		MesaService ms = new MesaService();
//		me.setId(2);
//		me = ms.buscar(me);
//		//CADASTRA
//		re.setNumPessoas(3);
//		re.setResponsavel("João");
//		re.setMesa(me);
//		reService.inserir(re);
		
		//ATUALIZA
//		re.setId(1);
//		re = reService.buscar(re);
//		re.setResponsavel("Guga");
//		reService.atualizar(re);
//		System.out.println(reService.listar());
		
		//REMOVE
//		re.setId(2);
//		re = reService.buscar(re);
//		reService.remover(re);
//		System.out.println(reService.listar());
		
		
		//CADASTRAR PROMOCAO
//		Promocao promocao = new  Promocao();
//		PromocaoService proService = new PromocaoService();
		
		//CADASTRA
//		promocao.setDescricao("Final da Ano");
//		proService.inserir(promocao);
//		System.out.println(proService.listar());
		
		//ATUALIZA
//		promocao.setId(1);
//		promocao = proService.buscar(promocao);
//		promocao.setDescricao("Promocao de fim de ano!");
//		proService.atualizar(promocao);
//		System.out.println(proService.listar());
		
		//REMOVE
//		promocao.setId(2);
//		promocao = proService.buscar(promocao);
//		proService.remover(promocao);
//		System.out.println(proService.listar());
		
		//PRODUTO
//		Produto produto = new Cardapio();
//		ProdutoService prodService = new ProdutoService();
//		Categoria cat = new Categoria();
//		CategoriaService cas = new CategoriaService();
//		Promocao promo = new Promocao();
//		PromocaoService promocaoService = new PromocaoService();
//		//CADASTRAR
//		produto.setId(5);
//		produto.setNome("guaraná");
//		produto.setPreco(new BigDecimal("3.00"));
//		cat.setId(3);
//		cat = cas.buscar(cat);
//		produto.setCategoria(cat);
//		prodService.inserir(produto);
//		System.out.println(prodService.listar());
		
		//CADASTRAR COM PROMOCAO
		
//		promo.setId(1);
//		promo = promocaoService.buscar(promo);
//		Produto prodEmPromo = new Cardapio(promo);
//		prodEmPromo.setNome("guaraná");
//		prodEmPromo.setPreco(new BigDecimal("3.00"));
//		cat.setId(3);
//		cat = cas.buscar(cat);
//		prodEmPromo.setCategoria(cat);
//		prodService.inserir(prodEmPromo);
		
		//ATUALIZA
//		produto.setId(2);
//		produto = prodService.buscar(produto);
//		Cardapio card = (Cardapio)produto;
//		promo.setId(1);
//		promo = promocaoService.buscar(promo);
//		card.setPromocao(promo);
//		prodService.atualizar(card);
//		System.out.println(prodService.listar());
		
		//BUSCAR LISTA DE CARDAPIOS
//		promo.setId(1);
//		promo = promocaoService.buscar(promo);
//		System.out.println(promo.getCardapios());
		
		//REMOVE
//		produto.setId(4);
//		produto = prodService.buscar(produto);
//		prodService.remover(produto);
//		System.out.println(prodService.listar());

		//APLICAR PROMOCAO
		
//		PromocaoService promoService = new PromocaoService();
//		promocao.setId(1);
//		promocao = proService.buscar(promocao);
//		promocao.removeObserver(card);
//		promoService.atualizar(promocao);
//		Desconto desconto = new Desconto10();
//		promocao.setDesconto(desconto);
//		System.out.println(promocao.getCardapios());
		
		
		//FAZER PEDIDO DELIVERY
//		Delivery delivery = new Delivery();
//		DeliveryService delService = new DeliveryService();
//		produto.setId(1);
//		produto = prodService.buscar(produto);
//		c.setId(5);
//		c = cService.buscar(c);
//		delivery.setCliente(c);
//		delivery.addProduto(2, produto);
//		delivery.addProduto(1, produto);
//		delService.inserir(delivery);
		
		
		//FAZER PEDIDO TRADICIONAL
		
//		Tradicional tradicional = new Tradicional();
//		TradicionalService traSerrvice = new TradicionalService();
//		produto.setId(1);
//		produto = prodService.buscar(produto);
//		tradicional.addProduto(2, produto);
//		m.setId(2);
//		m = mService.buscar(m);
//		tradicional.setMesa(m);
//		traSerrvice.inserir(tradicional);
//		System.out.println(traSerrvice.listar());
		
		
	}

}
