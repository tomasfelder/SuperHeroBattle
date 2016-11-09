package Logica;

import java.awt.Rectangle;

import Tanques.Enemigo;
import Tanques.EnemigoBasico;

public class ThreadJuego extends Thread {
	
	protected Juego game;
	protected boolean execute;
	protected Rectangle[] apariciones;
	protected boolean pausado; 
	
	//Constructor
	public ThreadJuego(Juego j){
		game=j;
		execute=true;
		apariciones= new Rectangle[3];
		apariciones[0]=new Rectangle(32,32,28,28);
		apariciones[1]=new Rectangle(226,32,28,28);
		apariciones[2]=new Rectangle(416,32,28,28);
		pausado=false;
	}
	
	public void pausar(){
		pausado=true;
	}
	
	public void terminate(){
		execute=false;
	}
	
	public void reanudar(){
		pausado=false;
	}
	
	public void run(){
		while(execute){
			long startTime = System.currentTimeMillis();
			long elapsedTime=0;
			long elapsedSeconds=0;
			while(elapsedSeconds<=5&&execute){
				elapsedTime = System.currentTimeMillis() - startTime;
				elapsedSeconds = elapsedTime / 1000;
			}
			if(execute){
				if(pausado)
					parar();
				Enemigo aux = new EnemigoBasico(0,0,game);
				int indice = new java.util.Random().nextInt(3);
				while(!game.puedoMover(apariciones[indice], aux))
					indice = new java.util.Random().nextInt(3);
				game.crearEnemigo(apariciones[indice].x,apariciones[indice].y);
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
