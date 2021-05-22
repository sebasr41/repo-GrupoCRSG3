package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.models.Compra;
import ar.edu.unju.fi.tp7.models.Producto;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.util.TablaCompra;



@Service("compraUtilService")
public class CompraServiceImp implements ICompraService {
	
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	
	private List<Compra> compras;

	@Override
	public void guardarCompra(Compra compra) {
		if(compras == null ) {
			generarTablaCompra();
		}
		
		double total = compra.getCantidad()*compra.getProducto().getPrecio();
		compra.setTotal(total);
		
		compras.add(compra);
		LOGGER.info("SERVICE: ICompraService -> CompraServiceImp");
        LOGGER.info("METHOD: addCompra - se agregó un objeto compra en la lista -> "+compras.get(compras.size()-1));
        LOGGER.info("RESULT: a object compra");

	}

	@Override
	public List<Compra> getAllCompras() {
		
		return compras;
	}

	@Override
	public void generarTablaCompra() {
		compras = TablaCompra.listaCompra;
		compras.add(new Compra(22,2112,121,new Producto(1,"Zapatilla",10133,"Adidas",1122)));
		
	}	



}
