package Obstaculos;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agua extends Obstaculo {
	
	/**
	 * Constructor
	 */
	public Agua(){
		coordenadas = new Point(0,0);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Agua.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}
}
