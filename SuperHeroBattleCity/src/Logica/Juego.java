package Logica;

import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;
import Tanques.Tanque;

import java.awt.Rectangle;
import javax.swing.JLabel;

import Grafica.GUI;
import Mapa.Mapa;
import ObjetosDelJuego.Visitor;
import ObjetosDelJuego.gameObject;

public class Juego{

	private Jugador jugador;
	private Enemigo[] enemigos;
	private int cantEnemigos;
	private Mapa mapa;
	private GUI gui;
	private int puntaje;
	private Thread tDisparo,tEnemigo;
	
	public Juego(Mapa m,GUI g){
	
		jugador=new Jugador(0,0);
		enemigos= new Enemigo[4];
		cantEnemigos=0;
		mapa=m;
		puntaje=0;
		gui=g;
	}
	
//	public boolean puedoMover(int[] coord){
//		boolean puedo=true;
//		for(int i=0;i<mapa.getLargo()&&puedo;i++)
//			for(int j=0;j<mapa.getAncho()&&puedo;j++)
//				if(mapa.obtenerCelda(i, j)!=null)
//					puedo=!mapa.obtenerCelda(i, j).hayColision(coord);
//		return puedo;
//	}
	
	public boolean puedoMover(Rectangle nuevaPos,Visitor v){
		boolean puedo=true;
		puedo=!v.colisionarJugador(jugador, nuevaPos);
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).aceptar(v,nuevaPos);
		for(int i=0;i<cantEnemigos&&puedo;i++)
			if(enemigos[i]!=v)
				puedo=!v.colisionarEnemigo(enemigos[i], nuevaPos);
		return puedo;
	}
	
	public Enemigo crearEnemigo(int x,int y){
		boolean encontre=false;
		int i=0;
		while(i<4&&!encontre){
			encontre=enemigos[i]==null;
			if(!encontre)
				i++;
		}
		if(encontre){
			enemigos[i] = new EnemigoBasico(x,y);
			cantEnemigos++;
			InteligenciaEnemigo ie = new InteligenciaEnemigo(enemigos[i],this);
			tEnemigo=new Thread(ie);
			tEnemigo.start();
			return enemigos[i];
		}
		else return null;
	}
	
	public JLabel disparar(){
		Disparo disp= jugador.disparar();
		IntelegenciaDisparo id=new IntelegenciaDisparo(disp,this);
		tDisparo= new Thread(id);
		tDisparo.start();
		return disp.getEtiqueta();
	}
	
	public void eliminarEnemigo(){
		if(cantEnemigos!=0){
			int i=0;
			while(enemigos[i]==null)
				i++;
			gui.getPanelMapa().remove(enemigos[i].getEtiqueta());
			enemigos[i]=null;
			cantEnemigos--;
		}
			
	}
	
	public Enemigo[] getEnemigos(){
		
		return enemigos;
	}
	
	public void sumarPuntaje(int p){
		puntaje=p;
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public Jugador getJugador(){
		return jugador;
	}
	public void mover(int dir){	
		if (dir!=4)
			jugador.mover(dir);
	}

	public int getCantidadEnemigos() {
		return cantEnemigos;
	}
	
}
