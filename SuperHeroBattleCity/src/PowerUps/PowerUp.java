package PowerUps;

import java.awt.Rectangle;

import ObjetosDelJuego.gameObject;

public abstract class PowerUp extends gameObject {
	
	protected int puntosQueDa;
	
	public PowerUp(int x,int y){
		rectangulo = new Rectangle(x, y, ANCHO, ALTO);
		puntosQueDa=500;
	}
	
	public int getPuntosQueDa(){
		return puntosQueDa;
	}
	
}
