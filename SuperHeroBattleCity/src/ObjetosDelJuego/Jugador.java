package ObjetosDelJuego;

public class Jugador extends Tanque{
	
	
	public Jugador(int x,int y){
		
		this.x=x;
		this.y=y;
		velocidadMovimiento=2;
		golpesQueResiste=1;
		velocidadDisparo=1;
	}

	public void mover(int Direccion){
		
		switch (Direccion){
		case 0:
			this.moverArriba();
			break;
		
		}
		
	}
	public boolean colision(gameObject o){
		
		return false;
	}
	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
