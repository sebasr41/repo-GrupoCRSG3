package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.models.Producto;
import ar.edu.unju.fi.tp7.repository.IProductoRepository;
import ar.edu.unju.fi.tp7.service.IProductoService;
@Service("productoServiceMysql")
public class ProductoServiceImpMysql implements IProductoService {

	@Autowired
	IProductoRepository productoRepository;
	
	
	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}


	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}





	@Override
	public void generarTablaProducto() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Producto getProductoPorCodigo(Long codigo) {
		// TODO Auto-generated method stub
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}


	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}


	@Override
	public Optional<Producto> getProductoPorId(Long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		return producto;
	}

}
