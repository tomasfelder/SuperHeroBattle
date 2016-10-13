package Tanques;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ObjetosDelJuego.gameObject;

public class Disparo extends gameObject {
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int direccion;
	
	public Disparo(int x,int y,int dir,int vel){
		coordenadas = new Point(x,y);
		rectangulo = new Rectangle(x, y, 20, 20);
		velocidadMovimiento=vel;
		direccion=dir;
		switch(dir){
		case(0):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Arriba.png"));
			break;
		case(1):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Abajo.png"));
			break;
		case(2):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Der.png"));
			break;
		case(3):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Izq.png"));
			break;
		}
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}
	
	public boolean colision(gameObject o){
		
		return true;
		
	}
	
//	public int[] simularMovimiento(){
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
	
	public Rectangle simularMovimiento(){
		Rectangle nuevaPos = new Rectangle(20, 20);
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
	
	
	public void mover(){
		switch (direccion){
		case 0:
			avanzarArriba();
			break;
		case 1:
			avanzarAbajo();
			break;
		case 2:
			avanzarIzquierda();
			break;
		case 3:
			avanzarDerecha();
			break;
		}
		etiqueta.setBounds(rectangulo);
	}
	
	public void avanzarArriba(){
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		rectangulo.y=rectangulo.y-velocidadMovimiento;
	}
	public void avanzarAbajo(){
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		rectangulo.y=rectangulo.y+velocidadMovimiento;
	}
	public void avanzarDerecha(){
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		rectangulo.x=rectangulo.x+velocidadMovimiento;
	}
	public void avanzarIzquierda(){
		coordenadas.x=coordenadas.x-velocidadMovimiento;
		rectangulo.x=rectangulo.x-velocidadMovimiento;
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
	}
	
}
