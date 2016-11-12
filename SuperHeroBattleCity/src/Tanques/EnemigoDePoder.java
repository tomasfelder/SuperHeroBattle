package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteligenciaEnemigo;
import Logica.Juego;

public class EnemigoDePoder extends Enemigo {

	public EnemigoDePoder(int x, int y,Juego j) {
		super(x, y,j);
		velocidadMovimiento=6;
		golpesQueResiste=1;
		velocidadDisparo=6;
		puntosQueDa=300;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/johanDerechaGif.gif"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/johanDerechaGif.gif"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/johanDerechaGif.gif"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/johanIzquierdaGif.gif"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/johanDerechaGif.gif"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,48 , 48);
		tEnemigo = new InteligenciaEnemigo(this,juego);
		tEnemigo.start();
	}

}
