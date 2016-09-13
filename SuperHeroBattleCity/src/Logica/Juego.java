package Logica;

import ObjetosDelJuego.*;
import Grafica.*;
import java.awt.event.KeyEvent;

public class Juego {

	private Jugador jugador;
	private GUI gui;
	
	public Juego(GUI gui){
	
		jugador=new Jugador(0,0);
		this.gui=gui;
		
	}
	
//	public boolean puedoMover(int dir){
//		switch (dir){
//		case 0:
//			if(jugador.x()+1+jugador.velocidad()>gui.getMapa().)
//			break;
//		case 1:
//			this.moverAbajo();
//			break;
//		case 2:
//			this.moverIzquierda();
//			break;
//		case 3:
//			this.moverDerecha();
//			break;
//		}
//		
//		return false;
//	}
	
	public Jugador getJugador(){
		
		return jugador;
	}
	public void mover(int dir){		
		int direccion = 4;
		
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
		if (direccion!=4)
			jugador.mover(direccion);
	}
}
