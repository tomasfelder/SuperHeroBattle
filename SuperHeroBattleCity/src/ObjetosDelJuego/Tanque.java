package ObjetosDelJuego;

import javax.swing.*;

public abstract class Tanque extends gameObject {
	
	//Atributos de instancia
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	
	
	public Tanque(int x,int y){
		
		this.x=x;
		this.y=y;
		iconos=new ImageIcon[4];
		
	}
	
	//Metodos
	
	public void mover(int Direccion){
		
		this.imagen=iconos[Direccion];
		switch (Direccion){
		case 0:
			this.moverArriba();
			break;
		case 1:
			this.moverAbajo();
			break;
		case 2:
			this.moverIzquierda();
			break;
		case 3:
			this.moverDerecha();
			break;
		}
		
	}

	public Disparo disparar(){
		
		return new Disparo(x,y);
	}
	
	private void moverDerecha(){
		
		
		this.x=this.x+5+velocidadMovimiento;
		
	}
	private void moverIzquierda(){
		
		
		this.x=this.x-5-velocidadMovimiento;
	}
	private void moverArriba(){
		
		
		this.y=this.y+5+velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		
		this.y=this.y-5-velocidadMovimiento;
		
	}
	
}