package ar.edu.unju.fi.tp7.service;

import java.util.List;

import ar.edu.unju.fi.tp7.models.Compra;


public interface ICompraService {
	
	public void guardarCompra(Compra compra);
	
	public void generarTablaCompra();
	
	public List<Compra> getAllCompras();

}
