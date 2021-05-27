package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.repository.IClienteRepository;
import ar.edu.unju.fi.tp7.service.IClienteService;
@Service("clienteServiceMysql")
public class ClienteServiceImpMysql implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void generarTablaLCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
		
		
	}

	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes= (List<Cliente>) clienteRepository.findAll();
		
		return clientes;
	}

	@Override
	public Cliente getClientePorNroDocumento(int nroDocumento) {
		// TODO Auto-generated method stub
		Cliente cliente = clienteRepository.findByNroDocumento(nroDocumento);
		return cliente;
		
	}
	
	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}
	
	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
