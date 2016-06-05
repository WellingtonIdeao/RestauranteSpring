package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.UsuarioDAO;
import model.Login;
import model.Usuario;

@Service
@Transactional
public class UsuarioService extends AbstractService<Usuario> {

	@Autowired
	private UsuarioDAO dao;

	public void inserir(Usuario user) {
		try {
			// se a categoria for nula
			if (user == null)
				throw new Exception("Entidade passada para inser��o � nula");
			user = dao.buscarPorLoginSenha(user.getLogin());
			boolean exist = dao.exist(user);
			if (!exist) {
				dao.inserir(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean atualizar(Usuario user) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (user == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}
			// se n�o for nula
			dao.atualizar(user);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;

	}

	public Usuario buscarLoginSenha(Login login) {
		Usuario user = null;
		try {
			// se entidade for nula
			if (login == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				user = dao.buscarPorLoginSenha(login);

			// se entidade n�o estiver no BD
			if (user == null)
				throw new Exception(simpleName(user) + " n�o encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

	public boolean exist(Usuario user) {
		boolean exist = false;
		try {
			// se entidade for nula
			if (user == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				exist = dao.exist(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exist;

	}

	public String simpleName(Usuario user) {
		return user.getClass().getSimpleName();

	}
}
