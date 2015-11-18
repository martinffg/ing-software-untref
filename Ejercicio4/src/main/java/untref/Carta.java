package untref;

public class Carta {
	
	private Palo palo;
	private int numero;
	
	public Carta(int numeroCarta,Palo paloCarta) {
		
		if ((numeroCarta>=1)&&(numeroCarta<=7) || 
				(numeroCarta>=10)&&(numeroCarta<=12)) {
		
			this.palo=paloCarta;
			this.numero=numeroCarta;
		} else {
			this.numero=4; // le asigno la carta de menor valor.
		}
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean samePalo(Carta otraCarta){
		return this.getPalo()==otraCarta.getPalo();
	}
	
	public boolean sameNumero(Carta otraCarta){
		return this.getNumero()==otraCarta.getNumero();
	}
}
