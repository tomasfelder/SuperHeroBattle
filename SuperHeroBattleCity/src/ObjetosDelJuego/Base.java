package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class Base extends Obstaculo {
	
	/**
	 * Constructor
	 */
	public Base(){
		
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Reina.png"));
	}
}
