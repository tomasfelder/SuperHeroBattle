package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

import Logica.Juego;
import ObjetosDelJuego.*;
import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.Pared;
import PowerUps.PCasco;
import PowerUps.PEstrella;
import PowerUps.PGranada;
import PowerUps.PPala;
import PowerUps.PTanque;
import PowerUps.PTimer;

public abstract class Tanque extends gameObject implements Visitor {
	
	//Atributos de instancia
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int golpesQueResiste;
	protected int velocidadDisparo;
	protected Juego juego;
	
	public Tanque(int x,int y,Juego j){
		coordenadas = new Point(x,y);
		rectangulo = new Rectangle(x, y, 28, 28);
		iconos=new ImageIcon[4];
		juego=j;
	}
	
	//Metodos
	
	
	public abstract Rectangle simularMovimiento(int direccion);
	
	public abstract void mover(int Direccion);
	
	public abstract Disparo disparar();
	
	public int velocidad(){
		return velocidadMovimiento;
	}
	
	public abstract boolean aceptar(Visitor v,Rectangle posNueva);
	
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
		return false;
	}
	
	public boolean colisionarBorde(Borde b,Rectangle posNueva){
		return b.getRectangulo().intersects(posNueva);
	}
	public abstract boolean colisionarPGranada(PGranada g,Rectangle posNueva);
	public abstract boolean colisionarPCasco(PCasco c,Rectangle posNueva);
	public abstract boolean colisionarPEstrella(PEstrella e,Rectangle posNueva);
	public abstract boolean colisionarPPala(PPala p,Rectangle posNueva);
	public abstract boolean colisionarPTanque(PTanque t,Rectangle posNueva);
	public abstract boolean colisionarPTimer(PTimer t,Rectangle posNueva);
	
}