package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.FuncionarioDAO;
import model.Funcionario;

@Service
@Transactional
public class FuncionarioService extends AbstractService<Funcionario> {

	@Autowired
	private FuncionarioDAO dao;
	@Autowired
	private UsuarioService userServ;
	
	public void inserir(Funcionario f) {
		try {
			// se o funcionario for nulo
			if (f == null)
				throw new Exception("Entidade passada para inserção é nula");
			if(userServ.exist(f))
				new Exception();
			else
				dao.inserir(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean atualizar(Funcionario f) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (f == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}
			// se não for nula
			dao.atualizar(f);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public boolean remover(Funcionario func) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (func == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				func = dao.buscarPorId(func.getId());

			// se entidade não estiver BD
			if (func == null)
				throw new Exception("Entidade passada para remoção não encontrada");

			dao.remover(func);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public List<Funcionario> listar() {
		List<Funcionario> list = null;
		try {
			list = dao.listar();
			// se a lista for vazia
			if (list.isEmpty())
				throw new Exception("Lista está vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public List<Funcionario> listarGerente() {
		List<Funcionario> list = new ArrayList<>();
		List<Funcionario> templist = null;
		try {
			templist = dao.listar();
			if (templist.isEmpty())
				throw new Exception("Lista está vazia");
			for(Funcionario f: templist ){
				if(!(f.getCargo().name().equals("GERENTE")||f.getCargo().name().equals("ADMIN"))){
					list.add(f);
				}
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public Funcionario buscar(Funcionario func) {
		try {
			// se entidade for nula
			if (func == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				func = dao.buscarPorId(func.getId());

			// se entidade não estiver no BD
			if (func == null)
				throw new Exception(simpleName(func) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return func;
	}

	public String simpleName(Funcionario func) {
		return func.getClass().getSimpleName();

	}

	public List<Funcionario> buscarFiltro(Funcionario filtro) {
		return dao.buscarFiltro(filtro);
	}
	
	public List<Funcionario> buscarFiltroGerente(Funcionario filtro) {
		List<Funcionario> templist = dao.buscarFiltro(filtro);
		List<Funcionario> list =new ArrayList<>();
		
		for(Funcionario f: templist){
			if(!(f.getCargo().name().equals("ADMIN")||f.getCargo().name().equals("GERENTE"))){
				list.add(f);
			}
		}	
		return list; 
	}

}
