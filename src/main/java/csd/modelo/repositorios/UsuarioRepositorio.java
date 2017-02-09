package csd.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import csd.modelo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	public UserDetails findOneByUsername(String usuario);

}
