package Logica;

import ObjetosDelJuego.*;
import Grafica.*;

public class Juego {

	private Jugador jugador;
	private Enemigo enemigo;
	private GUI gui;
	
	public Juego(GUI gui){
	
		jugador=new Jugador(0,0);
		enemigo=new Enemigo(64,0);
		this.gui=gui;
		
	}
	
	public boolean puedoMover(int[] coord){
		boolean puedo=true;
		for(int i=0;i<gui.getMapa().getLargo()&&puedo;i++)
			for(int j=0;j<gui.getMapa().getAncho()&&puedo;j++)
				if(gui.getMapa().obtenerCelda(i, j)!=null)
					puedo=!gui.getMapa().obtenerCelda(i, j).hayColision(coord);
		return puedo;
	}
	
	public Enemigo getEnemigo(){
		
		return enemigo;
	}
	
	public Jugador getJugador(){
		
		return jugador;
	}
	public void mover(int dir){	
		if (dir!=4)
			jugador.mover(dir);
	}
	
}
