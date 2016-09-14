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
	
//	public boolean hayColision(Rectangulo rectangulo){
//		 //–utilizo la lógica inversa: voy comprobando los casos que conozco que sé que no son colisión, para ir descartando
//
//		//–primero compruebo el eje X
//		if ( (rectangulo.getCoordenadaFinal().getX() < this.getCoordenadaInicial().getX())
//		|| (rectangulo.getCoordenadaInicial().getX() > this.getCoordenadaFinal().getX()) )
//		    return false;
//
//		//–ahora compruebo el eje Y
//		else if ( (rectangulo.getCoordenadaFinal().getY() < this.getCoordenadaInicial().getY())
//		|| (rectangulo.getCoordenadaInicial().getY() > this.getCoordenadaFinal().getY()) )
//		    return false;
//		//–podríamos seguir comparando mas dimensiones si las tuvieramos, pero como sólo hay 2, estamos antes una colisión.
//		else
//		    return true;
	
//	public boolean puedoMover(int dir){
//		boolean pudo=true;
//		switch (dir){
//		case 0:
//			for(int i=0;i<gui.getMapa().getLargo()&&pudo;i++)
//				for(int j=0;j<gui.getMapa().getAncho()&&pudo;j++)
//					if(gui.getMapa().obtenerCelda(i, j)!=null){
//						pudo=jugador.y()-1-jugador.velocidad()<gui.getMapa().obtenerCelda(i, j).y()+32;
//					}
//			break;
//		case 1:
//			for(int i=0;i<gui.getMapa().getLargo()&&pudo;i++)
//				for(int j=0;j<gui.getMapa().getAncho()&&pudo;j++)
//					if(gui.getMapa().obtenerCelda(i, j)!=null)
//						pudo=jugador.y()+1+jugador.velocidad()>gui.getMapa().obtenerCelda(i, j).y();
//			break;
//		case 2:
//			for(int i=0;i<gui.getMapa().getLargo()&&pudo;i++)
//				for(int j=0;j<gui.getMapa().getAncho()&&pudo;j++)
//					if(gui.getMapa().obtenerCelda(i, j)!=null)
//						pudo=jugador.x()-1-jugador.velocidad()<gui.getMapa().obtenerCelda(i, j).x()+32;
//			break;
//		case 3:
//			this.moverDerecha();
//			break;
//		}
//		
//		return false;
//	}
//	
	public Jugador getJugador(){
		
		return jugador;
	}
	public void mover(int dir){	
		if (dir!=4)
			jugador.mover(dir);
	}
	
}
