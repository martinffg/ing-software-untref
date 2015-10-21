package untref;

public class Posicion {
	
	private int fila;
	private int columna;
	
	Posicion(int fila,int columna){
		this.fila=Math.abs(fila);
		this.columna=Math.abs(columna);		
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public boolean esIgual(Posicion otraPosicion){
		
		return ((this.getFila()==otraPosicion.getFila())&&
				(this.getColumna()==otraPosicion.getColumna()));
	}

}
