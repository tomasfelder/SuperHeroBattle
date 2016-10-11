package Logica;

import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;

import java.util.Random;

import Grafica.GUI;
import Mapa.Mapa;

public class Juego extends Thread {

	private Jugador jugador;
	private Enemigo enemigo;
	private Mapa mapa;
	private GUI gui;
	private int puntaje;
	protected volatile boolean ejecutar;
	
	public Juego(Mapa m,GUI g){
	
		jugador=new Jugador(0,0);
		mapa=m;
		gui=g;
		puntaje=0;
	}
	
	public boolean puedoMover(int[] coord){
		if(!gui.getMapaBounds().intersects(coord[0], coord[1], coord[0]+32, coord[1]+32))
			return false;
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
	
	public void terminate(){
		ejecutar=false;
	}
	
	public void run(){
		ejecutar=true;
		while(ejecutar){
			try{
				int m=new Random().nextInt(4);
				int coordenadas[]=enemigo.simularMovimiento(m);
				for(int i=0;i<10;i++)
					if(puedoMover(coordenadas))
						enemigo.mover(m);
				Thread.sleep(250);
			}
			catch(InterruptedException e){
				
			}
		}
	}

	public void disparar(){
		Disparo disp= jugador.disparar();
		IntelegenciaDisparo i=new IntelegenciaDisparo(disp,this);
	}
	
	public void eliminarEnemigo(){
		puntaje+=enemigo.getPuntos();
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
