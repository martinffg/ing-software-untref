package untref;

import org.junit.Assert;
import org.junit.Test;

public class ManoTest {
	
	@Test
	public void probarMano3CartasDistintoPalo(){
		Carta carta1 = new Carta(1,Palo.COPA);
		Carta carta2 = new Carta(1,Palo.ESPADA);
		Carta carta3 = new Carta(1,Palo.ORO);		
		Mano mano= new Mano(carta1,carta2,carta3);
		
		Assert.assertEquals(1,mano.getValorEnvido());
	}
	
	@Test
	public void probarMano3CartasMismoPalo(){
		Carta carta1 = new Carta(3,Palo.COPA);
		Carta carta2 = new Carta(1,Palo.COPA);
		Carta carta3 = new Carta(4,Palo.COPA);		
		Mano mano= new Mano(carta1,carta2,carta3);
		
		Assert.assertEquals(27,mano.getValorEnvido());
	}
	
	@Test
	public void probarManoSolo2CartasMismoPalo(){
		Carta carta1 = new Carta(1,Palo.COPA);
		Carta carta2 = new Carta(7,Palo.COPA);
		Carta carta3 = new Carta(1,Palo.ORO);		
		Mano mano= new Mano(carta1,carta2,carta3);
		
		Assert.assertEquals(28,mano.getValorEnvido());
	}
}
