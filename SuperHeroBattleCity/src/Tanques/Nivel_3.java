package Tanques;

import javax.swing.ImageIcon;

public class Nivel_3 extends Nivel {

	public Nivel_3() {
		super();
		siguiente=new Nivel_4();
		velocidadMov=2;
		resistencia=2;
		velDisparo=2;
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/DiegoBarcaDerecha.gif"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/DiegoBarcaDerecha.gif"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/DiegoBarcaIzquierda.gif"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/DiegoBarcaDerecha.gif"));
		icono=iconosNivel[0];
		cantDisparos=2;
	}

}
