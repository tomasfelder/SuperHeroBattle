package Logica;

import Tanques.Disparo;

public class IntelegenciaDisparo implements Runnable {
	
	private Disparo d;
	private Juego game;
	private boolean execute;
	
	public IntelegenciaDisparo(Disparo disp, Juego juego) {
		d=disp;
		game=juego;
	}
	
	public Disparo getDisparo(){
		return d;
	}
	
	public void terminate(){
		execute=true;
	}
	
	@Override
	public void run() {
			int [] mov;
			execute=true;
			while(execute){
				while(game.puedoMover(mov=d.simularMovimiento())){
					d.mover();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						
					}
				}
			if(!game.puedoMover(mov))
					execute=false;
					
			}	
	}
	
}
