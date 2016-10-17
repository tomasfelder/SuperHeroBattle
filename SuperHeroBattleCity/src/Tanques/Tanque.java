package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

import ObjetosDelJuego.*;
import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Bosque;
import Obstaculos.Pared;

public abstract class Tanque extends gameObject implements Visitor {
	
	//Atributos de instancia
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	
	
	public Tanque(int x,int y){
		coordenadas = new Point(x,y);
		rectangulo = new Rectangle(x, y, 28, 28);
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
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return false;
	}
	
	public boolean colisionarPared(Pared p,Rectangle posNueva){
		return p.getRectangulo().intersects(posNueva);
	}
	public boolean colisionarBosque(Bosque b,Rectangle posNueva){
		return false;
	}
	public boolean colisionarAgua(Agua a,Rectangle posNueva){
		return a.getRectangulo().intersects(posNueva);
	}
	public boolean colisionarBase(Base b,Rectangle posNueva){
		return b.getRectangulo().intersects(posNueva);
	}
	public boolean colisionarDisparo(Disparo d,Rectangle posNueva){
		return d.getRectangulo().intersects(posNueva);
	}
	
}