package Logica;

import java.awt.Rectangle;
import java.util.Random;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaEnemigo extends Thread {
	
	private Juego game;
	private Enemigo enemigo;
	private boolean ejecutar;
	private InteligenciaDisparoEnemigo tDisparo;
	

	public InteligenciaEnemigo(Enemigo e,Juego juego){
		enemigo=e;
		game=juego;
		ejecutar=true;
		
	}
	
	public void terminate(){
		ejecutar=false;
	}
	
	@Override
	public void run() {
		while(ejecutar){
			try{
				int m=new Random().nextInt(4);
				Rectangle rect=enemigo.simularMovimiento(m);
				while(game.puedoMover(rect,enemigo)&&ejecutar){
					enemigo.mover(m);
					rect=enemigo.simularMovimiento(m);
					if(enemigo.puedeDisparar()){
						Disparo disp=enemigo.disparar();
						game.agregarDisparo(disp);
						game.agregarEtiqueta(disp.getEtiqueta());
//						tDisparo = new InteligenciaDisparoEnemigo(disp,game,enemigo);
//						tDisparo.start();
					}
					Thread.sleep(50);
				}

			}
			catch(InterruptedException e){
				
			}
		}
	}
}
