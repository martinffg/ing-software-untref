package untref;

public class Tablero {
	
	private int columnas;
	private int filas;
	private Barco[][] tablero;
	private int cantidadDeBarcos;
	private int cantidadPosicionesCubiertas;
	
	public Tablero(int filas,int columnas){
			
		this.columnas=this.validarLongitudMinima(columnas);
		this.filas=this.validarLongitudMinima(filas);
		this.tablero= new Barco[this.filas][this.columnas];
		this.cantidadPosicionesCubiertas=0;
		this.inicializarTablero();
		
	}
	
	
	public int getColumnas() {
		return columnas;
	}
	public int getFilas() {
		return filas;
	}
	public Barco[][] getTablero() {
		return tablero;
	}
	public int getCantidadDeBarcos() {
		return cantidadDeBarcos;
	}
	
	public int getCantidadPosicionesCubiertas() {
		return cantidadPosicionesCubiertas;
	}
	
	public boolean estaLleno(){
		
		return (this.cantidadPosicionesCubiertas==(this.columnas*this.filas));
		
	}
	
	public boolean agregarBarco(Barco unBarco){
		
		boolean resultado=false;
		
		if (this.esPosibleAgregarBarco(unBarco)){
			
			this.agregarBarcoConEspacioDisponible(unBarco);
			this.cantidadDeBarcos++;
			this.cantidadPosicionesCubiertas+=unBarco.getLongitud();
			resultado=true;
		}
		
		return resultado;
	}
	
	public boolean esPosibleAgregarBarco(Barco unBarco){
		
		boolean resultado=false;
		
		switch (unBarco.getOrientacion()){
			case "horizontal": {
				resultado=this.verificarDisponibilidadHorizontal(unBarco);
				}
				break;
				
			case "vertical":{
				resultado=this.verificarDisponibilidadVertical(unBarco);
				}
				break;
		}
		
		return resultado;		
	}
	
	public Barco getBarcoEnPosicion(Posicion posicionConsulta){
		int fila = posicionConsulta.getFila();
		int columna = posicionConsulta.getColumna();
		
		return this.tablero[fila][columna];
	}
	
	public void hundirBarcoTodoBombardeado(Barco unBarco){
		int longitud=unBarco.getLongitud();
		int fila=unBarco.getPosicion().getFila();
		int filaFinal=fila+longitud;
		int columna=unBarco.getPosicion().getColumna();
		int columnaFinal=columna+longitud;
		
		switch (unBarco.getOrientacion()){
			case "horizontal": {
				   for(int i=columna;i<columnaFinal;i++) {
					   this.tablero[fila][i]=null;
				   }
				}
				break;
				
			case "vertical":{
					for(int j=fila;j<filaFinal;j++) {
						   this.tablero[j][columna]=null;
					}
				}
				break;
		}
		this.cantidadDeBarcos--;
	} 
	

// area de metodos privados de la clase Tablero
	private void inicializarTablero(){
		
		for (int i=0;i<this.filas;i++) {
			for (int j=0;j<this.columnas;j++) {
				this.tablero[i][j]=null;
			}
		}	
		
	}
	
	private int validarLongitudMinima(int longitud){
		
		int longitudValidada=10;
		
		if (longitud > 10) {
			longitudValidada=longitud;
		}
		
		return longitudValidada;
	}
	
	private void agregarBarcoConEspacioDisponible(Barco unBarco){
		
		switch (unBarco.getOrientacion()){
			case "horizontal": {
				   this.agregarBarcoValidadoHorizontal(unBarco);
				}
				break;
				
			case "vertical":{
					this.agregarBarcoValidadoVertical(unBarco);
				}
				break;
		}
	}
	
	private boolean verificarDisponibilidadHorizontal(Barco unBarco){
		boolean resultado=true;
		int fila=unBarco.getPosicion().getFila();
		int columnaInicio=unBarco.getPosicion().getColumna();
		int columnaFinal=columnaInicio+unBarco.getLongitud();
		
		if (columnaFinal<=this.columnas) {
			resultado=this.iterarVerificacionHorizontal(resultado,fila,columnaInicio,columnaFinal);
		} else {
			resultado=false;
		}
		
		return resultado;		
	}
	
	private boolean verificarDisponibilidadVertical(Barco unBarco){
		boolean resultado=true;
		int columna=unBarco.getPosicion().getColumna();
		int filaInicio=unBarco.getPosicion().getFila();
		int filaFinal=filaInicio+unBarco.getLongitud();
		
		if (filaFinal<=this.filas) {
			resultado=this.iterarVerificacionVertical(resultado,columna,filaInicio,filaFinal);
		} else {
			resultado=false;
		}		
		
		return resultado;	
	}
	
	private void agregarBarcoValidadoHorizontal(Barco unBarco){
		
		int columna=unBarco.getPosicion().getColumna();
		int columnaTope=columna+unBarco.getLongitud();
		int fila=unBarco.getPosicion().getFila();
		
		for (int i=columna;i<columnaTope;i++){
			this.tablero[fila][i]=unBarco;
		}
		
	}

	private void agregarBarcoValidadoVertical(Barco unBarco){
		
		int fila=unBarco.getPosicion().getFila();
		int filaTope=fila+unBarco.getLongitud();
		int columna=unBarco.getPosicion().getColumna();
		
		for (int i=fila;i<filaTope;i++){
			this.tablero[i][columna]=unBarco;
		}
	}
	
	private boolean iterarVerificacionHorizontal(boolean resultado,int fila,int columnaInicio,int columnaFinal){
		boolean resultadoIteracion=resultado;
		
		while ((resultadoIteracion)&&(columnaInicio<columnaFinal)) {
			if (this.tablero[fila][columnaInicio]!=null){
				resultadoIteracion=false;
			}
			columnaInicio++;
		}
		
		return resultadoIteracion;
	}
	
	private boolean iterarVerificacionVertical(boolean resultado,int columna,int filaInicio,int filaFinal){
		boolean resultadoIteracion=resultado;
		
		while ((resultado)&&(filaInicio<filaFinal)) {
			if (this.tablero[filaInicio][columna]!=null){
				resultado=false;
			}
			filaInicio++;
		}
		
		return resultadoIteracion;
	}

}
