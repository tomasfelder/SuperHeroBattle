package ObjetosDelJuego;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Nivel {
	
	protected int velocidadMov;
	protected int resistencia;
	protected int velDisparo;
	protected ImageIcon[] iconosNivel;
	protected ImageIcon icono;
	
	public Nivel(){
		iconosNivel=new ImageIcon[4];
	}
	
	public int direccion(){
		if(icono==iconosNivel[0])
			return 0;
		if(icono==iconosNivel[1])
			return 1;
		if(icono==iconosNivel[2])
			return 2;
		if(icono==iconosNivel[3])
			return 3;
		return -1;
	}
	
	public int getVelocidadMovimiento(){
		return velocidadMov;
	}
	
	public int getResistencia(){
		return resistencia;
	}
	
	public int getVelocidadDisparo(){
		return velDisparo;
	}
	
	public ImageIcon getIcono(){
		return icono;
	}
	
	public void cambiarIcono(int d){
		icono=iconosNivel[d];
	}

}
