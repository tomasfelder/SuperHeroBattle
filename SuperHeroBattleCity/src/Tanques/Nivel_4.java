package Tanques;

import javax.swing.ImageIcon;

public class Nivel_4 extends Nivel {

	public Nivel_4() {
		super();
		velocidadMov=2;
		resistencia=4;
		velDisparo=3;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_4_Arriba.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_4_Abajo.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_4_Izq.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_4_Der.png"));
		icono=iconosNivel[0];
		cantDisparos=3;
	}

}
