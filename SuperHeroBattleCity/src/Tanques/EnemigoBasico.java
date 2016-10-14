package Tanques;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoBasico extends Enemigo {

	public EnemigoBasico(int x, int y) {
			super(x,y);
			velocidadMovimiento=1;
			golpesQueResiste=1;
			velocidadDisparo=1;
			puntosQueDa=100;
			
			imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_1_Arriba.png"));
			
			iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_1_Arriba.png"));
			iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/Enemigo_1_Abajo.png"));
			iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_1_Izq.png"));
			iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_1_Der.png"));
			etiqueta = new JLabel();
			etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT)));
			etiqueta.setBounds(x, y, 28, 28);
	}

}
