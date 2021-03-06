package Logica;

import java.awt.Rectangle;
import java.util.Random;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaEnemigo extends Thread {
	
	protected Juego game;
	protected Enemigo enemigo;
	protected boolean ejecutar;
	protected boolean pausado;
	

	public InteligenciaEnemigo(Enemigo e,Juego juego){
		enemigo=e;
		game=juego;
		ejecutar=true;
		pausado=false;
	}
	
	public void pausar(){
		pausado=true;
	}
	
	public void terminate(){
		ejecutar=false;
	}
	
	public void reanudar(){
		pausado=false;
	}
	
	@Override
	public void run() {
		while(ejecutar){
			try{
				int m=new Random().nextInt(4);
				Rectangle rect=enemigo.simularMovimiento(m);
				game.repintarGui();
				int i=0;
				while(game.puedoMover(rect,enemigo)&&i<15&&ejecutar){
					enemigo.mover(m);
					rect=enemigo.simularMovimiento(m);
					i++;
					if(enemigo.puedeDisparar()){
						Disparo disp=enemigo.disparar();
						game.agregarDisparo(disp);
					}
					Thread.sleep(40);
					if(pausado)
						parar();
				}

			}
			catch(InterruptedException e){
				
			}
		}
	}

	private void parar() {
		long startTime = System.currentTimeMillis();
		long elapsedTime=0;
		long elapsedSeconds=0;
		while(elapsedSeconds<=10){
			elapsedTime = System.currentTimeMillis() - startTime;
			elapsedSeconds = elapsedTime / 1000;
		}
		reanudar();
	}
}
