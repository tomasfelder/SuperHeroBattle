package Logica;

import java.awt.Rectangle;
import java.util.Random;

import Tanques.Enemigo;

public class InteligenciaEnemigo implements Runnable {
	
	private Juego game;
	private Enemigo enemigo;
	private boolean ejecutar;

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
				int i=0;
				while(game.puedoMover(rect,enemigo)&&i<20){
					enemigo.mover(m);
					rect=enemigo.simularMovimiento(m);
					i++;
				}

				Thread.sleep(250);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}
