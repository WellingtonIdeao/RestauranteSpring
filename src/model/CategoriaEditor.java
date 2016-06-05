package model;

import java.beans.PropertyEditorSupport;

import service.CategoriaService;

public class CategoriaEditor extends PropertyEditorSupport {
		private CategoriaService catService;
	
	public CategoriaEditor(CategoriaService catService){
		this.catService = catService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Categoria cat = new Categoria();
		cat.setId(Long.parseLong(text));
		cat = catService.buscar(cat);
		setValue(cat);
	}

}
