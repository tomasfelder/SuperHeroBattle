package ObjetosDelJuego;

import javax.swing.ImageIcon;

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
	}

}
