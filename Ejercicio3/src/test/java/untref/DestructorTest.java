package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Barco;
import untref.Destructor;
import untref.Posicion;

public class DestructorTest {
	
	@Test
	public void crearDestructorTest(){ 
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		Assert.assertNotNull(destructor);		
	}
	
	@Test
	public void chequearLongitudTest(){
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		Assert.assertEquals(3, destructor.getLongitud());
	}
	
	@Test 
	public void chequearPosicionTest(){
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		Posicion posicionAlternativa = new Posicion (3,2);
		
		Assert.assertTrue(destructor.getPosicion().esIgual(posicionAlternativa));
		
	}
	
	@Test
	public void chequearVidasRestantesTest(){
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		destructor.tocado();
				
		Assert.assertEquals(2,destructor.getVidasRestantes());	
		
	}
	
	@Test
	public void chequearTipoTest(){
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		Assert.assertEquals("destructor", destructor.getTipo());
		
	}
	
	@Test
	public void chequearOrientacionTest(){
		
		Posicion posicionDestructor = new Posicion (3,2);
		String orientacion="vertical";
		Barco destructor = new Destructor(posicionDestructor,orientacion);
		
		Assert.assertEquals("vertical", destructor.getOrientacion());
	}

}
