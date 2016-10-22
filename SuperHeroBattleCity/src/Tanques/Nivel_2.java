package Tanques;

import javax.swing.ImageIcon;

public class Nivel_2 extends Nivel {

	public Nivel_2() {
		super();
		velocidadMov=3;
		resistencia=1;
		velDisparo=2;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_2_Arriba.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_2_Abajo.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_2_Izq.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_2_Der.png"));
		icono=iconosNivel[0];
		cantDisparos=1;
	}

}
