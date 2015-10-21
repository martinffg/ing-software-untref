package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Barco;
import untref.Lancha;
import untref.Posicion;

public class LanchaTest {
	
	@Test
	public void crearLanchaTest(){ 
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		Assert.assertNotNull(lancha);		
	}
	
	@Test
	public void chequearLongitudTest(){
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		Assert.assertEquals(1, lancha.getLongitud());
	}
	
	@Test 
	public void chequearPosicionTest(){
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		Posicion posicionAlternativa = new Posicion (1,3);
		
		Assert.assertTrue(lancha.getPosicion().esIgual(posicionAlternativa));
		
	}
	
	@Test
	public void chequearVidasRestantesTest(){
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		lancha.tocado();
		
		Assert.assertEquals(0,lancha.getVidasRestantes());	
		
	}
	
	@Test
	public void chequearTipoTest(){
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		Assert.assertEquals("lancha", lancha.getTipo());
		
	}
	
	@Test
	public void chequearOrientacionTest(){
		
		Posicion posicionLancha = new Posicion (1,3);
		String orientacion="horizontal";
		Barco lancha = new Lancha(posicionLancha,orientacion);
		
		Assert.assertEquals("horizontal", lancha.getOrientacion());
	}

}
