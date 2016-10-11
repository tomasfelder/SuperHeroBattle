package ObjetosDelJuego;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

public abstract class gameObject {

	protected static final int ANCHO=32;
	protected static final int ALTO=32;
	
	protected Point coordenadas;
	protected ImageIcon imagen;
	protected JLabel etiqueta;
	protected Rectangle medida;
	
	//http://opensource.apple.com//source/gcc3/gcc3-1041/libjava/java/awt/Rectangle.java
	public boolean hayColision(int[] coord){
	    int neww = (coordenadas.x + ANCHO < coord[0] + ANCHO ?
	        	coordenadas.x + ANCHO : coord[0] + ANCHO) - (coordenadas.x < coord[0] ? coord[0] : coordenadas.x);
	    int newh = (coordenadas.y + ALTO < coord[1] + ALTO ?
	        	coordenadas.y + ALTO : coord[1] + ALTO) - (coordenadas.y < coord[1] ? coord[1] : coordenadas.y);
	    return (neww > 0 && newh > 0);
	  }
	

	public int x(){
		return coordenadas.x;
	}
	
	public int y(){
		return coordenadas.y;
	}
	
	public void setX(int i){
		
		coordenadas.x=i;
		etiqueta.setBounds(i,coordenadas.y , ANCHO, ALTO);
	}
	public void setY(int i){
		etiqueta.setBounds(coordenadas.x,i , ANCHO, ALTO);
		coordenadas.y=i;
		
	}
	
	public ImageIcon getImagen(){
		return imagen;
	}
	
	public Icon getIcon(){
		
		return etiqueta.getIcon();
		
	}
	
	public JLabel getEtiqueta(){
		return etiqueta;
	}
	
}
