package ObjetosDelJuego;
import javax.swing.*;

public abstract class gameObject {

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
	
	public ImageIcon getImagen(){
		return imagen;
	}
	
}
