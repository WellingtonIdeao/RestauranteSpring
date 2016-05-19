package dao;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Login;
import model.Usuario;

@Repository
public class UsuarioDAO extends PadraoDAO<Usuario> {

	@Override
	public Class<Usuario> entityClass() {
		return Usuario.class;
	}
	
	public boolean exist(Usuario user){
		
			Query consulta = this.manager.createQuery("select COUNT(user) from " + entityClass().getSimpleName() + " user WHERE user.login.usuario =:usuario");
			consulta.setParameter("usuario",user.getLogin().getUsuario());
			return (long)consulta.getSingleResult()!=0;		
	}
	
	public Usuario buscarPorLoginSenha(Login login){
		try{
			Query consulta = this.manager.createQuery("select user from " + entityClass().getSimpleName() + " user WHERE user.login.usuario =:usuario and user.login.senha =:senha");
			consulta.setParameter("usuario",login.getUsuario());
			consulta.setParameter("senha",login.getSenha());
			return (Usuario)consulta.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

}
