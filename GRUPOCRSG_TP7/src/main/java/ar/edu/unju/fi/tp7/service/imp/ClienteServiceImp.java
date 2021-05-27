package ar.edu.unju.fi.tp7.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.service.IClienteService;
import ar.edu.unju.fi.tp7.util.TablaCliente;


@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {
	
    private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	
	private List<Cliente> clientes; 

	@Override
	public void generarTablaLCliente() {
		clientes = TablaCliente.listaClientes;
		
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		if(clientes == null) {
			generarTablaLCliente();
		}
		clientes.add(cliente);
		LOGGER.info("METHOD: guardarCliente - se agregó un objeto cliente en la lista -> "+clientes.get(clientes.size()-1));
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return clientes;
	}

	@Override
	public Cliente getClientePorNroDocumento(int nroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}

}
