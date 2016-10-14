package Obstaculos;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bosque extends Obstaculo {
	/**
	 * Constructor
	 */
	
	
	public Bosque(){
		coordenadas = new Point(0,0);
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Bosque.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
		etiqueta.setOpaque(false);
	}
	
	public boolean hayColision(int[] coord){
		return false;
	}
	
}
