package ObjetosDelJuego;

abstract class powerUp extends gameObject {

	public powerUp(int x,int y){
		
		coordenadas.x=x;
		coordenadas.y=y;
		
	}
	
	abstract void afectar();
}
