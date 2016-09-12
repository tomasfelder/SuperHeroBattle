package ObjetosDelJuego;
 import javax.swing.*;
 
public class Jugador extends Tanque{
	
	
	public Jugador(int x,int y){
		
		super(x,y);
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenes/batmanUP.png"));
		iconos[0]=new ImageIcon(this.getClass().getResource("/imagenes/batmanUP.png"));
		iconos[1]=new ImageIcon(this .getClass().getResource("/imagenes/batmanUP.png"));
		iconos[2]=new ImageIcon(this.getClass().getResource("/imagenes/batmanUP.png"));
		iconos[3]=new ImageIcon(this.getClass().getResource("/imagenes/batmanUP.png"));
	}

	
	public boolean colision(gameObject o){
		
		return false;
	}
	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
