package ObjetosDelJuego;
import java.awt.Rectangle;

import javax.swing.*;

public abstract class gameObject {

	protected static final int ANCHO=52;
	protected static final int ALTO=52 ;
	
	protected ImageIcon imagen;
	protected JLabel etiqueta;
	protected Rectangle rectangulo;
	
	
	public abstract boolean aceptar(Visitor v,Rectangle nuevaPos);
	
	public Rectangle getRectangulo(){
		return rectangulo;
	}
	
	public int x(){
		return rectangulo.x;
	}
	
	public int y(){
		return rectangulo.y;
	}
	
	public void setX(int i){
		rectangulo.x=i;
		etiqueta.setBounds(rectangulo);
		
	}
	public void setY(int i){
		rectangulo.y=i;
		etiqueta.setBounds(rectangulo);
		
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
