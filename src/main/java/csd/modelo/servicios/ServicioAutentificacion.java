package csd.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import csd.modelo.repositorios.UsuarioRepositorio;



@Service
public class ServicioAutentificacion implements UserDetailsService{

	@Autowired private UsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		return usuarioRepositorio.findOneByUsername(usuario);
	}

}
