package skeleton;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Stepdefs {
	
	private Calculator calculator;
	private int result;
	private Juego juego = new Juego();	
	private int numeroJugadorGanadorMano=0;
	
	@Given("^I have (\\d+) cukes in my belly$")
    	public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        	Belly belly = new Belly();
        	belly.eat(cukes);
    	}
	
	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
		this.calculator = new Calculator();
	}

	@Given("^jugador1 juega PIEDRA$")
	public void jugador1_juega_PIEDRA() throws Throwable {
		Mano manoActual=new Piedra();
		this.juego.getJugador1().juega(manoActual);
		
	}
	
	@Given("^jugador1 juega PAPEL$")
	public void jugador1_juega_PAPEL() throws Throwable {
		Mano manoActual=new Papel();
		this.juego.getJugador1().juega(manoActual);
	}

	@Given("^jugador1 juega TIJERA$")
	public void jugador1_juega_TIJERA() throws Throwable {
		Mano manoActual=new Tijera();
		this.juego.getJugador1().juega(manoActual);
	}
		
	@When("^I wait (\\d+) hour$")
	public void i_wait_hour(int arg1) throws Throwable {
		
	}

	@When("^I add (\\d+) and (\\d+)$")
	public void i_add_and(int number1, int number2) throws Throwable {
		this.result = this.calculator.add(number1,number2);
	}
	
	@When("^jugador2 juega PAPEL$")
	public void jugador2_juega_PAPEL() throws Throwable {
		Mano manoActual=new Papel();
		this.juego.getJugador2().juega(manoActual);

	}

	@When("^jugador2 juega PIEDRA$")
	public void jugador2_juega_PIEDRA() throws Throwable {
		Mano manoActual=new Piedra();
		this.juego.getJugador2().juega(manoActual);
	}

	@When("^jugador2 juega TIJERA$")
	public void jugador2_juega_TIJERA() throws Throwable {
		Mano manoActual=new Tijera();
		this.juego.getJugador2().juega(manoActual);

	}
		
	@Then("^gana jugador(\\d+)$")
	public void gana_jugador(int numeroDeJugador) throws Throwable {
		
		if ((numeroDeJugador == 1) && (this.juego.getGanador()== 1)) {
			this.numeroJugadorGanadorMano=1;		
		} else if ((numeroDeJugador == 2) && (this.juego.getGanador()== 2)) {
			this.numeroJugadorGanadorMano=2;
		} else {
			this.numeroJugadorGanadorMano=0;
		}
		
		Assert.assertEquals(numeroDeJugador, this.numeroJugadorGanadorMano);
	}
	
	@Then("^hay empate$")
	public void hay_empate() throws Throwable {
		int numeroDeJugador= 0; // Condicion de empate
		
		Assert.assertEquals(numeroDeJugador,this.juego.getGanador());
	
	}
	
	@Then("^I get (\\d+)$")
	public void i_get(int resultNumber) throws Throwable {
		if (this.result != resultNumber)
			throw new Exception();
	}
	
	@Then("^my belly should growl$")
	public void my_belly_should_growl() throws Throwable {
		
	}

}
