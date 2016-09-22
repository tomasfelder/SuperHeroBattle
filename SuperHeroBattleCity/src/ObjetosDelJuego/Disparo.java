package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Disparo extends gameObject {
	
	protected ImageIcon[] iconos;
	
	public Disparo(int x,int y){
		coordenadas = new Point(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Der.png"));
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
