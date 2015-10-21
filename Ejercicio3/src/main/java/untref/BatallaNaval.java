package untref;

public class BatallaNaval {
	
	private int cantFilasTablero;
	private int cantColumnasTablero;
	private Tablero tableroJugador1;
	private Tablero tableroJugador2;
		
	public BatallaNaval(int filasTablero,int columnasTablero){
		
		this.cantFilasTablero=filasTablero;
		this.cantColumnasTablero=columnasTablero;		
		this.tableroJugador1= new Tablero(filasTablero,columnasTablero);
		this.tableroJugador2= new Tablero(filasTablero,columnasTablero);
	}
	
	public int getCantFilasTablero() {
		return cantFilasTablero;
	}

	public int getCantColumnasTablero() {
		return cantColumnasTablero;
	}

	public int getCantidadDeBarcosJugador1() {
		return this.tableroJugador1.getCantidadDeBarcos();
	}
	
	public int getCantidadDeBarcosJugador2() {
		return this.tableroJugador2.getCantidadDeBarcos();
	}
	
	public boolean ubicarBarcoJugador1(int fila,int columna,String orientacion,String tipoBarco){
		
		return this.ubicarBarcoEnTablero(fila, columna, orientacion, tipoBarco, this.tableroJugador1);
		
	}
	
	public boolean ubicarBarcoJugador2(int fila,int columna,String orientacion,String tipoBarco){
		
		return this.ubicarBarcoEnTablero(fila, columna, orientacion, tipoBarco, this.tableroJugador2);
		
	}
	
	public boolean consultarExistenciaBarcoEnPosicionTablero1(int fila,int columna){
		
		Posicion posicionConsulta=new Posicion(fila,columna);
		Barco consultaBarco = this.tableroJugador1.getBarcoEnPosicion(posicionConsulta);
		
		return (consultaBarco!=null);
	}
	
	public boolean consultarExistenciaBarcoEnPosicionTablero2(int fila,int columna){
		
		Posicion posicionConsulta=new Posicion(fila,columna);
		Barco consultaBarco = this.tableroJugador2.getBarcoEnPosicion(posicionConsulta);
		
		return (consultaBarco!=null);
	}
	
	public boolean dispararABarcosOponentesDesdeJugador1(int fila, int columna){
		
		boolean exito=false;
		Barco barcoOponente=null;
		Posicion posicionObjetivo=null;
		int filaValidada=Math.abs(fila);
		int columnaValidada=Math.abs(columna);
		
		if ((filaValidada<this.getCantFilasTablero())&&(columnaValidada<this.getCantColumnasTablero())){
			posicionObjetivo=new Posicion(filaValidada,columnaValidada);
			barcoOponente=this.tableroJugador2.getBarcoEnPosicion(posicionObjetivo);
		}
		
		if (barcoOponente!=null){
			exito=true;
			barcoOponente.tocado();
			if (barcoOponente.getVidasRestantes()==0){
				this.tableroJugador2.hundirBarcoTodoBombardeado(barcoOponente);
			}
		}
				
		return exito;		
	}
	
	public boolean dispararABarcosOponentesDesdeJugador2(int fila, int columna){
		
		boolean exito=false;
		Barco barcoOponente=null;
		Posicion posicionObjetivo=null;
		int filaValidada=Math.abs(fila);
		int columnaValidada=Math.abs(columna);
		
		if ((filaValidada<this.getCantFilasTablero())&&(columnaValidada<this.getCantColumnasTablero())){
			posicionObjetivo=new Posicion(filaValidada,columnaValidada);
			barcoOponente=this.tableroJugador1.getBarcoEnPosicion(posicionObjetivo);
		}
		
		if (barcoOponente!=null){
			exito=true;
			barcoOponente.tocado();
			if (barcoOponente.getVidasRestantes()==0){
				this.tableroJugador1.hundirBarcoTodoBombardeado(barcoOponente);
			}
		}
				
		return exito;		
	}
	
	// zona de metodos privados de la clase
	
	private boolean ubicarBarcoEnTablero(int fila,int columna,String orientacion,String tipoBarco,Tablero tableroJugador){
		
		boolean resultado=false;
		boolean errorFila=false;
		boolean errorColumna=false;
		int filaValidada=0;
		int columnaValidada=0;
		if (Math.abs(fila)<this.getCantFilasTablero()) {
			filaValidada=Math.abs(fila);
		} else {
			errorFila=true;
		}
		
		if (Math.abs(columna)<this.getCantColumnasTablero()) {
			columnaValidada=Math.abs(columna);
		} else {
			errorColumna=true;
		}
		
		String orientacionValidada=this.validarOrientacion(orientacion);
		String tipoBarcoValidada=this.validarTipoBarco(tipoBarco);
		
		if ((!orientacionValidada.equals("error"))&&(!tipoBarcoValidada.equals("error"))
				&&(!errorFila)&&(!errorColumna)) {
			
			Barco unBarco=this.construirBarco(filaValidada,columnaValidada,orientacionValidada,tipoBarcoValidada);
			resultado=tableroJugador.agregarBarco(unBarco);
		
		}
		
		return resultado;
	}
	
	private Barco construirBarco(int fila,int columna,String orientacion,String tipoBarco){
		
		Barco unBarco=null;
		Posicion posicionBarco = new Posicion(fila,columna);
		
		switch(tipoBarco){
			case "destructor": { 
						unBarco=new Destructor(posicionBarco,orientacion);
					}
				break;
			case "acorazado": { 
						unBarco=new Acorazado(posicionBarco,orientacion);
					}
				break;
			case "lancha": { 
				unBarco=new Lancha(posicionBarco,orientacion);
			}
				break;
		}
				
		return unBarco;
	}
	
	private String validarOrientacion(String orientacion){
		String orientacionValidada=orientacion.toLowerCase();
		
		switch(orientacionValidada){
			case "horizontal": break;
			case "vertical": break;
			default: orientacionValidada="error"; break;
		}
		
		return orientacionValidada;
	}
	
	private String validarTipoBarco(String tipoBarco){
		String tipoBarcoValidada=tipoBarco.toLowerCase();
		
		switch(tipoBarcoValidada){
			case "destructor": break;
			case "acorazado": break;
			case "lancha": break;
			default: tipoBarcoValidada="error"; break;
		}
		
		return tipoBarcoValidada;
	}

}
