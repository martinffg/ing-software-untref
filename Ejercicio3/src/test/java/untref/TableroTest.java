package untref;

import org.junit.Assert;
import org.junit.Test;

import untref.Acorazado;
import untref.Barco;
import untref.Lancha;
import untref.Posicion;
import untref.Tablero;

public class TableroTest {
	
	@Test
	public void crearTableroTest(){
		
		int columnas=10;
		int filas=10;
		
		Tablero tableroBatallaNaval = new Tablero(filas,columnas);
		
		Assert.assertNotNull(tableroBatallaNaval);
	}
	
	@Test
	public void chequearFilasColumnasTableroTest(){
		
		Tablero tableroBatallaNaval = new Tablero(20,30);
		
		Assert.assertEquals(30, tableroBatallaNaval.getColumnas());
		Assert.assertEquals(20, tableroBatallaNaval.getFilas());	
	}
			
	@Test
	public void chequearTableroVacioTest() {
		
		Tablero tableroBatallaNaval = new Tablero(20,30);
		
		Assert.assertEquals(0, tableroBatallaNaval.getCantidadDeBarcos());
		
	}
	
	@Test
	public void chequearPosicionTableroVacia(){
		
		Tablero tableroBatallaNaval = new Tablero(20,30);
		Posicion posicionConsulta= new Posicion(2,3);
		Posicion posicionLancha= new Posicion(10,10);
		
		Barco lancha = new Lancha(posicionLancha,"vertical");
		
		tableroBatallaNaval.agregarBarco(lancha);
		
		Assert.assertNull(tableroBatallaNaval.getBarcoEnPosicion(posicionConsulta));
		
	}
		
	@Test
	public void chequearValidezPosicionTableroConBarco(){
		
		Tablero tableroBatallaNaval = new Tablero(20,30);
		Posicion posicionConsulta= new Posicion(2,3);
		
		Barco acorazado = new Acorazado(posicionConsulta,"vertical");
		
		tableroBatallaNaval.agregarBarco(acorazado);
		
		Assert.assertTrue(tableroBatallaNaval.esPosibleAgregarBarco(acorazado)); 
		Assert.assertNotNull(tableroBatallaNaval.getBarcoEnPosicion(posicionConsulta));
		
	}
	
	@Test
	public void chequearTableroLlenoTest() {
		
		Tablero tableroBatallaNaval = new Tablero(20,30);
		Barco lancha;
		
		// lleno el tablero con lanchas de prueba
		for (int i=0;i<tableroBatallaNaval.getFilas();i++) {
			for (int j=0;j<tableroBatallaNaval.getColumnas();j++) {		
				lancha=new Lancha(new Posicion(i,j),"vertical");
				tableroBatallaNaval.agregarBarco(lancha);
			}
		}
		
		Assert.assertTrue(tableroBatallaNaval.estaLleno());
		Assert.assertEquals(600, tableroBatallaNaval.getCantidadDeBarcos());
		
	}
}
