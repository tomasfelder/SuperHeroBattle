package ObjetosDelJuego;

import java.awt.Image;

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
	
	public int[] simularMovimiento(int direccion){
		int coordenadas[] = new int[2];
		switch (direccion){
		case 0:
			coordenadas[0]=x; coordenadas[1]=this.y-velocidadMovimiento;
			break;
		case 1:
			coordenadas[0]=x; coordenadas[1]=this.y+velocidadMovimiento;
			break;
		case 2:
			coordenadas[0]=this.x-velocidadMovimiento; coordenadas[1]=y;
			break;
		case 3:
			coordenadas[0]=this.x+velocidadMovimiento; coordenadas[1]=y;
			break;
		}
		return coordenadas;
	}
	
	public void mover(int Direccion){
		
		
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
		cambiarImagen(Direccion);
		
	}

	private void cambiarImagen(int d){
		
		imagen=iconos[d];
		
	}
	
	public Disparo disparar(){
		
		return new Disparo(x,y);
	}
	
	private void moverDerecha(){
		
		
		this.x=this.x+velocidadMovimiento;
		
	}
	private void moverIzquierda(){
		
		
		this.x=this.x-velocidadMovimiento;
	}
	private void moverArriba(){
		
		
		this.y=this.y-velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		
		this.y=this.y+velocidadMovimiento;
		
	}
	
	public int velocidad(){
		return velocidadMovimiento;
	}
	
	
}