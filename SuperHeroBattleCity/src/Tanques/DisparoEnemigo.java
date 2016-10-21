package Tanques;

import java.awt.Rectangle;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int x, int y, int dir, int vel) {
		super(x, y, dir, vel);
	}
	
	public boolean colisionarEnemigo(Enemigo e, Rectangle posNueva) {
		return false;
	}

	public boolean colisionarJugador(Jugador j, Rectangle posNueva) {
		boolean colisiono = j.getRectangulo().intersects(posNueva);
		if(colisiono)
			j.afectar();
		return colisiono;
	}
	
}
