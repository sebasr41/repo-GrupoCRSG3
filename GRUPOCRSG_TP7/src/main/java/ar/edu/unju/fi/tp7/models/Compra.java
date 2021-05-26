package ar.edu.unju.fi.tp7.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "com_cantidad")
	private int cantidad;
	
	@Column(name = "com_total")
	private double total;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Producto producto;
	
	@OneToMany(mappedBy = "compra")
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	
	@Autowired
	@OneToOne
	@JoinColumn(name = "cli_id")
	private Cliente cliente;
	
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Compra(Long id, int cantidad, double total, Producto producto, List<Producto> productos, Cliente cliente) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.total = total;
		this.producto = producto;
		this.productos = productos;
		this.cliente = cliente;
	}


	/***
	 * 
	public Compra(Long id, int cantidad, double total, Producto producto, List<Producto> productos) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.total = total;
		this.producto = producto;
		this.productos = productos;
	}
	 * 
	 */

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "Compra [id=" + id + ", cantidad=" + cantidad + ", total=" + total + ", producto=" + producto
				+ ", productos=" + productos + ", cliente=" + cliente + "]";
	}
	
	

	/***
	@Override
	public String toString() {
		return "Compra [id=" + id + ", cantidad=" + cantidad + ", total=" + total + ", producto=" + producto
				+ ", productos=" + productos + "]";
	}
	 * 
	 */

	
}
