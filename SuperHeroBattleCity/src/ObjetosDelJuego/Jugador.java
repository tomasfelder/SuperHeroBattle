package ObjetosDelJuego;

import javax.swing.*;
 
public class Jugador extends Tanque{
	
	protected Nivel nivel;
	
	public Jugador(int x,int y){
		
		super(x,y);
		//nivel=new Nivel1();
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Der.png"));
		
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Arriba.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenesJugador/Nivel_1_Abajo.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Izq.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenesJugador/Nivel_1_Der.png"));
	}

	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
