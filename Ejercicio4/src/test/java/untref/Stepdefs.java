package untref;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Stepdefs {
	
	private Mano manoTruco;
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private int valorEnvido;
	
	@Given("^\"(.*?)\" numero (\\d+) tipo \"(.*?)\"$")
	public void numero_tipo(String arg1, int arg2, String arg3) {
		
		Palo palo;
		
		switch (arg3){
			case "oro": {palo=Palo.ORO;}
				break;
			case "basto": {palo=Palo.BASTO;}
				break;
			case "espada": {palo=Palo.ESPADA;}
				break;
			case "copa": {palo=Palo.COPA;}
				break;
			default:{palo=Palo.ORO;}	
		}
		
		switch (arg1){
			case "carta1": {this.carta1=new Carta(arg2,palo);}
				break;
			case "carta2": {this.carta2=new Carta(arg2,palo);}
				break;
			default:{this.carta3=new Carta(arg2,palo);}	
		}
		
		this.manoTruco=new Mano(this.carta1,this.carta2,this.carta3);
		
	}

	@When("^Calculo el envido de mi mano$")
	public void calculo_el_envido_de_mi_mano() {
		this.valorEnvido=this.manoTruco.getValorEnvido();	    
	}

	@Then("^El envido es (\\d+)\\.$")
	public void el_envido_es(int arg1) {
		
		Assert.assertEquals(arg1, this.valorEnvido);
	    
	}
	
}
