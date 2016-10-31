package PowerUps;

import java.awt.Rectangle;

import ObjetosDelJuego.gameObject;

public abstract class PowerUp extends gameObject {

	public PowerUp(int x,int y){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
	}
	
}
