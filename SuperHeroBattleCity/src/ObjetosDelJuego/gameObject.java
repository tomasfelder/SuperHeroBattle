package ObjetosDelJuego;
import java.awt.Image;

import javax.swing.*;

public abstract class gameObject {

	protected static final int ANCHO=32;
	protected static final int ALTO=32;
	
	protected int x;
	protected int y;
	protected ImageIcon imagen;
	
	//http://opensource.apple.com//source/gcc3/gcc3-1041/libjava/java/awt/Rectangle.java
	public boolean hayColision(int[] coord)
	  {
	    int neww = (x + ANCHO < coord[0] + ANCHO ?
	        	x + ANCHO : coord[0] + ANCHO) - (x < coord[0] ? coord[0] : x);
	    int newh = (y + ALTO < coord[1] + ALTO ?
	        	y + ALTO : coord[1] + ALTO) - (y < coord[1] ? coord[1] : y);
	    return (neww > 0 && newh > 0);
	  }
	

	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public void setX(int i){
		
		x=i;
	}
	public void setY(int i){
		
		y=i;
		
	}
	
	public ImageIcon getImagen(){
		return imagen;
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT));
		
	}
	
}
