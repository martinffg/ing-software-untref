package skeleton;

public class Piedra implements Mano {
	
	@Override
	public int compararMano(Mano otraMano){
		int resultadoComparacion=0;
		
		// siempre comparo desde la perspectiva del jugador1
		if (otraMano instanceof Papel) {
			
			resultadoComparacion=2;
			
		} else if (otraMano instanceof Tijera) {
			
			resultadoComparacion=1;
		} else {
		
			resultadoComparacion=0;
		
		}		
		
		return resultadoComparacion;		
	}

}
