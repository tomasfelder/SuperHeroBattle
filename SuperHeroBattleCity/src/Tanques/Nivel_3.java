package Tanques;

import javax.swing.ImageIcon;

public class Nivel_3 extends Nivel {

	public Nivel_3() {
		super();
		velocidadMov=2;
		resistencia=2;
		velDisparo=2;
		icono=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_3_Der.png"));
		
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_3_Arriba.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_3_Abajo.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_3_Izq.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_3_Der.png"));
	}

}
