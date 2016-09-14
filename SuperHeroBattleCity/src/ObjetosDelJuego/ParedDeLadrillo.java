package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class ParedDeLadrillo extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeLadrillo(){
		vida=4;
		
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeLadrillo.png"));
	}

}
