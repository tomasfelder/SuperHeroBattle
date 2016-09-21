package ObjetosDelJuego;

import javax.swing.ImageIcon;

public class Enemigo extends Tanque{
	
	public Enemigo(int x,int y){
		
		super(x,y);
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenes/Enemigo_1_Arriba.png"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenes/Enemigo_1_Arriba.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenes/Enemigo_1_Abajo.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenes/Enemigo_1_Izq.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenes/Enemigo_1_Der.png"));
	}

}
