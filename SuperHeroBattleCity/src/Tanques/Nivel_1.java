package ObjetosDelJuego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nivel_1 extends Nivel {
	
	public Nivel_1(){
		super();
		velocidadMov=2;
		resistencia=1;
		velDisparo=1;
		icono=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Der.png"));
		
		iconosNivel[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Arriba.png"));
		iconosNivel[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_1_Abajo.png"));
		iconosNivel[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Izq.png"));
		iconosNivel[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Der.png"));
		etiqueta = new JLabel();
	}
	
}
