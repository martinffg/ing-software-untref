package skeleton;

public class Tijera implements Mano {
	
	@Override
	public int compararMano(Mano otraMano){
		int resultadoComparacion=0;
		
		// siempre comparo desde la perspectiva del jugador1
		if (otraMano instanceof Piedra) {
			
			resultadoComparacion=2;
			
		} else if (otraMano instanceof Papel) {
			
			resultadoComparacion=1;
		} else {
		
			resultadoComparacion=0;
		
		}		
		
		return resultadoComparacion;		
	}

}
