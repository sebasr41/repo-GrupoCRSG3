package ar.edu.unju.fi.tp7.controller;

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



@Controller
public class ClienteController {
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteUtilService")
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
	@GetMapping("/cliente-listado")
	public ModelAndView getClientesPage() {
		ModelAndView model = new ModelAndView("clientes");
		if(clienteService.obtenerClientes() == null) {
			clienteService.generarTablaLCliente();
		}
		model.addObject("clientes",clienteService.obtenerClientes());
		return model;
	}
	
	
}
