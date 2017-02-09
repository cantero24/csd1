package csd.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@NoRepositoryBean
public interface GenericRepositorio<T extends User> 
extends CrudRepository<T, Long> {

	public T findOneByUsername(String usuario);
 
}