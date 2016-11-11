package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteligenciaEnemigo;
import Logica.Juego;

public class EnemigoRapido extends Enemigo {

	public EnemigoRapido(int x, int y,Juego j) {
		super(x, y,j);
		velocidadMovimiento=3;
		golpesQueResiste=1;
		velocidadDisparo=2;
		puntosQueDa=200;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/socraDerechaGif.gif"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/socraDerechaGif.gif"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/socraDerechaGif.gif"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/socraIzquierdaGif.gif"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/socraDerechaGif.gif"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,48 , 48);
		tEnemigo = new InteligenciaEnemigo(this,juego);
		tEnemigo.start();
	}

}
