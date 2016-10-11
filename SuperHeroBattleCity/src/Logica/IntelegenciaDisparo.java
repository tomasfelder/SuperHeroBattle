package Logica;

import Tanques.Disparo;

public class IntelegenciaDisparo implements Runnable {
	
	private Disparo d;
	private Juego game;
	
	public IntelegenciaDisparo(Disparo disp, Juego juego) {
		d=disp;
		game=juego;
	}

	@Override
	public void run() {
		
	}
	
}
