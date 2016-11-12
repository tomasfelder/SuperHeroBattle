package Tanques;

import javax.swing.ImageIcon;

public class Nivel_2 extends Nivel {

	public Nivel_2() {
		super();
		siguiente=new Nivel_3();
		velocidadMov=6;
		resistencia=1;
		velDisparo=4;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoArgDerecha.gif"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/diegoArgDerecha.gif"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoArgIzquierda.gif"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/diegoArgDerecha.gif"));
		icono=iconosNivel[0];
		cantDisparos=1;
	}

}
