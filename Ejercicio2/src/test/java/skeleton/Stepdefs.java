package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Stepdefs {

	private Juego ahorcado;
	
	@Given("^la palabra secreta es \"(.*?)\"$")
	public void la_palabra_secreta_es(String arg1) throws Throwable {
		
		int idJugador = 1;
		int cantidadDeVidasDefault = 7;
		this.ahorcado = new Juego(arg1,idJugador,cantidadDeVidasDefault);
	}

	@Given("^me quedan (\\d+) vidas$")
	public void me_quedan_vidas(int arg1) throws Throwable {
		this.ahorcado.setIntentosFallidosTolerados(arg1);
		Assert.assertEquals(arg1, this.ahorcado.getIntentosFallidosTolerados());		
	}

	@When("^arriesgo \"(.*?)\"$")
	public void arriesgo(String arg1) throws Throwable {
		this.ahorcado.arriesgarLetra(arg1);
	}
	
	@When("^estado_previo es \"(.*?)\"$")
	public void estado_previo_es(String arg1) throws Throwable {
		this.ahorcado.setEstado(arg1);
	}

	@Then("^estado es \"(.*?)\"$")
	public void estado_es(String arg1) throws Throwable {
		this.ahorcado.arriesgarLetra(arg1);
		Assert.assertTrue(arg1.equals(this.ahorcado.getEstado()));
	}

}
