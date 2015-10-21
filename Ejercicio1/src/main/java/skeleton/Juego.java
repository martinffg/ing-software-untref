package skeleton;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Juego(){
	
		this.jugador1= new Jugador(1);
		this.jugador2= new Jugador(2);
		
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}
	
	public int getGanador() {
		
		int resultadoGanador=-1;
		
		if ((this.jugador1.getManoActual() != null)&&(this.jugador2.getManoActual() != null)) {
			
			resultadoGanador=this.jugador1.getManoActual().compararMano(this.jugador2.getManoActual());
		
		}
		
		return resultadoGanador;
	}

}
