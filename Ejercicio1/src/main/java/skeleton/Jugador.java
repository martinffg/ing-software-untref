package skeleton;

public class Jugador {
	
	private int numeroJugador;
	
	private Mano manoActual;
	
	public Jugador(int numeroJugador){
		
		this.numeroJugador=numeroJugador;
		this.manoActual=null;
	}
	
	public void juega(Mano manoActual){
		
		this.manoActual=manoActual;
		
	}
	

	public Mano getManoActual() {
		return manoActual;
	}

	public void setManoActual(Mano manoActual) {
		this.manoActual = manoActual;
	}

	public int getNumeroJugador() {
		return numeroJugador;
	}

}
