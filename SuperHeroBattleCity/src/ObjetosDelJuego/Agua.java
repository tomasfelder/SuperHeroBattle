package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Agua extends Obstaculo {
	
	/**
	 * Constructor
	 */
	public Agua(){
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Agua.png"));
	}
}
