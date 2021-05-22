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
@Table(name="COMPRA")
public class Compra {
		
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
		
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "pro_codigo")
private Producto producto;

@Column(name = "com_cantidad")
private int cantidad;
		
@Column(name = "com_total")
private double total;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Compra(int id, int cantidad, double total, Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.total = total;
		this.producto = producto;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Compra [id=" + id + ", cantidad=" + cantidad + ", total=" + total + ", producto=" + producto + "]";
	}	
}
