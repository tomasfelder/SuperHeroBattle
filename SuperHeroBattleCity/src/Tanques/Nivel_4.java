package Tanques;

import javax.swing.ImageIcon;

public class Nivel_4 extends Nivel {

	public Nivel_4() {
		super();
		siguiente=null;
		velocidadMov=2;
		resistencia=4;
		velDisparo=3;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoNapoliDerecha.gif"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/diegoNapoliDerecha.gif"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoNapoliIzquierda.gif"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoNapoliDerecha.gif"));
		icono=iconosNivel[0];
		cantDisparos=3;
	}

}
