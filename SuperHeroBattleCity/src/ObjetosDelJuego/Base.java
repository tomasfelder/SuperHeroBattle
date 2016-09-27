package ObjetosDelJuego;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Base extends Obstaculo {
	
	/**
	 * Constructores
	 */
	public Base(){
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Reina.png"));
	}
}
