package ObjetosDelJuego;

public abstract class Tanque extends gameObject {
	
	//Atributos de instancia
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	
	
	
	
	//Metodos
	public Disparo disparar(){
		
		return new Disparo(x,y);
	}
	
	public void moverDerecha(){
		
	}
	public void moverIzquierda(){
		
	}
	public void moverArriba(){
		
	}
	public void moverAbajo(){
		
	}
	
}