package Logica;

import java.awt.Rectangle;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaDisparoEnemigo extends IntelegenciaDisparo {
	
	protected Enemigo ene;
	
	public InteligenciaDisparoEnemigo(Disparo disp, Juego juego,Enemigo ene) {
		super(disp, juego);
		this.ene=ene;
	}
	
	public void run() {
		Rectangle nuevaP=d.simularMovimiento();
		execute=true;
		while(execute){
			while(game.puedoMover(nuevaP,d)){
				d.mover();
				nuevaP=d.simularMovimiento();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
				}
			}
				execute=false;
				game.quitarEtiqueta(d.getEtiqueta());
				ene.devolverDisparo();
				d=null;
		}
}
	
}
