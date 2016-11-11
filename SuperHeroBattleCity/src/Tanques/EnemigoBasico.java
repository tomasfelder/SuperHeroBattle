package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteligenciaEnemigo;
import Logica.Juego;

public class EnemigoBasico extends Enemigo {

	public EnemigoBasico(int x, int y,Juego j) {
			super(x,y,j);
			velocidadMovimiento=2;
			golpesQueResiste=1;
			velocidadDisparo=1;
			puntosQueDa=100;
			
			imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/pibeDerechaGif.gif"));
			
			iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/pibeDerechaGif.gif"));
			iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/pibeDerechaGif.gif"));
			iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/pibeIzquierdaGif.gif"));
			iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/pibeDerechaGif.gif"));
			etiqueta = new JLabel();
			etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT)));
			etiqueta.setBounds(x, y, 48, 48);
			tEnemigo = new InteligenciaEnemigo(this,juego);
			tEnemigo.start();
	}

}
