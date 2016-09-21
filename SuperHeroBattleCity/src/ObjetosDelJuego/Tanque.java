package ObjetosDelJuego;

import java.awt.Image;
import java.awt.Point;

import javax.swing.*;

public abstract class Tanque extends gameObject {
	
	//Atributos de instancia
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	
	
	public Tanque(int x,int y){
		
		coordenadas = new Point(x,y);
		iconos=new ImageIcon[4];
		
	}
	
	//Metodos
	
	public int[] simularMovimiento(int direccion){
		int coord[] = new int[2];
		switch (direccion){
		case 0:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y-velocidadMovimiento;
			break;
		case 1:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y+velocidadMovimiento;
			break;
		case 2:
			coord[0]=coordenadas.x-velocidadMovimiento; coord[1]=coordenadas.y;
			break;
		case 3:
			coord[0]=coordenadas.x+velocidadMovimiento; coord[1]=coordenadas.y;
			break;
		}
		return coord;
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
		
		return new Disparo(coordenadas.x,coordenadas.y);
	}
	
	private void moverDerecha(){
		
		
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		
	}
	private void moverIzquierda(){
		
		
		coordenadas.x=coordenadas.x-velocidadMovimiento;
	}
	private void moverArriba(){
		
		
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		
	}
	
	public int velocidad(){
		return velocidadMovimiento;
	}
	
	
}