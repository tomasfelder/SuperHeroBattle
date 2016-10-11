package Obstaculos;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ParedDeAcero extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeAcero(){
		coordenadas = new Point(0,0);
		vida=4;
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeAcero.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}

}