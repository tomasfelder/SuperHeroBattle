package Obstaculos;

import java.awt.Rectangle;

import ObjetosDelJuego.gameObject;

public abstract class powerUp extends gameObject {

	public powerUp(int x,int y){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
	}
	
	public abstract void afectar();
}
