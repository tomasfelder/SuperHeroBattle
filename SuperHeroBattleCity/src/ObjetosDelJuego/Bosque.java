package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Bosque extends Obstaculo {
	/**
	 * Constructor
	 */
	
	
	public Bosque(){
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Bosque.png"));
	}
}
