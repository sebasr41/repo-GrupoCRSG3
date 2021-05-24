package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.models.Cliente;
import ar.edu.unju.fi.tp7.models.Cuenta;
import ar.edu.unju.fi.tp7.service.IClienteService;
import ar.edu.unju.fi.tp7.service.ICuentaService;

@Controller
public class CuentaController {
	
	@Autowired
	private Cuenta cuenta;
	
	//@Qualifier("clienteUtilService")
	@Qualifier("clienteServiceMysql")
	@Autowired
	private IClienteService clienteService;
	
	//@Qualifier("cuentaUtilService")
	@Qualifier("cuentaServiceMysql")
	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping("/cuenta")
	public String getCuentaPage(Model model) {
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("cliente", clienteService.obtenerClientes());
		return "editar-cuenta";
	}

	@PostMapping("/cuenta-guardar")
	public ModelAndView getGuardarCuentasPage(@ModelAttribute("cuenta")Cuenta cuenta) {
		ModelAndView modelView = new ModelAndView("resultado-cuenta");
		
		Cliente cliente = clienteService.getClientePorNroDocumento(cuenta.getCliente().getNroDocumento());
		cuenta.setCliente(cliente);
		cuentaService.guardarCuenta(cuenta);
		modelView.addObject("cliente", cuentaService.getAllCuentas());
		
		return modelView;
	}
	
	@GetMapping("/cuenta-listado")
	public ModelAndView getCuentasPage() {
		ModelAndView modelView = new ModelAndView("cuentas");
		
		if(cuentaService.getAllCuentas() == null) {
			cuentaService.generarTablaCuenta();
		}
		
		modelView.addObject("cuenta",cuentaService.getAllCuentas());
		return modelView;
	}
	 
}
