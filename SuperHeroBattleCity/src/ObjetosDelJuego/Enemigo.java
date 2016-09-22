package ObjetosDelJuego;


public abstract class Enemigo extends Tanque{
	
	protected int puntosQueDa;
	
	public Enemigo(int x, int y) {
		super(x, y);
	}
	
	public int getPuntos(){
		return puntosQueDa;
	}
}
