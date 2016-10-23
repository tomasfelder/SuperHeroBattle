package Obstaculos;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;

import ObjetosDelJuego.Visitor;

public class Borde extends Obstaculo {
	
	public Borde(){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		etiqueta = new JLabel();
		etiqueta.setBackground(Color.LIGHT_GRAY);
		etiqueta.setBounds(rectangulo);
		etiqueta.setOpaque(true);
	}
	
	@Override
	public boolean aceptar(Visitor v, Rectangle nuevaPos) {
		return v.colisionarBorde(this, nuevaPos);
	}

}
