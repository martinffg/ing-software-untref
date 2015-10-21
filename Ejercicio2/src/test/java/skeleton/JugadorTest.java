package skeleton;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void crearJugadorTest(){
		
		Jugador jugador1 = new Jugador(1,7);
		
		Assert.assertNotNull(jugador1);
		Assert.assertEquals(7,jugador1.getVidas());
		Assert.assertEquals(1,jugador1.getIdJugador());
		Assert.assertEquals("",jugador1.getIntentosFallidos());
		
	}
	
	@Test
	public void restarVidasTest(){
		
		Jugador jugador1 = new Jugador(1,7);
		Jugador jugador2 = new Jugador(1,1);
		Jugador jugador3 = new Jugador(1,0);
		
		jugador1.restarVidas();
		jugador2.restarVidas();
		jugador3.restarVidas();
		
		Assert.assertEquals(6,jugador1.getVidas());
		Assert.assertEquals(0,jugador2.getVidas());
		Assert.assertEquals(0,jugador3.getVidas());
		
	}
	
	@Test
	public void agregarIntentosFallidosTest(){
		
		Jugador jugador1 = new Jugador(1,7);
		
		jugador1.agregarIntentosFallidos("B");
		jugador1.agregarIntentosFallidos("R");
		jugador1.agregarIntentosFallidos("S");
		
		Assert.assertEquals("BRS", jugador1.getIntentosFallidos());		
		
	}
	

}
