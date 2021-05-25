package ar.edu.unju.fi.tp7.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.service.IClienteService;
import ar.edu.unju.fi.tp7.models.Compra;
import ar.edu.unju.fi.tp7.models.Producto;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.service.IProductoService;



@Controller
public class CompraController {
	@Autowired
	private Compra compra;
	
	//@Qualifier("productoUtilService")
	@Qualifier("productoServiceMysql")
	@Autowired
	private IProductoService productoService;
	
	//@Qualifier("compraUtilService")
	@Qualifier("compraServiceMysql")
	@Autowired
	private ICompraService compraService;
	
	@Qualifier("clienteServiceMysql")
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/compra")
	public String getCompraPage(Model model) {
		model.addAttribute("compra", compra);	
		model.addAttribute("clientes", clienteService.obtenerClientes());
		model.addAttribute("productos", productoService.obtenerProductos());
		return "nueva-compra";
	}
	@PostMapping("/compra-guardar")
	public ModelAndView getGuardarComprasPage(@ModelAttribute("compra")Compra compra) {
		ModelAndView modelView = new ModelAndView("compras");
		
		if(compraService.getAllCompras() == null) {
			compraService.generarTablaCompra();
		}
		
		Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo());
		compra.setProducto(producto);
		Cliente cliente = clienteService.getClientePorNroDocumento(compra.getCliente().getNroDocumento());
		compra.setCliente(cliente);
		
		compraService.guardarCompra(compra);
		modelView.addObject("productos", compraService.getAllCompras());
					
		
					
		return modelView;
	}
	
}
