package Logica;

public class ThreadJuego extends Thread {
	
	protected Juego game;
	protected boolean execute;
	
	public ThreadJuego(Juego j){
		game=j;
		execute=true;
	}
	
	public void run(){
		while(execute){
			long startTime = System.currentTimeMillis();
			long elapsedTime=0;
			long elapsedSeconds=0;
			while(elapsedSeconds<=7){
				elapsedTime = System.currentTimeMillis() - startTime;
				elapsedSeconds = elapsedTime / 1000;
			}
			game.crearEnemigo(64, 32);
		}
	}
	
}
