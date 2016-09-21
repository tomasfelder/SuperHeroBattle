package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ParedDeLadrillo extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeLadrillo(){
		vida=4;
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeLadrillo.png"));
	}

}
