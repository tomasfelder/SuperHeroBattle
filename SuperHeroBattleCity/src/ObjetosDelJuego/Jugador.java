package ObjetosDelJuego;
 import javax.swing.*;
 
public class Jugador extends Tanque{
	
	
	public Jugador(int x,int y){
		
		this.x=x;
		this.y=y;
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
		iconos=new ImageIcon[4];
		
	}

	
	public boolean colision(gameObject o){
		
		return false;
	}
	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
