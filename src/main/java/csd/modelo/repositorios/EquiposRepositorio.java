package csd.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import csd.modelo.entidades.Equipos;

@Repository
public interface EquiposRepositorio  extends CrudRepository<Equipos, Long>{
	

}
	