package Tanques;

import java.awt.Image;

import javax.swing.*;

import Obstaculos.powerUp;
 
public class Jugador extends Tanque{
	
	protected Nivel miNivel;
	
	public Jugador(int x,int y){
		super(x,y);
		miNivel=new Nivel_1();
		etiqueta=new JLabel();
		etiqueta.setBounds(x, y, ANCHO, ALTO);
		etiqueta.setIcon(miNivel.getIcon());
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
	
	public int[] simularMovimiento(int direccion){
		int coord[] = new int[2];
		miNivel.cambiarIcono(direccion);
		etiqueta.setIcon(miNivel.getIcon());
		switch (direccion){
		case 0:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y-miNivel.getVelocidadMovimiento();
			break;
		case 1:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y+miNivel.getVelocidadMovimiento();
			break;
		case 2:
			coord[0]=coordenadas.x-miNivel.getVelocidadMovimiento(); coord[1]=coordenadas.y;
			break;
		case 3:
			coord[0]=coordenadas.x+miNivel.getVelocidadMovimiento(); coord[1]=coordenadas.y;
			break;
		}
		return coord;
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
		
//		miNivel.cambiarIcono(direccion);
//		etiqueta.setIcon(miNivel.getIcon());
		etiqueta.setBounds(coordenadas.x, coordenadas.y, ANCHO, ALTO);
		
	}	
	
	private void moverDerecha(){
		
		coordenadas.x=coordenadas.x+miNivel.getVelocidadMovimiento();
		
	}
	private void moverIzquierda(){
		
		coordenadas.x=coordenadas.x-miNivel.getVelocidadMovimiento();
	}
	private void moverArriba(){
		
		coordenadas.y=coordenadas.y-miNivel.getVelocidadMovimiento();
		
	}
	private void moverAbajo(){
		
		coordenadas.y=coordenadas.y+miNivel.getVelocidadMovimiento();
		
	}
	
	public ImageIcon getImagen(){
		return miNivel.getIcono();
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(miNivel.getIcono().getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT));
		
	}
	
	public Disparo disparar(){
		Disparo disp=null;
		switch (miNivel.direccion()){
		case 0:
			disp = new Disparo(coordenadas.x,coordenadas.y,0);
			break;
		case 1:
			disp = new Disparo(coordenadas.x,coordenadas.y-32,1);
			break;
		case 2:
			disp = new Disparo(coordenadas.x+32,coordenadas.y,2);
			break;
		case 3:
			disp = new Disparo(coordenadas.x,coordenadas.y,3);
			break;
		}
		return disp;
	}
	
	public boolean colision(powerUp p){
		
		p.afectar();
		return true;
	}
	
	
}
