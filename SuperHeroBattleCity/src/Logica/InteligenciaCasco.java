package Logica;

import Tanques.Jugador;

public class InteligenciaCasco extends Thread{
	
	protected Jugador jugador;
	
	public InteligenciaCasco(Jugador j){
		jugador=j;
	}
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long elapsedTime=0;
		long elapsedSeconds=0;
		while(elapsedSeconds<=10){
			elapsedTime = System.currentTimeMillis() - startTime;
			elapsedSeconds = elapsedTime / 1000;
		}
		jugador.setVulnerable(true);
	}
}
