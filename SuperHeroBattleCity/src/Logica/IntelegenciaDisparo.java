package Logica;

import java.awt.Rectangle;

import Tanques.Disparo;

public class IntelegenciaDisparo extends Thread {
	
	protected Disparo d;
	protected Juego game;
	protected boolean execute;
	
	//Constructor
	public IntelegenciaDisparo(Disparo disp, Juego juego) {
		d=disp;
		game=juego;
	}
	
	public Disparo getDisparo(){
		return d;
	}
	
	public void terminate(){
		execute=false;
	}
	
	@Override
	public void run() {
			Rectangle nuevaP=d.simularMovimiento();
			execute=true;
			while(execute){
				while(game.puedoMover(nuevaP,d)){
					d.mover();
					nuevaP=d.simularMovimiento();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						
					}
				}
					execute=false;
					game.quitarEtiqueta(d.getEtiqueta());
					game.getJugador().devolverDisparo();
					game.removerDisparo(d);
					d=null;
			}
	}
	
}
