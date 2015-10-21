package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Acorazado;
import untref.Barco;
import untref.Posicion;

public class AcorazadoTest {
	
	@Test
	public void crearAcorazadoTest(){ 
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		Assert.assertNotNull(acorazado);		
	}
	
	@Test
	public void chequearLongitudTest(){
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		Assert.assertEquals(2, acorazado.getLongitud());
	}
	
	@Test 
	public void chequearPosicionTest(){
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		Posicion posicionAlternativa = new Posicion (1,1);
		
		Assert.assertTrue(acorazado.getPosicion().esIgual(posicionAlternativa));
		
	}
	
	@Test
	public void chequearVidasRestantesTest(){
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		acorazado.tocado();
		
		Assert.assertEquals(1,acorazado.getVidasRestantes());	
		
	}
	
	@Test
	public void chequearTipoTest(){
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		Assert.assertEquals("acorazado", acorazado.getTipo());
		
	}
	
	@Test
	public void chequearOrientacionTest(){
		
		Posicion posicionAcorazado = new Posicion (1,1);
		String orientacion="horizontal";
		Barco acorazado = new Acorazado(posicionAcorazado,orientacion);
		
		Assert.assertEquals("horizontal", acorazado.getOrientacion());
	}

}
