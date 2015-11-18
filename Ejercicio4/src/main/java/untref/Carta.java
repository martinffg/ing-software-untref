package untref;

public class Carta {
	
	private Palo palo;
	private int numero;
	
	public Carta(int numeroCarta,Palo paloCarta){
		this.palo=paloCarta;
		this.numero=numeroCarta;
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
