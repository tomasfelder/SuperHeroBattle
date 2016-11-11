package Tanques;

import java.applet.Applet;
import java.awt.Rectangle;

import Logica.InteligenciaDisparo;
import Logica.Juego;
import ObjetosDelJuego.Visitor;

public class DisparoJugador extends Disparo {
	
	public DisparoJugador(int x, int y, int dir, int vel, Juego juego) {
		super(x, y, dir, vel);
		tDisparo = new InteligenciaDisparo(this, juego);
		tDisparo.start();
	}
	
	public boolean colisionarEnemigo(Enemigo e, Rectangle posNueva) {
		boolean colisiono = e.getRectangulo().intersects(posNueva);
		if(colisiono){
			e.afectar();
			Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Mata_Enemigo.wav")).play();
		}
		return colisiono;
	}
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return v.colisionarDJugador(this, posNueva);
	}
	
	public boolean colisionarJugador(Jugador j, Rectangle posNueva) {
		return false;
	}
	
	public boolean colisionarDJugador(DisparoJugador d,Rectangle posNueva){
		
		return false;
	}
	
	public boolean colisionarDEnemigo(DisparoEnemigo d,Rectangle posNueva ){
		boolean colisiono = d.getRectangulo().intersects(posNueva);
		if(colisiono){
			d.getThreadDisparo().terminate();
			this.tDisparo.terminate();
		}
		return colisiono;
	}
}
