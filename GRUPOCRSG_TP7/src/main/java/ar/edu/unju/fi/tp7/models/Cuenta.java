package ar.edu.unju.fi.tp7.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cue_saldo")
	private double saldo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cue_fechaCreacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "cue_estado")
	private String estado;
	
	@Autowired
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	

	public Cuenta(Long id, double saldo, LocalDate fechaCreacion, String estado, Cliente cliente) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.cliente = cliente;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", cliente=" + cliente + "]";
	}


	

}

