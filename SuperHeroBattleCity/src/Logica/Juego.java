package Logica;

import ObjetosDelJuego.*;
import Mapa.Mapa;

public class Juego {

	private Jugador jugador;
	private Enemigo enemigo;
	private Mapa mapa;
	private int puntaje;
	
	public Juego(Mapa m){
	
		jugador=new Jugador(0,0);
		mapa=m;
		puntaje=0;
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
		enemigo = new EnemigoBasico(x,y);
	}
	
	public void moverEnemigo(){
		
	}
	
	public void eliminarEnemigo(){
		enemigo=null;
	}
	
	public Enemigo getEnemigo(){
		
		return enemigo;
	}
	
	public void sumarPuntaje(int p){
		puntaje=p;
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public Jugador getJugador(){
		
		return jugador;
	}
	public void mover(int dir){	
		if (dir!=4)
			jugador.mover(dir);
	}
	
}
