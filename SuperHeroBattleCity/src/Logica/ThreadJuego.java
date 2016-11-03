package Logica;

public class ThreadJuego extends Thread {
	
	protected Juego game;
	protected boolean execute;
	
	//Constructor
	public ThreadJuego(Juego j){
		game=j;
		execute=true;
	}
	
	public void terminate(){
		execute=false;
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
			if(execute)
				game.crearEnemigo(64, 32);
		}
	}
	
}
