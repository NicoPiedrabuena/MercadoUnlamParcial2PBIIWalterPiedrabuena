package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException {
		// Preparación
		final Long NUMERO_ESPERADO = 5446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final Double SALDO_ESPERADO = 10000.0;

		// Ejecución
		Pagadora tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO,
				CODIGO_DE_SEGURIDAD_ESPERADO);
		((Tarjeta)tarjetaDeDebito).setSaldo(10000.0);

		// Verificación
		assertEquals(NUMERO_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getNumero());
		assertEquals(TITULAR_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getFechaDeVencimiento());
		assertEquals(SALDO_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getSaldo());
	}

	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException {
		// Preparación
		final Long NUMERO_ESPERADO = 4246789813221201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final Double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final Double LIMITE_COMPRA_EN_DOLARES = 1000.0;

		// Ejecución
		Pagadora tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO,
				FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, LIMITE_COMPRA_EN_PESOS,
				LIMITE_COMPRA_EN_DOLARES);

		// Verificación
		assertEquals(NUMERO_ESPERADO, ((Tarjeta) tarjetaDeCredito).getNumero());
		assertEquals(TITULAR_ESPERADO, ((Tarjeta) tarjetaDeCredito).getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, ((Tarjeta) tarjetaDeCredito).getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, ((Tarjeta) tarjetaDeCredito).getFechaDeVencimiento());
		assertEquals(LIMITE_COMPRA_EN_PESOS, ((TarjetaDeCredito) tarjetaDeCredito).getLimiteEnPesos());
		assertEquals(LIMITE_COMPRA_EN_DOLARES, ((TarjetaDeCredito) tarjetaDeCredito).getLimiteEnDolares());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException{
		// Preparación 
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";
		
		// Ejerución
		Transferible cuentaBancaria = new CuentaBancaria(CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificación
		assertEquals(CBU_ESPERADO, ((Cuenta) cuentaBancaria).getCbu());
		assertEquals(ENTIDAD_ESPERADA, ((Cuenta) cuentaBancaria).getEntidad());
		assertEquals(TITULAR_ESPERADO, ((Cuenta) cuentaBancaria).getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException, CBUInvalidoException{
		// Preparación 
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";
		
		// Ejecución
		Transferible cuentaVirtual = new CuentaVirtual(CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificación
		assertEquals(CVU_ESPERADO, ((CuentaVirtual) cuentaVirtual).getCvu());
		assertEquals(ENTIDAD_ESPERADA, ((Cuenta) cuentaVirtual).getEntidad());
		assertEquals(TITULAR_ESPERADO, ((Cuenta) cuentaVirtual).getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException{
		// Preparación 
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;
		
		// Ejecución
		Comercio elAlmacen = new Comercio(CUIT_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificación
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNombre());
		assertEquals(CUIT_ESPERADO, elAlmacen.getCuit());
	}
	
	@Test
	public void queSePuedaCrearUnConsumidor() {
		// Preparación 
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;
		
		// Ejecución
		Consumidor nuevo = new Consumidor(DNI_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificación
		assertEquals(NOMBRE_ESPERADO, nuevo.getNombre());
		assertEquals(DNI_ESPERADO, nuevo.getDni());
	}
	
	@Test
	public void queSePuedanAgregarComerciosALaBilletera() throws CuitInvalidoException{
		// Preparación 
		final Integer CANTIDAD_DE_COMERCIOS_ESPERADOS = 2;
		
		// Ejecución
		Billetera mataGalan = new Billetera("Ank");
		
		mataGalan.agregarComercio(new Comercio(30456213545L, "Supermercado"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panadería"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panadería"));
		
		// Verificación
		assertEquals(CANTIDAD_DE_COMERCIOS_ESPERADOS, mataGalan.getCantidadDeComercios());
	}
	
	@Test
	public void queSePuedanAgregarConsumidoresALaBilletera() {
		// Preparación 
		final Integer CANTIDAD_DE_CONSUMIDORES_ESPERADOS = 2;
		
		// Ejecución
		Billetera mataGalan = new Billetera("Bna+");
		
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(36541231, "Sofia Molina"));
		
		// Verificación
		assertEquals(CANTIDAD_DE_CONSUMIDORES_ESPERADOS, mataGalan.getCantidadDeConsumidores());
	}
	
	@Test
	public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnConsumidor() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{
		// Preparación 
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 4;
		
		// Ejecución
		Billetera mataGalan = new Billetera("MercadoPago");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(4833256215325462L, "Luis Gomez", "10/10/2026", 265));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(4833256215325462L, "Luis Gomez", "10/10/2026", 312));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(5423542385612354L, "Luis Gomez", "10/10/2026", 153, 10000.0, 5000.0));
		mataGalan.agregarMedioDePago(27541231, new CuentaBancaria("01702046600000087865", "Nación", "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new CuentaVirtual("00000031000365215718060", "Mercado Pago", "Luis Gomez"));
		
		// Verificación
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS, mataGalan.getCantidadDeMediosDePago(27541231));
	}
	
	@Test
	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException, ExcedeLimiteDeCompraException{
		// Preparación 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(4833256215325462L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0));
			
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panadería"));	
		// Ejecución	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.traerConsumidor(27541231).getMedioPagador(4833256215325462L));
		
		// Verificación
		
		
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException{
		// Preparación 
		Billetera mataGalan = new Billetera("Ualá");
		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Nación", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, (Cuenta)cuentaOrigen);
		
		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, (Cuenta)cuentaDestino);
		((Cuenta)cuentaOrigen).setSaldo(3000.0);
		// Ejecución
		
		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino, 2000.0);
				
		// Verificación
		assertTrue(resultado);
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() throws CBUInvalidoException, SaldoInsuficienteException {
		Billetera mataGalan = new Billetera("Ualá");
		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Nación", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, (Cuenta)cuentaOrigen);
		
		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, (Cuenta)cuentaDestino);
		((Cuenta)cuentaOrigen).setSaldo(30.0);
		// Ejecución
		
		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino, 2000.0);
	}
	
	@Test (expected=ExcedeLimiteDeCompraException.class)
	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() throws NumeroDeTarjetaInvalidoException, SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(4833256215325462L, "Luis Gomez", "10/10/2026", 265));
			
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panadería"));	
		
		((Tarjeta) mataGalan.traerConsumidor(27541231).getMedioPagador(4833256215325462L)).setSaldo(2444.0);
		
		// Ejecución	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 3000.0);
		
		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.traerConsumidor(27541231).getMedioPagador(4833256215325462L));
		
		// Verificación
		
		
		
		assertTrue(resultado);
	}
	
	@Test (expected=ExcedeLimiteDeCompraException.class)
	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(4833256215325462L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0));
			
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panadería"));	
		// Ejecución	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 10000000.0);
		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.traerConsumidor(27541231).getMedioPagador(4833256215325462L));
	}

}
