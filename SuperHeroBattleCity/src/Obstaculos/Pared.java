package Obstaculos;

import java.awt.Rectangle;

import ObjetosDelJuego.Visitor;

public abstract class Pared extends Obstaculo {
	
	protected int vida;
	
	public int getVida(){
		return vida;
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarPared(this, nuevaPos);
	}
	
}
