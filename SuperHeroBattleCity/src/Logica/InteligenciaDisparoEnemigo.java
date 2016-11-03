package Logica;

import java.awt.Rectangle;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaDisparoEnemigo extends IntelegenciaDisparo {
	
	protected Enemigo ene;
	
	public InteligenciaDisparoEnemigo(Disparo disp, Juego juego,Enemigo ene) {
		super(disp, juego);
		this.ene=ene;
		execute=true;
	}
	
	public void run() {
		Rectangle nuevaP=d.simularMovimiento();
		while(execute){
			while(game.puedoMover(nuevaP,d)&&execute){
				d.mover();
				nuevaP=d.simularMovimiento();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
				}
			}
			execute=false;
			game.removerDisparo(d);
			game.quitarEtiqueta(d.getEtiqueta());
			ene.devolverDisparo();
			d=null;
		}
}
	
}
