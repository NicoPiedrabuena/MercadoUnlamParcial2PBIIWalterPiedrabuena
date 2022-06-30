package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;

public class Billetera {

	private String nombre;
	private HashSet<Comercio>comercios;
	private HashSet<Consumidor>consumidores;
	public Billetera(String nombre) {
		this.nombre = nombre;
		this.comercios = new HashSet<Comercio>();
		this.consumidores=new HashSet<Consumidor>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarComercio(Comercio comercio) {
		comercios.add(comercio);
		
	}

	public Integer getCantidadDeComercios() {
		// TODO Auto-generated method stub
		return comercios.size();
	}

	public void agregarConsumidor(Consumidor consumidor) {
		consumidores.add(consumidor);
		
	}

	public HashSet<Consumidor> getConsumidores() {
		return consumidores;
	}

	public void setConsumidores(HashSet<Consumidor> consumidores) {
		this.consumidores = consumidores;
	}

	public Integer getCantidadDeConsumidores() {
		return consumidores.size();
	}
	public Consumidor traerConsumidor(Integer dni) {
	for (Consumidor consumidor : consumidores) {
		if(consumidor.getDni().equals(dni)) {
			return consumidor;
			}
		}
	return null;
	}
	public void agregarMedioDePago(Integer dniTitular, MediosDePago medio) {
		Consumidor nuevo; 
		nuevo = traerConsumidor(dniTitular);
		nuevo.agregarMedioDePago(medio);
		
	}

	

	public Integer getCantidadDeMediosDePago(Integer dniTitular) {
		Consumidor nuevo; 
		nuevo = traerConsumidor(dniTitular);
		return nuevo.getMediosDePago().size();
	}

	public Compra generarCodigoQR(Long cuit, Double saldo) {
		Compra compra = new Compra(cuit,saldo);
		return compra;
	}

	public Boolean pagar(Compra codigoQR, Pagadora medioPagador) throws ExcedeLimiteDeCompraException {
	if(codigoQR.getSaldo()<= ((Tarjeta)medioPagador).getSaldo()) {
		((Tarjeta)medioPagador).setSaldo(((Tarjeta)medioPagador).getSaldo()-codigoQR.getSaldo());
		return true;
	}throw new ExcedeLimiteDeCompraException();

	}

	public Boolean transferir(Transferible cuentaOrigen, Transferible cuentaDestino, Double importeATransferir) throws SaldoInsuficienteException {
		if(((Cuenta)cuentaOrigen).getSaldo() >= importeATransferir){
			((Cuenta)cuentaOrigen).setSaldo(((Cuenta)cuentaOrigen).getSaldo()-importeATransferir);
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
	
	}

	
}
