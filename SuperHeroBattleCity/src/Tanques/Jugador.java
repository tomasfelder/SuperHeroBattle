package Tanques;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;
 
public class Jugador extends Tanque{
	
	protected Nivel miNivel;
	
	public Jugador(int x,int y){
		super(x,y);
		miNivel=new Nivel_1();
		etiqueta=new JLabel();
		etiqueta.setBounds(x, y, 28, 28);
		etiqueta.setIcon(miNivel.getIcon());
		etiqueta.setOpaque(false);
	}
	
	public void setNivel(int n){
		switch (n){
		case 0:
			miNivel = new Nivel_1();
			break;
		case 1:
			miNivel = new Nivel_2();
			break;
		case 2:
			miNivel = new Nivel_3();
			break;
		case 3:
			miNivel = new Nivel_4();
			break;
		}
		etiqueta.setIcon(miNivel.getIcon());
	}
	
	public Rectangle simularMovimiento(int direccion){
		int coord[] = new int[2];
		Rectangle nuevaPos = new Rectangle(28, 28);
		miNivel.cambiarIcono(direccion);
		etiqueta.setIcon(miNivel.getIcon());
		switch (direccion){
		case 0:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y-miNivel.getVelocidadMovimiento();
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y-miNivel.getVelocidadMovimiento();
			break;
		case 1:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y+miNivel.getVelocidadMovimiento();
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y+miNivel.getVelocidadMovimiento();
			break;
		case 2:
			coord[0]=coordenadas.x-miNivel.getVelocidadMovimiento(); coord[1]=coordenadas.y;
			nuevaPos.x=rectangulo.x-miNivel.getVelocidadMovimiento(); nuevaPos.y=rectangulo.y;
			break;
		case 3:
			coord[0]=coordenadas.x+miNivel.getVelocidadMovimiento(); coord[1]=coordenadas.y;
			nuevaPos.x=rectangulo.x+miNivel.getVelocidadMovimiento(); nuevaPos.y=rectangulo.y;
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
		
		etiqueta.setBounds(rectangulo);
		
	}	
	
	private void moverDerecha(){
		
		coordenadas.x=coordenadas.x+miNivel.getVelocidadMovimiento();
		rectangulo.x=rectangulo.x+miNivel.getVelocidadMovimiento();
		
	}
	private void moverIzquierda(){
		
		coordenadas.x=coordenadas.x-miNivel.getVelocidadMovimiento();
		rectangulo.x=rectangulo.x-miNivel.getVelocidadMovimiento();
	}
	private void moverArriba(){
		
		coordenadas.y=coordenadas.y-miNivel.getVelocidadMovimiento();
		rectangulo.y=rectangulo.y-miNivel.getVelocidadMovimiento();
		
	}
	private void moverAbajo(){
		
		coordenadas.y=coordenadas.y+miNivel.getVelocidadMovimiento();
		rectangulo.y=rectangulo.y+miNivel.getVelocidadMovimiento();
		
	}
	
	public ImageIcon getImagen(){
		return miNivel.getIcono();
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(miNivel.getIcono().getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT));
		
	}
	
	public Disparo disparar(){
		switch (miNivel.direccion()){
		case 0:
			return new Disparo(rectangulo.x+10,rectangulo.y-10,0,miNivel.getVelocidadDisparo());
		case 1:
			return new Disparo(rectangulo.x+10,rectangulo.y+28,1,miNivel.getVelocidadDisparo());
		case 2:
			return new Disparo(rectangulo.x-10,rectangulo.y+10,2,miNivel.getVelocidadDisparo());
		case 3:
			return new Disparo(rectangulo.x+28,rectangulo.y+10,3,miNivel.getVelocidadDisparo());
		}
		return null;
	}
	
	public boolean colisionarEnemigo(Enemigo e,Rectangle posNueva){
		return e.getRectangulo().intersects(posNueva);
	}
	
	public boolean colisionarJugador(Jugador j,Rectangle posNueva){
		return false;
	}
	
}
