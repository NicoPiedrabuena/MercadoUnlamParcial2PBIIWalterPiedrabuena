package ar.edu.unlam.pb2;

public class CuentaVirtual extends Cuenta implements Transferible {

	private String cvu;

	public CuentaVirtual(String cvu, String entidad, String titular) throws CBUInvalidoException, CVUInvalidoException {
		super("00000000000000000000",entidad,titular);
		if(cvu.length() != 23) {
			throw new CVUInvalidoException();
		}else {
			this.cvu = cvu;
		}
		
	}

	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}
	

}
