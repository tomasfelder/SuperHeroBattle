package ObjetosDelJuego;

import java.awt.Point;

public class Disparo extends gameObject {

	public Disparo(int x,int y){
		coordenadas = new Point(x,y);
	}
	
	public boolean colision(gameObject o){
		
		return true;
		
	}
	
	public void avanzarArriba(){
	}
	public void avanzarAbajo(){
		
	}
	public void avanzarDerecha(){
		
	}
	public void avanzarIzquierda(){
		
	}
	
}
