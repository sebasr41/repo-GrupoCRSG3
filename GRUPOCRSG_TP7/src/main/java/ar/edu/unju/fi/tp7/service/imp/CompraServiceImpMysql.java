package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Compra;
import ar.edu.unju.fi.tp7.repository.ICompraRepository;
import ar.edu.unju.fi.tp7.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceImpMysql implements ICompraService {
	
	@Autowired
	ICompraRepository compraRepository;

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		compraRepository.save(compra);
	}

	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compra> getAllCompras() {
		// TODO Auto-generated method stub
		List<Compra> compras= (List<Compra>) compraRepository.findAll();
		return compras;
	}

}
