package ar.edu.unju.fi.tp7.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp7.models.Cliente;


public interface IClienteService {
	
	public void generarTablaLCliente();
	
	public void guardarCliente(Cliente cliente);
	
	public List<Cliente> obtenerClientes();

	public Cliente getClientePorNroDocumento(int nroDocumento);
	
	public Optional<Cliente> getClientePorId(Long id);
	
	public void eliminarCliente(Long id);

}
