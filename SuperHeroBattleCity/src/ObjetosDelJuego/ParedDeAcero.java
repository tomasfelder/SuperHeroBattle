package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ParedDeAcero extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeAcero(){
		coordenadas = new Point(0,0);
		vida=4;
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeAcero.png"));
	}

}