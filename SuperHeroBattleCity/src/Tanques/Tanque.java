package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

import ObjetosDelJuego.gameObject;

public abstract class Tanque extends gameObject {
	
	//Atributos de instancia
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	
	
	public Tanque(int x,int y){
		coordenadas = new Point(x,y);
		rectangulo = new Rectangle(x, y, ANCHO, ALTO);
		iconos=new ImageIcon[4];
	}
	
	//Metodos
	
	//public abstract int[] simularMovimiento(int direccion);
	
	public abstract Rectangle simularMovimiento(int direccion);
	
	public abstract void mover(int Direccion);
	
	public abstract Disparo disparar();
	
	public int velocidad(){
		return velocidadMovimiento;
	}
	
	
}