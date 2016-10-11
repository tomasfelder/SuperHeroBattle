package ObjetosDelJuego;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoDePoder extends Enemigo {

	public EnemigoDePoder(int x, int y) {
		super(x, y);
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=3;
		puntosQueDa=300;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_3_Arriba.png"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_3_Arriba.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesEnemigo/Enemigo_3_Abajo.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_3_Izq.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesEnemigo/Enemigo_3_Der.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,ANCHO , ALTO);
	}

}
