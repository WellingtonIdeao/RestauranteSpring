package model;

import java.beans.PropertyEditorSupport;
import service.ProdutoService;

public class ProdutoEditor extends PropertyEditorSupport {
	private ProdutoService produtServ;

	public ProdutoEditor(ProdutoService produtServ) {
		this.produtServ = produtServ;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Cardapio cardapio = new Cardapio();
		cardapio.setId(Long.parseLong(text));
		cardapio = (Cardapio) produtServ.buscar(cardapio);
		setValue(cardapio);
	}

}
