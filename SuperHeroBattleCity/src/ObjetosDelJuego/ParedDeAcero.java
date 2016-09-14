package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class ParedDeAcero extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeAcero(){
		
		vida=4;
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeAcero.png"));
	}

}