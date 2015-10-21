package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Barco;
import untref.Posicion;

public class BarcoTest {
	
	@Test
	public void crearBarcoTest(){ 
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		Assert.assertNotNull(acorazado);		
	}
	
	@Test
	public void chequearLongitudTest(){
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		Assert.assertEquals(2, acorazado.getLongitud());
	}
	
	@Test 
	public void chequearPosicionTest(){
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		Posicion posicionAlternativa = new Posicion (10,10);
		
		Assert.assertTrue(acorazado.getPosicion().esIgual(posicionAlternativa));
		
	}
	
	@Test
	public void chequearVidasRestantesTest(){
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		acorazado.tocado();
		
		Assert.assertEquals(1,acorazado.getVidasRestantes());	
		
	}
	
	@Test
	public void chequearTipoTest(){
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		Assert.assertEquals("acorazado", acorazado.getTipo());
		
	}
	
	@Test
	public void chequearOrientacionTest(){
		
		Posicion posicionAcorazado = new Posicion (10,10);
		String orientacion="vertical";
		Barco acorazado = new Barco("acorazado",2,posicionAcorazado,orientacion);
		
		Assert.assertEquals("vertical", acorazado.getOrientacion());
	}

}
