package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends Tarjeta implements Pagadora {

	private Double limiteEnPesos;
	private Double limiteEnDolares;

	public TarjetaDeCredito(Long numero, String titular, String fechaDeVencimiento,
			Integer codigoDeSeguridad, Double limiteEnPesos, Double limiteEnDolares) throws NumeroDeTarjetaInvalidoException {
		super(numero,titular,fechaDeVencimiento,codigoDeSeguridad);
		this.limiteEnPesos = limiteEnPesos;
		this.limiteEnDolares = limiteEnDolares;
	}

	public Double getSaldo() {
		return limiteEnPesos;
	}
	public Double getLimiteEnPesos() {
		return limiteEnPesos;
	}

	public void setLimiteEnPesos(Double limiteEnPesos) {
		this.limiteEnPesos = limiteEnPesos;
	}

	public Double getLimiteEnDolares() {
		return limiteEnDolares;
	}

	public void setLimiteEnDolares(Double limiteEnDolares) {
		this.limiteEnDolares = limiteEnDolares;
	}

}
