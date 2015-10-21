package skeleton;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {
	
	
	@Test
	public void crearJuegoTest(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		
		Assert.assertEquals("****", ahorcado.getEstado());
		Assert.assertEquals(1, ahorcado.getJugador().getIdJugador());
		Assert.assertEquals(7, ahorcado.getIntentosFallidosTolerados());	
	}
	
	@Test
	public void arriesgarLetraMinusculaAlInicioyAcierto(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		
		ahorcado.arriesgarLetra("a");
		
		Assert.assertEquals("a***", ahorcado.getEstado());
		Assert.assertEquals(7, ahorcado.getIntentosFallidosTolerados());		
		
	}
	@Test
	public void arriesgarLetraMayusculaAlInicioyAcierto(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		
		ahorcado.arriesgarLetra("O");
		
		Assert.assertEquals("***o", ahorcado.getEstado());
		Assert.assertEquals(7, ahorcado.getIntentosFallidosTolerados());		
		
	}
	@Test
	public void arriesgarLetraAlInicioyNoAcierto(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		
		ahorcado.arriesgarLetra("x");
		
		Assert.assertEquals("****", ahorcado.getEstado());
		Assert.assertEquals(6, ahorcado.getIntentosFallidosTolerados());		
		
	}
	
	@Test
	public void arriesgarLetraNoAciertoYPierdo(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		ahorcado.setIntentosFallidosTolerados(1);
		
		ahorcado.arriesgarLetra("w");
		
		Assert.assertEquals("Ahorcado!", ahorcado.getEstado());
		Assert.assertEquals(0, ahorcado.getIntentosFallidosTolerados());		
		
	}
		
	@Test
	public void arriesgarLetraAciertoYGano(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=7;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		ahorcado.arriesgarLetra("a");
		ahorcado.arriesgarLetra("u");
		ahorcado.arriesgarLetra("T");
		ahorcado.arriesgarLetra("O");
						
		Assert.assertEquals("auto", ahorcado.getEstado());
		Assert.assertEquals(7, ahorcado.getIntentosFallidosTolerados());		
		
	}
	
	@Test
	public void arriesgarLetraLuegoDeHaberPerdido(){
		
		String palabraSecreta="auto";
		int intentosPermitidos=0;
		int idJugador=1;
		
		Juego ahorcado = new Juego(palabraSecreta,idJugador,intentosPermitidos);
		ahorcado.arriesgarLetra("x");
		ahorcado.arriesgarLetra("r");
		ahorcado.arriesgarLetra("T");
						
		Assert.assertEquals("Ahorcado!", ahorcado.getEstado());
		Assert.assertEquals(0, ahorcado.getIntentosFallidosTolerados());		
		
	}

}
