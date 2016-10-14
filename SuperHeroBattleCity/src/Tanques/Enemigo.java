package Tanques;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Enemigo extends Tanque {
	
	protected int puntosQueDa;
	protected volatile boolean ejecutar;
	
	public Enemigo(int x, int y) {
		super(x, y);
	}
	
	public int getPuntos(){
		return puntosQueDa;
	}
	
	public void terminate(){
		ejecutar=false;
	}
	
//	public int[] simularMovimiento(int direccion){
//		int coord[] = new int[2];
//		switch (direccion){
//		case 0:
//			coord[0]=coordenadas.x; coord[1]=coordenadas.y-velocidadMovimiento;
//			break;
//		case 1:
//			coord[0]=coordenadas.x; coord[1]=coordenadas.y+velocidadMovimiento;
//			break;
//		case 2:
//			coord[0]=coordenadas.x-velocidadMovimiento; coord[1]=coordenadas.y;
//			break;
//		case 3:
//			coord[0]=coordenadas.x+velocidadMovimiento; coord[1]=coordenadas.y;
//			break;
//		}
//		return coord;
//	}
	
	public Rectangle simularMovimiento(int direccion){
		imagen=iconos[direccion];
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
		Rectangle nuevaPos = new Rectangle(ANCHO, ALTO);
		switch (direccion){
		case 0:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y-velocidadMovimiento;
			break;
		case 1:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y+velocidadMovimiento;
			break;
		case 2:
			nuevaPos.x=rectangulo.x-velocidadMovimiento; nuevaPos.y=rectangulo.y;
			break;
		case 3:
			nuevaPos.x=rectangulo.x+velocidadMovimiento; nuevaPos.y=rectangulo.y;
			break;
		}
		return nuevaPos;
	}
	
	public void mover(int direccion){
		
		switch (direccion){
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
		
		imagen=iconos[direccion];
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}	
	
	private void moverDerecha(){
		
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		rectangulo.x=rectangulo.x+velocidadMovimiento;

		
	}
	private void moverIzquierda(){
		
		coordenadas.x=coordenadas.x-velocidadMovimiento;
		rectangulo.x=rectangulo.x-velocidadMovimiento;
	}
	private void moverArriba(){
		
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		rectangulo.y=rectangulo.y-velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		rectangulo.y=rectangulo.y+velocidadMovimiento;
		
	}
	
	public int direccion(){
		if(imagen==iconos[0])
			return 0;
		if(imagen==iconos[1])
			return 1;
		if(imagen==iconos[2])
			return 2;
		if(imagen==iconos[3])
			return 3;
		return -1;
	}
	
	public Disparo disparar(){
		switch (direccion()){
		case 0:
			return new Disparo(rectangulo.x,rectangulo.y,0,velocidadDisparo);
		case 1:
			return new Disparo(rectangulo.x,rectangulo.y,1,velocidadDisparo);
		case 2:
			return new Disparo(rectangulo.x,rectangulo.y,2,velocidadDisparo);
		case 3:
			return new Disparo(rectangulo.x,rectangulo.y,3,velocidadDisparo);
		}
		return null;
	}
	
}
