package Obstaculos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ObjetosDelJuego.Visitor;

public class Bosque extends Obstaculo {
	/**
	 * Constructor
	 */
	
	
	public Bosque(){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Bosque_Red.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
		etiqueta.setOpaque(false);
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarBosque(this, nuevaPos);
	}
	
}
