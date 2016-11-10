package Logica;

import java.awt.Rectangle;

import Tanques.Disparo;
import Tanques.Enemigo;

public class InteligenciaDisparoEnemigo extends InteligenciaDisparo {
	
	protected Enemigo ene;
	
	public InteligenciaDisparoEnemigo(Disparo disp, Juego juego,Enemigo ene) {
		super(disp, juego);
		this.ene=ene;
		execute=true;
	}
	
	public void run() {
		game.agregarEtiqueta(d.getEtiqueta());
		Rectangle nuevaP=d.simularMovimiento();
		while(execute){
			try {
				while(game.puedoMover(nuevaP,d)&&execute){
					d.mover();
					nuevaP=d.simularMovimiento();
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
					
			}
			finally{
				execute=false;
				game.quitarEtiqueta(d.getEtiqueta());
				game.removerDisparo(d);
				ene.devolverDisparo();
				d=null;
			}
		}
	}
	
}
