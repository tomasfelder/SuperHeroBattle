package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteligenciaEnemigo;
import Logica.Juego;

public class EnemigoBlindado extends Enemigo {

	public EnemigoBlindado(int x, int y,Juego j) {
		super(x, y,j);
		velocidadMovimiento=1;
		golpesQueResiste=4;
		velocidadDisparo=2;
		puntosQueDa=400;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/franzDerechaGif.gif"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/franzDerechaGif.gif"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/franzDerechaGif.gif"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/franzIzquierdaGif.gif"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/franzDerechaGif.gif"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,48 , 48);
		tEnemigo = new InteligenciaEnemigo(this,juego);
		tEnemigo.start();
	}

}
