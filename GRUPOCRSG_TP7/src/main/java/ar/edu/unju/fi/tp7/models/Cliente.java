package ar.edu.unju.fi.tp7.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
	}

	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public int getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getNombreApellido() {
		return nombreApellido;
	}


	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}


	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}


	public int getNroTelefono() {
		return nroTelefono;
	}


	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}


	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}


	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono=" + nroTelefono
				+ ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}
	
	//Método para obtener la edad:
	
	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}
	
	//Método para obtener el tiempo entre la fecha de la última compra y la fecha actual
	
	public String getTiempoUltimaCompraHoy() {
		String texto = ""; 
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between( this.fechaUltimaCompra, hoy);
		texto = "Año/s: " + periodo.getYears() + " - Mes/es: " + periodo.getMonths() + " - Dia/s: " + periodo.getDays();
		return texto;
	}
	
	//Método para obtener el tiempo expresado en días desde la fecha de nacimiento hasta la fecha actual 
	
	public String getTiempoNacimientoAhoraDias() {
		String texto = ""; 
		LocalDate hoy = LocalDate.now();
		int dias = (int) ChronoUnit.DAYS.between(this.fechaNacimiento, hoy);
		texto = dias + " dias"; 
		return texto;
	}
	
	//Método para obtener el tiempo hasta el cumpleaños
	
	public String getTiempoHastaCumple() {
		String texto ="";
		LocalDate hoy = LocalDate.now();
		int varanio;
		if(hoy.getMonthValue() < this.fechaNacimiento.getMonthValue()) {
			varanio = hoy.getYear();
		}else {
			varanio = hoy.getYear()+1;
		}
		
		LocalDate fechaProximoCumple = LocalDate.of(varanio,this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth() );
        Period periodo = Period.between(hoy,fechaProximoCumple );

        texto = "Dias :"+ periodo.getDays() + " - Meses: "+periodo.getMonths() + " - Año: "+ periodo.getYears();

        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime fechaHoraProxCumple = LocalDateTime.of(varanio,this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth(),0,0,0);

        Duration duracion = Duration.between(ahora,fechaHoraProxCumple);
        texto = texto + " - Horas: "+duracion.toHoursPart() + " - Min: "+duracion.toMinutesPart() + " - Seg: "+duracion.toSecondsPart();
        return texto;
		
	}
}
