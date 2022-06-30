package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;

public class Consumidor {

	private String nombre;
	private Integer dni;
	private HashSet<MediosDePago>mediosDePago;

	public Consumidor(Integer dni, String nombre) {
		this.nombre= nombre;
		this.dni = dni;
		this.mediosDePago = new HashSet<MediosDePago>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		return Objects.equals(dni, other.dni);
	}

	public void agregarMedioDePago(MediosDePago medio) {
		mediosDePago.add(medio);
		
	}

	public HashSet<MediosDePago> getMediosDePago() {
		return mediosDePago;
	}
	

	public void setMediosDePago(HashSet<MediosDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public Pagadora getMedioPagador(long numeroTarjeta) {
		for (MediosDePago mediosDePago : mediosDePago) {
			if(mediosDePago instanceof Pagadora) {
				if(((Tarjeta)mediosDePago).getNumero().equals(numeroTarjeta)){
					return (Pagadora) mediosDePago;
				}
			}
		}
		return null;
	}
	
	

}
