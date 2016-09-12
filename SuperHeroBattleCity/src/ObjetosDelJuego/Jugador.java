package ObjetosDelJuego;
 import javax.swing.*;
 
public class Jugador extends Tanque{
	
	
	public Jugador(int x,int y){
		
		super(x,y);
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
		
		imagen=new ImageIcon(this.getClass().getResource("/imagenes/giphy.gif"));
		
	}

	
	public boolean colision(gameObject o){
		
		return false;
	}
	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
