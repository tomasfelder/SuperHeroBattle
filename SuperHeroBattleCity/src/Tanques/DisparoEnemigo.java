package Tanques;

import java.awt.Rectangle;

import Logica.InteligenciaDisparoEnemigo;
import Logica.Juego;
import ObjetosDelJuego.Visitor;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int x, int y, int dir, int vel, Juego juego, Enemigo enemigo) {
		super(x, y, dir, vel);
		tDisparo = new InteligenciaDisparoEnemigo(this, juego, enemigo);
		tDisparo.start();
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
	

	
	public boolean colisionarDJugador(DisparoJugador d,Rectangle posNueva){
		
		return false;
	}
	
	public boolean colisionarDEnemigo(DisparoEnemigo d,Rectangle posNueva ){
		
		return false;
		
	}
	
}
