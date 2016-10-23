package Logica;

import java.awt.Rectangle;
import java.util.Random;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaEnemigo implements Runnable {
	
	private Juego game;
	private Enemigo enemigo;
	private boolean ejecutar;
	private Thread tDisparo;

	public InteligenciaEnemigo(Enemigo e,Juego juego){
		enemigo=e;
		game=juego;
	}
	
	@Override
	public void run() {
		ejecutar=true;
		while(ejecutar){
			try{
				int m=new Random().nextInt(4);
				Rectangle rect=enemigo.simularMovimiento(m);
				while(game.puedoMover(rect,enemigo)){
					enemigo.mover(m);
					rect=enemigo.simularMovimiento(m);
					if(enemigo.puedeDisparar()){
						Disparo disp=enemigo.disparar();
						game.agregarEtiqueta(disp.getEtiqueta());
						InteligenciaDisparoEnemigo id=new InteligenciaDisparoEnemigo(disp,game,enemigo);
						tDisparo= new Thread(id);
						tDisparo.start();
					}
				}

				Thread.sleep(500);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}
