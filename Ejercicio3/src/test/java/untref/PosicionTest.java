package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Posicion;

public class PosicionTest {
	
	@Test
	public void crearPosicionTest(){
		int fila=1;
		int columna=1;
		Posicion posicion = new Posicion(fila,columna);
		
		Assert.assertNotNull(posicion);
	}
	
	@Test
	public void validarPosicionTest(){
		
		int fila=10;
		int columna=-10; // debera validar y tomar el valor absoluto
		
		Posicion posicion = new Posicion(fila,columna);
				
		Assert.assertEquals(10, posicion.getFila());
		Assert.assertEquals(10, posicion.getColumna());
	}

}
