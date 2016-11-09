package Tanques;

import javax.swing.ImageIcon;

public class Nivel_1 extends Nivel {
	
	
	public Nivel_1(){
		super();
		siguiente=new Nivel_2();
		velocidadMov=2;
		resistencia=1;
		velDisparo=1;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Maradona.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Maradona.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Maradona.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Maradona.png"));
		icono=iconosNivel[0];
		cantDisparos=1;
	}
	
}
