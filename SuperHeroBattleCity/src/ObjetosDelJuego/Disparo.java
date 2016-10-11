package ObjetosDelJuego;

import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Disparo extends gameObject {
	
	protected ImageIcon[] iconos;
	
	public Disparo(int x,int y,int dir){
		coordenadas = new Point(x,y);
		switch(dir){
		case(0):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Arriba.png"));
			break;
		case(1):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Abajo.png"));
			break;
		case(2):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Der.png"));
			break;
		case(3):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Izq.png"));
			break;
		}
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(coordenadas.x, coordenadas.y,ANCHO , ALTO);
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
	
	public Icon getIcon(){
		
		return new ImageIcon(imagen.getImage().getScaledInstance(7, 8, Image.SCALE_DEFAULT));
		
	}
	
}
