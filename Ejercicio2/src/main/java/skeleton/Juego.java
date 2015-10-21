package skeleton;


public class Juego {
	
	private String palabraSecreta;
	private Jugador jugador;
	private String estado;
	private int intentosFallidosTolerados;
	
	public Juego(String palabraSecreta,int idJugador,int intentosPermitidos){
		this.palabraSecreta=palabraSecreta.toLowerCase();
		this.jugador=new Jugador(idJugador,intentosPermitidos);
		this.estado= this.setEstadoInicial(palabraSecreta.length());
		this.intentosFallidosTolerados=intentosPermitidos;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIntentosFallidosTolerados() {
		return intentosFallidosTolerados;
	}
	
	public void setIntentosFallidosTolerados(int intentosFallidosTolerados) {
		this.intentosFallidosTolerados = intentosFallidosTolerados;
		this.jugador.setVidas(intentosFallidosTolerados);
	}

	public String arriesgarLetra(String letraArriesgada){
		letraArriesgada=letraArriesgada.toLowerCase();
			
		if (this.getIntentosFallidosTolerados()>0) {
			this.validarEstadoPorLetraArriesgada(letraArriesgada);
		} else {
			this.estado="Ahorcado!";
		} 
		
		return this.getEstado();
	}

	private void validarEstadoPorLetraArriesgada(String letraArriesgada) {
		if (!this.palabraSecreta.equals(this.estado)) {
		
			if (this.palabraSecreta.contains(letraArriesgada)){
				this.setEstadoActual(letraArriesgada);
			} else {
				this.setEstadoActualPorLetraInexistente(letraArriesgada); 
			}
		}
	}

	private void setEstadoActualPorLetraInexistente(String letraArriesgada) {
		if (this.getIntentosFallidosTolerados()>0){
			this.intentosFallidosTolerados--;
			this.getJugador().agregarIntentosFallidos(letraArriesgada);
			this.getJugador().restarVidas();	
			if (this.getIntentosFallidosTolerados()==0) {
				this.estado="Ahorcado!";
			}
		} else {
			this.estado="Ahorcado!";
		}
	}

	private String setEstadoInicial(int cantidadCaracteresAsterisco){
		String resultadoAsteriscos="";
		
		for (int i=0;i<cantidadCaracteresAsterisco;i++){
			resultadoAsteriscos+="*";
		}
		
		return resultadoAsteriscos;
	}
	
	private void setEstadoActual(String letraArriesgada){
		char letraArriesgadaMinuscula=letraArriesgada.toLowerCase().toCharArray()[0];
		char[] palabraSecretaArrayChar=this.palabraSecreta.toCharArray();
		char[] estadoActualArrayChar=this.estado.toCharArray();
		String cadenaResultado="";
		
		for (int i=0;i<this.palabraSecreta.length();i++){
			
			if (palabraSecretaArrayChar[i]==letraArriesgadaMinuscula){
				estadoActualArrayChar[i]=letraArriesgadaMinuscula;
			}
			cadenaResultado+=estadoActualArrayChar[i];
		}
		this.estado=cadenaResultado;
	}
	
}
