package Obstaculos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ObjetosDelJuego.Visitor;

public class Agua extends Obstaculo {
	
	/**
	 * Constructor
	 */
	public Agua(){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Agua.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarAgua(this, nuevaPos);
	}
	
}
