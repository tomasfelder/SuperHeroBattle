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
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return v.colisionarDEnemigo(this, posNueva);
	}
	
	public boolean colisionarJugador(Jugador j, Rectangle posNueva) {
		boolean colisiono = j.getRectangulo().intersects(posNueva);
		if(colisiono)
			j.afectar();
		return colisiono;
	}
	
	public boolean colisionarDJugador(DisparoJugador d,Rectangle posNueva){
		boolean colisiono = d.getRectangulo().intersects(posNueva);
		if(colisiono){
			d.getThreadDisparo().terminate();
			this.tDisparo.terminate();
		}
		return colisiono;
	}
	
	public boolean colisionarDEnemigo(DisparoEnemigo d,Rectangle posNueva ){
		
		return false;
		
	}
	
}
