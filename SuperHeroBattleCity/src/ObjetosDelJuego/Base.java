package ObjetosDelJuego;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Base extends Obstaculo {
	
	/**
	 * Constructores
	 */
	public Base(){
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Reina.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}
}
