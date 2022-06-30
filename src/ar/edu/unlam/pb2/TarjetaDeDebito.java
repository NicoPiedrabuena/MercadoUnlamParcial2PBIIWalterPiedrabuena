package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Tarjeta implements Pagadora {

	

	public TarjetaDeDebito(Long numero, String titular, String fechaDeVencimeinto,
			Integer codigoDeSeguridad) throws NumeroDeTarjetaInvalidoException {
		super(numero,titular,fechaDeVencimeinto,codigoDeSeguridad);
		
	}

	

}
