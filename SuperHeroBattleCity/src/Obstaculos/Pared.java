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
	
	
	public void afectar(int direccion){
		switch (direccion){
		case 0:
			rectangulo.height-=8;
			break;
		case 1:
			rectangulo.y+=8;
			rectangulo.height-=8;
			break;
		case 2:
			rectangulo.width-=8;
			break;
		case 3:
			rectangulo.x+=8;
			rectangulo.width-=8;
			break;
		}
		etiqueta.setBounds(rectangulo);
		vida--;
		if(vida==0){
			m.eliminarCelda(i, j);
			etiqueta.setIcon(null);
		}
	}
	
	public boolean EsPared(){
		return true;
	}
	
}
