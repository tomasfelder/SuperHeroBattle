package Logica;

import ObjetosDelJuego.*;
import Grafica.*;
import java.awt.event.KeyEvent;

public class Juego {

	private Jugador jugador;
	
	public Juego(GUI gui){
	
		jugador=new Jugador(10,10);
		
	}
	
	public Jugador getJugador(){
		
		return jugador;
	}
	public void mover(int dir){		
		int direccion = 0;
		
		switch (dir){
			case KeyEvent.VK_UP : 
				direccion = 0;
				break;
			case KeyEvent.VK_DOWN :
				direccion = 1;
				break;
			case KeyEvent.VK_LEFT : 
				direccion = 2;
				break;
			case KeyEvent.VK_RIGHT : 
				direccion = 3;
				break;
		}
		
		jugador.mover(direccion);
	}
}
