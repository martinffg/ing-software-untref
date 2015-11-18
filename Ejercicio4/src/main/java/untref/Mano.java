package untref;

public class Mano {
	
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	
	public Mano(Carta carta1,Carta carta2,Carta carta3){
		
		this.carta1=carta1;
		this.carta2=carta2;
		this.carta3=carta3;
		
	}
	
	public int getValorEnvido(){
		
		int valorEnvido=0;
		
		if (this.todasCartasDistintoPalo()) {
			valorEnvido = this.getValorEnvidoCartasDistintoPalo();
		}
		
		if (this.todasCartasIgualPalo()){
			valorEnvido = this.getValorEnvidoTodasCartasIgualPalo();
		}
		
		if (this.soloDosCartasIgualPalo()){
			valorEnvido = this.getValorEnvidoSoloDosCartasIgualPalo();
		}
		
		return valorEnvido;
	}
	
	private boolean todasCartasIgualPalo() {
		return this.carta1.samePalo(this.carta2) && this.carta2.samePalo(this.carta3);
	}

	private boolean todasCartasDistintoPalo() {
		return !this.carta1.samePalo(this.carta2) 
				&& !this.carta2.samePalo(this.carta3)
				&& !this.carta1.samePalo(this.carta3);
	}
	
	private boolean soloDosCartasIgualPalo() {
	 return this.carta1.samePalo(this.carta2) && !this.carta1.samePalo(this.carta3) ||
			this.carta1.samePalo(this.carta3) && !this.carta1.samePalo(this.carta2) ||
			this.carta2.samePalo(this.carta3) && !this.carta2.samePalo(this.carta1);
	}
	
	private int getValorEnvidoTodasCartasIgualPalo() {
		
		int valorEnvido=0;
		int valor1 = this.getValorCartaEnvido(carta1);
		int valor2 = this.getValorCartaEnvido(carta2);
		int valor3 = this.getValorCartaEnvido(carta3);
		
		if (valor1 <= valor2 && valor1 <= valor3) {
			valorEnvido=valor2+valor3+20;
		} else if (valor2 <= valor1 && valor2 <= valor3) {
			valorEnvido=valor1+valor3+20;
		} else {
			valorEnvido=valor1+valor2+20;
		}
		
		return valorEnvido;
	}
	
	private int getValorEnvidoCartasDistintoPalo() {
		
		int valorEnvido=0;
		int valor1 = this.getValorCartaEnvido(carta1);
		int valor2 = this.getValorCartaEnvido(carta2);
		int valor3 = this.getValorCartaEnvido(carta3);
		
		if (valor1>=valor2 && valor1>=valor3) {
			valorEnvido=valor1;
		} else if (valor2>=valor3) {
			valorEnvido=valor2;
		} else {
			valorEnvido=valor3;
		}
	
		return valorEnvido;
	}
	
	private int getValorEnvidoSoloDosCartasIgualPalo() {

		int valorEnvido=0;
		int valor1 = this.getValorCartaEnvido(carta1);
		int valor2 = this.getValorCartaEnvido(carta2);
		int valor3 = this.getValorCartaEnvido(carta3);
		
		if (this.carta1.samePalo(this.carta2)) {
			valorEnvido=valor1+valor2+20;
		} 
		
		if (this.carta1.samePalo(this.carta3)) {
			valorEnvido=valor1+valor3+20;
		} 
			
		if (this.carta2.samePalo(this.carta3)) {
			valorEnvido=valor2+valor3+20;
		} 
			
		return valorEnvido;
	}

	private int getValorCartaEnvido(Carta carta){
		
		int valor=carta.getNumero();
		
		if (valor>=10) {
			valor=0;
		}
		
		return valor;
	}
	
	
	

}
