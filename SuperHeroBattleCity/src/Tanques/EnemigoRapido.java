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
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_2_Arriba.png"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_2_Arriba.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/Enemigo_2_Abajo.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_2_Izq.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_2_Der.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,28 , 28);
		tEnemigo = new InteligenciaEnemigo(this,juego);
		tEnemigo.start();
	}

}
