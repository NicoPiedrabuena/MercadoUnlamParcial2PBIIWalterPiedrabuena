package ar.edu.unlam.pb2;


public class CuentaBancaria extends Cuenta implements Transferible {
	
	public CuentaBancaria(String cbu, String entidadEsperada, String titularEsperado) throws CBUInvalidoException {
		super(cbu,entidadEsperada,titularEsperado);
		
	}
	
	

}
