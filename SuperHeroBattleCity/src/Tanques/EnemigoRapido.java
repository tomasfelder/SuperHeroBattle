package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoRapido extends Enemigo {

	public EnemigoRapido(int x, int y) {
		super(x, y);
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
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,ANCHO , ALTO);
	}

}
