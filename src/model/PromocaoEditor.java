package model;

import java.beans.PropertyEditorSupport;

import service.PromocaoService;

public class PromocaoEditor extends PropertyEditorSupport {
	private PromocaoService promoService;
	
	public PromocaoEditor(PromocaoService promoService){
		this.promoService = promoService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Promocao promocao = new Promocao();
		promocao.setId(Long.parseLong(text));
		promocao = promoService.buscar(promocao);
		setValue(promocao);
	}
	
	
}
