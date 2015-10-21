package untref;

import org.junit.Assert;

import untref.BatallaNaval;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Stepdefs {
	
	private BatallaNaval batallaNaval;
		
	@Given("^tengo un tablero de (\\d+)\\*(\\d+)$")
	public void tengo_un_tablero_de(int arg1, int arg2) throws Throwable {
	
		this.batallaNaval=new BatallaNaval(arg1,arg2);
	
		Assert.assertNotNull(this.batallaNaval);		
	}

	@Given("^no hay barco en posicion (\\d+),(\\d+)$")
	public void no_hay_barco_en_posicion(int arg1, int arg2) throws Throwable {
		Assert.assertFalse(this.batallaNaval.consultarExistenciaBarcoEnPosicionTablero1(arg1, arg2));
	}
	
	@Given("^hay barco en posicion (\\d+),(\\d+)$")
	public void hay_barco_en_posicion(int arg1, int arg2) throws Throwable {
		
		boolean agregoBarco=this.batallaNaval.ubicarBarcoJugador1(arg1, arg2, "horizontal", "lancha");
		
		Assert.assertTrue(agregoBarco);
		Assert.assertTrue(this.batallaNaval.consultarExistenciaBarcoEnPosicionTablero1(arg1, arg2));	
	}
	
	@Given("^el resto del barco fue tocado$")
	public void el_resto_del_barco_fue_tocado() throws Throwable {
		
		boolean exitoInsercion=false;
		boolean exitoDisparo=false;
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		exitoInsercion=this.batallaNaval.ubicarBarcoJugador2(5,2,"vertical","acorazado");
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(5,2);
		
		Assert.assertTrue(exitoInsercion);
		Assert.assertTrue(exitoDisparo);
		
	}
	
	@When("^jugador elige un \"(.*?)\"$")
	public void jugador_elige_un(String arg1) throws Throwable {
		
		boolean agregoBarco=this.batallaNaval.ubicarBarcoJugador1(2, 2, "vertical",arg1);
		
		Assert.assertTrue(agregoBarco);
		
	}

	@When("^la posicion es (\\d+),(\\d+)$")
	public void la_posicion_es(int arg1, int arg2) throws Throwable {
		
		boolean agregoBarco=this.batallaNaval.ubicarBarcoJugador1(arg1, arg2, "vertical","lancha");
		
		if (arg1<0 || arg1>=10 || arg2<0 || arg2>=10) {
			Assert.assertFalse(agregoBarco);
		} else {
			Assert.assertTrue(agregoBarco);
		}
		
	}

	@When("^la orientacion es \"(.*?)\"$")
	public void la_orientacion_es(String arg1) throws Throwable {
		
		boolean agregoBarco=this.batallaNaval.ubicarBarcoJugador1(4,4, arg1,"acorazado");
		
		Assert.assertTrue(agregoBarco);
	}
	
	@When("^disparo a la posicion (\\d+),(\\d+)$")
	public void disparo_a_la_posicion(int arg1, int arg2) throws Throwable {
		
		boolean exitoInsercion=false;
		boolean exitoDisparo=false;
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		exitoInsercion=this.batallaNaval.ubicarBarcoJugador2(arg1,arg2,"vertical","acorazado");
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(arg1,arg2);
		
		if ((Math.abs(arg1)<this.batallaNaval.getCantFilasTablero())&&
				(Math.abs(arg2)<this.batallaNaval.getCantColumnasTablero())) {
			Assert.assertTrue(exitoInsercion);
			Assert.assertTrue(exitoDisparo);
		} else {
			Assert.assertFalse(exitoInsercion);
			Assert.assertFalse(exitoDisparo);
		}
	}	

	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() throws Throwable {
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		boolean agregoBarco=this.batallaNaval.ubicarBarcoJugador1(3,3,"Horizontal","acorazado");
		
		Assert.assertTrue(agregoBarco);
	}
	
	@Then("^error al posicionar barco$")
	public void error_al_posicionar_barco() throws Throwable {
		
		this.batallaNaval.ubicarBarcoJugador1(3,3,"Horizontal","acorazado");
		boolean agregoBarco2=this.batallaNaval.ubicarBarcoJugador1(3,3,"Horizontal","acorazado");
		
		Assert.assertFalse(agregoBarco2);
	}
	
	@Then("^posicion fuera de tablero$")
	public void posicion_fuera_de_tablero() throws Throwable {
		
		boolean agregoBarco2=this.batallaNaval.ubicarBarcoJugador1(11,1,"vertical","lancha");
		
		Assert.assertFalse(agregoBarco2);	
	}
	
	@Then("^el resultado fue hundido$")
	public void el_resultado_fue_hundido() throws Throwable {
		
		boolean exitoInsercion=false;
		boolean exitoDisparo=false;
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		exitoInsercion=this.batallaNaval.ubicarBarcoJugador2(5,2,"vertical","acorazado");
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(5,2);
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(6,2);
		
		Assert.assertTrue(exitoInsercion);
		Assert.assertTrue(exitoDisparo);
		Assert.assertFalse(this.batallaNaval.consultarExistenciaBarcoEnPosicionTablero2(5,2));
		Assert.assertFalse(this.batallaNaval.consultarExistenciaBarcoEnPosicionTablero2(6,2));		
	}
	
	@Then("^el resultado fue agua$")
	public void el_resultado_fue_agua() throws Throwable {
		boolean exitoDisparo=false;
		boolean exitoBusqueda=false;
		this.batallaNaval=new BatallaNaval(10,10);
		exitoBusqueda=this.batallaNaval.consultarExistenciaBarcoEnPosicionTablero2(2,7);
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(2,7);
		
		Assert.assertFalse(exitoBusqueda);
		Assert.assertFalse(exitoDisparo);
	}

	@Then("^el resultado fue tocado$")
	public void el_resultado_fue_tocado() throws Throwable {
		
		boolean exitoInsercion=false;
		boolean exitoDisparo=false;
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		exitoInsercion=this.batallaNaval.ubicarBarcoJugador2(3,4,"vertical","acorazado");
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(4,4);
		
		Assert.assertTrue(exitoInsercion);
		Assert.assertTrue(exitoDisparo);
	}

	@Then("^el resultado fue posicion_invalida$")
	public void el_resultado_fue_posicion_invalida() throws Throwable {
		boolean exitoInsercion=false;
		boolean exitoDisparo=false;
		
		this.batallaNaval=new BatallaNaval(10,10);
		
		exitoInsercion=this.batallaNaval.ubicarBarcoJugador2(3,4,"vertical","acorazado");
		exitoDisparo=this.batallaNaval.dispararABarcosOponentesDesdeJugador1(11,1);
		
		Assert.assertTrue(exitoInsercion);
		Assert.assertFalse(exitoDisparo);

	}	

}
