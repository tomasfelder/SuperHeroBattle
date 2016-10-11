package Obstaculos;

import ObjetosDelJuego.gameObject;

public abstract class powerUp extends gameObject {

	public powerUp(int x,int y){
		
		coordenadas.x=x;
		coordenadas.y=y;
		
	}
	
	public abstract void afectar();
}
