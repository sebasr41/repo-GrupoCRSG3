package ar.edu.unju.fi.tp7.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp7.models.Producto;



public interface IProductoService {
	
    public void guardarProducto(Producto producto);

    public void generarTablaProducto();
    
    public List<Producto> obtenerProductos();
    
    public Optional<Producto> getProductoPorCodigo(Long codigo);

}
