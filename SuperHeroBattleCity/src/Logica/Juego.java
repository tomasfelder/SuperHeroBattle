package Logica;

import ObjetosDelJuego.*;
import Mapa.Mapa;

public class Juego {

	private Jugador jugador;
	private Enemigo enemigo;
	private Mapa mapa;
	
	public Juego(Mapa m){
	
		jugador=new Jugador(0,0);
		mapa=m;
		
	}
	
	public boolean puedoMover(int[] coord){
		boolean puedo=true;
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).hayColision(coord);
		return puedo;
	}
	
	public void crearEnemigo(int x,int y){
		enemigo = new Enemigo(x,y);
	}
	
	public void eliminarEnemigo(){
		enemigo=null;
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
