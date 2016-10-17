package Tanques;

import javax.swing.ImageIcon;

public class Nivel_1 extends Nivel {
	
	public Nivel_1(){
		super();
		velocidadMov=2;
		resistencia=1;
		velDisparo=1;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Arriba.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_1_Abajo.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Izq.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Der.png"));
		icono=iconosNivel[0];
	}
	
}
