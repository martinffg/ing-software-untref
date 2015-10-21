package skeleton;

public class Jugador {
	
	private int idJugador;
	private int vidas;
	private String intentosFallidos;
	
	public Jugador(int id,int vidasJugador){
		this.idJugador=id;
		this.vidas=vidasJugador;
		this.intentosFallidos="";		
	}

	public int getIdJugador() {
		return idJugador;
	}

	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getIntentosFallidos() {
		return intentosFallidos;
	}
	
	public void restarVidas(){
		
		if (this.vidas>0){
			this.vidas--;
		}
	}
	
	public void agregarIntentosFallidos(String caracterFallido){
		this.intentosFallidos+=caracterFallido;
	}

}
