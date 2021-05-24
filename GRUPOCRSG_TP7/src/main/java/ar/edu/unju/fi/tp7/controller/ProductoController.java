package ar.edu.unju.fi.tp7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.models.Producto;
import ar.edu.unju.fi.tp7.service.IProductoService;



@Controller
public class ProductoController {
	@Autowired
	private Producto producto;
	
	//@Qualifier("productoUtilService")
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;

	@GetMapping("/producto")
	public String getProductoPage(Model model) {
		model.addAttribute(producto);
		return "nuevo-producto";
	}
	@PostMapping("/producto-guardar")
	public ModelAndView guardarProductoPage(@ModelAttribute("producto") Producto producto){
		
		ModelAndView model = new ModelAndView("resultado-producto");
		productoService.guardarProducto(producto);
		model.addObject("productos", productoService.obtenerProductos());
		
		return model;
	}
	
	@GetMapping("/producto-ultimo")
	public ModelAndView getProductosPage(){		
		ModelAndView model = new ModelAndView("ultimo-producto");
		
		if(productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		
		model.addObject("productos", productoService.obtenerProductos());
		
		return model;
	}
	
}
