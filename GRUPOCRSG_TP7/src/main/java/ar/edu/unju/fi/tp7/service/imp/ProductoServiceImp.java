package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Producto;
import ar.edu.unju.fi.tp7.service.IProductoService;
import ar.edu.unju.fi.tp7.util.TablaProducto;



@Service("productoUtilService")
public class ProductoServiceImp implements IProductoService {


    private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);

    private List<Producto> productos;

    @Override
    public void generarTablaProducto() {
        productos = TablaProducto.listaProductos;
    }
    
    @Override
    public void guardarProducto(Producto producto) {
    	
    	if(productos == null) {
    		generarTablaProducto();
    	}
        productos.add(producto);
        LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
        LOGGER.info("METHOD: addProducto - se agregó un objeto producto en la lista -> "+productos.get(productos.size()-1));
        LOGGER.info("RESULT: a object producto");
    }
    
    
	@Override
	public List<Producto> obtenerProductos() {
		return productos;
	}


	@Override
	public Producto getProductoPorCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Producto> getProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}  

}
