package untref;

import org.junit.Assert;
import org.junit.Test;

public class CartaTest {
	
	@Test
	public void crearCartaTest(){
		
		Carta carta1 = new Carta(1,Palo.BASTO);
		
		Palo palo = carta1.getPalo();
		
		int numero = carta1.getNumero();
		
		Assert.assertEquals(Palo.BASTO, palo);
		Assert.assertEquals(1, numero);
	}
	
	@Test
	public void compararCartasTest(){
		
		Carta carta1 = new Carta(2,Palo.BASTO);
		Carta carta2 = new Carta(1,Palo.COPA);
		Carta carta3 = new Carta(2,Palo.ORO);
		Carta carta4 = new Carta(4,Palo.BASTO);
		
		Assert.assertTrue(carta1.sameNumero(carta3));
		Assert.assertTrue(carta1.samePalo(carta4));
		Assert.assertFalse(carta2.samePalo(carta3));
		Assert.assertFalse(carta2.sameNumero(carta4));
		
	}

}
