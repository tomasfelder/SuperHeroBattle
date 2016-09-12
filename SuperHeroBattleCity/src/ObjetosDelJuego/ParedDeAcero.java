package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class ParedDeAcero extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeAcero(){
		vida=4;
		imagen = new ImageIcon(this.getClass().getResource("imagenes/ParedDeAcero.png"));
	}
	
	@Override
	boolean colision(gameObject g) {
		// TODO Auto-generated method stub
		return false;
	}

}