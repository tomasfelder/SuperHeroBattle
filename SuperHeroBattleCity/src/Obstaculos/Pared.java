package Obstaculos;

import java.awt.Rectangle;

import ObjetosDelJuego.Visitor;
import Mapa.Mapa;
public abstract class Pared extends Obstaculo {
	
	protected int vida;
	
	protected Pared(int i,int j,Mapa m){
		
		this.i=i;
		this.j=j;
		this.m=m;
	}
	
	public int getVida(){
		return vida;
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarPared(this, nuevaPos);
	}
	
	
	public void afectar(){
		vida--;
		if(vida==0){
			m.eliminarCelda(i, j);
			etiqueta.setIcon(null);
		}
	}
	
}
