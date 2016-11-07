package Tanques;

import java.awt.Rectangle;

import Logica.InteligenciaDisparo;
import Logica.Juego;

public class DisparoJugador extends Disparo {

	public DisparoJugador(int x, int y, int dir, int vel, Juego juego) {
		super(x, y, dir, vel);
		tDisparo = new InteligenciaDisparo(this, juego);
		tDisparo.start();
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
