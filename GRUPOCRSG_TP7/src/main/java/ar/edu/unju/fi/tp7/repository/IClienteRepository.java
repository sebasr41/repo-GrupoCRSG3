package ar.edu.unju.fi.tp7.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp7.models.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
	

}
