package Obstaculos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import ObjetosDelJuego.Visitor;

public class Base extends Obstaculo {
	
	protected int vida;
	protected Juego game;
	
	/**
	 * Constructores
	 */
	public Base(){
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Reina.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
		etiqueta.setOpaque(false);
		vida=1;
		game=null;
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarBase(this, nuevaPos);
	}

	public void afectar() {
		vida--;
		if(vida==0)
			game.perder();
	}

	public void setJuego(Juego juego) {
		game=juego;
	}
}
