package ar.edu.unju.fi.tp7.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_codigo", nullable = false)
	private long codigo;
	
	@Column(name = "prod_nombre", length = 100)
	private String nombre;
	
	@Column(name = "prod_precio")
	private double precio;
	
	@Column(name = "prod_marca", length = 100)
	private String marca;
	
	@Column(name = "prod_stock")
	private int stock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "com_id")
	private Compra compra;
	
	// Constructor empty
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long id, int codigo, String nombre, double precio, String marca, int stock, Compra compra) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.compra = compra;
	}

	// Setters and getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	// to String

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock + ", compra=" + compra + "]";
	}
	
	
	
}
