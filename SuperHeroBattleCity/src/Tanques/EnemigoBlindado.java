package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoBlindado extends Enemigo {

	public EnemigoBlindado(int x, int y) {
		super(x, y);
		velocidadMovimiento=1;
		golpesQueResiste=4;
		velocidadDisparo=2;
		puntosQueDa=400;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_4_Arriba.png"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_4_Arriba.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/Enemigo_4_Abajo.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_4_Izq.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_4_Der.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,ANCHO , ALTO);

	}

}
