package ObjetosDelJuego;

abstract class powerUp extends gameObject {

	public powerUp(int x,int y){
		
		this.x=x;
		this.y=y;
		
	}
	
	abstract void afectar();
}
