package ar.edu.unlam.pb2;

import java.util.Objects;

public class Tarjeta extends MediosDePago{

	private Long numero;
	private String titular;
	private String fechaDeVencimeinto;
	private Integer codigoDeSeguridad;
	private Double saldo;

	public Tarjeta(Long numero, String titular, String fechaDeVencimeinto, Integer codigoDeSeguridad) throws NumeroDeTarjetaInvalidoException {
		if(Long.toString(numero).length() != 16) {
			throw new NumeroDeTarjetaInvalidoException();
		}else {
			this.numero = numero;
		}
		this.numero  = numero;
		this.titular = titular;
		this.fechaDeVencimeinto = fechaDeVencimeinto;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.saldo = 0.0;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double medioPagador) {
		this.saldo = medioPagador;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimeinto;
	}

	public void setFechaDeVencimeinto(String fechaDeVencimeinto) {
		this.fechaDeVencimeinto = fechaDeVencimeinto;
	}

	public Integer getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}

	public void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(numero, other.numero);
	}
	
	

}
