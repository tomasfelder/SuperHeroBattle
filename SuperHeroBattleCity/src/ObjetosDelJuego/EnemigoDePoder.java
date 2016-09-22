package ObjetosDelJuego;

import javax.swing.ImageIcon;

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

	}

}
