package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class Bosque extends Obstaculo {
	/**
	 * Constructor
	 */
	public Bosque(){
		
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Bosque.png"));
	}
}
