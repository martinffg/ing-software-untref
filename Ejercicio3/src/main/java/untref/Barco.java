package untref;

public class Barco {
	
	private	int longitud;
	private int vidasRestantes;
	private String tipo;
	private Posicion posicion;
	private String orientacion;
	
	public Barco(String tipoBarco,int longitud,Posicion posicionInicio,String orientacion){
		this.tipo=tipoBarco;
		this.longitud=longitud;
		this.vidasRestantes=longitud;
		this.posicion=posicionInicio;
		this.orientacion=orientacion;		
	}
	
	public int getLongitud() {
		return longitud;
	}
	public int getVidasRestantes() {
		return vidasRestantes;
	}
	public String getTipo() {
		return tipo;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public String getOrientacion() {
		return orientacion;
	}
	
	public void tocado(){
		if (this.getVidasRestantes()>0) {
			this.vidasRestantes--;			
		}
	}
}
