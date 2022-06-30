package ar.edu.unlam.pb2;

public class Cuenta extends MediosDePago{

	private String cbu;
	private String entidad;
	private String titular;
	private Double saldo;
	public Cuenta(String cbu, String entidad, String titular) throws CBUInvalidoException {
		if(cbu.length() != 20) {
			throw new CBUInvalidoException();
		}else {
			this.cbu =cbu;
		}
		this.cbu = cbu;
		this.entidad = entidad;
		this.titular = titular;
		this.saldo = 0.0;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidadEsperada) {
		this.entidad = entidadEsperada;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitularEsperado(String titularEsperado) {
		this.titular = titularEsperado;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
