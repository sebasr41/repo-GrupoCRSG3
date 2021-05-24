package ar.edu.unju.fi.tp7.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.service.IClienteService;



@Controller
public class ClienteController {
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	@GetMapping("/cliente")
	public String getClientePage(Model model) {
		model.addAttribute("cliente",cliente);
		return "nuevo-cliente";
	}
	
	@PostMapping("/cliente-guardar")
	public ModelAndView guardarClientePage(@ModelAttribute("cliente")Cliente cliente) {
		
		ModelAndView model = new ModelAndView("clientes");
		clienteService.guardarCliente(cliente);
		model.addObject("clientes",clienteService.obtenerClientes());
		return model;
	}
	
	@GetMapping("/cliente-cuentas")
	public ModelAndView getClientesCuentasPage() {
		ModelAndView model = new ModelAndView("cuentas");
		if(clienteService.obtenerClientes() == null) {
			clienteService.generarTablaLCliente();
		}
		model.addObject("clientes",clienteService.obtenerClientes());
		return model;
	}
	@GetMapping("/cliente-listado")
	public ModelAndView getClientesPage() {
		ModelAndView model = new ModelAndView("clientes");
		if(clienteService.obtenerClientes() == null) {
			clienteService.generarTablaLCliente();
		}
		model.addObject("clientes",clienteService.obtenerClientes());
		return model;
	}
	//Modificacion de una cuenta de un cliente
	
		@GetMapping("/cliente-editar-{id}")
		public ModelAndView getClienteEditPage(@PathVariable (value = "id") Long id) {
			//ModelAndView modelView = new ModelAndView("nuevo-cliente");
			ModelAndView modelView = new ModelAndView("editar-cuenta");
			//Recuperamos el empleado que se envio de la tabla por id
			Optional<Cliente> cliente = clienteService.getClientePorId(id);
			modelView.addObject("cliente", cliente);
			return modelView;
		}
		
		//Borrar una cuenta de un cliente
		@GetMapping("/cliente-eliminar-{id}")
		public ModelAndView getClienteEliminarPageg(@PathVariable (value = "id")Long id) {
			//									redirect recarga la lista de cuentas
			ModelAndView modelView = new ModelAndView("redirect:/cliente-cuentas");
			clienteService.eliminarCliente(id);
			return modelView;
		}
		
	
}
