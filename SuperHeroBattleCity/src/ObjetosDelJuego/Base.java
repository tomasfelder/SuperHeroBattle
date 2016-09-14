package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class Base extends gameObject {
	
	/**
	 * Constructor
	 */
	public Base(){
		
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Reina.png"));
	}
}
