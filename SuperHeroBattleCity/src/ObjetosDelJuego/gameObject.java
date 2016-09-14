package ObjetosDelJuego;
import java.awt.Image;

import javax.swing.*;

public abstract class gameObject {

	protected static final int ANCHO=32;
	protected static final int ALTO=32;
	
	protected int x;
	protected int y;
	protected ImageIcon imagen;
	
	
	
	abstract boolean colision(gameObject g);
	
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
