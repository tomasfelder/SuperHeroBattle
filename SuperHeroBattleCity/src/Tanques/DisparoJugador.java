package Tanques;

import java.awt.Rectangle;

public class DisparoJugador extends Disparo {

	public DisparoJugador(int x, int y, int dir, int vel) {
		super(x, y, dir, vel);
		
	}
	
	public boolean colisionarEnemigo(Enemigo e, Rectangle posNueva) {
		boolean colisiono = e.getRectangulo().intersects(posNueva);
		if(colisiono)
			e.afectar();
		return colisiono;
	}

	public boolean colisionarJugador(Jugador j, Rectangle posNueva) {
		return false;
	}
	
}
