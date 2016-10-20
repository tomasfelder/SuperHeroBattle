package Logica;

import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import Grafica.GUI;
import Mapa.Mapa;
import ObjetosDelJuego.Visitor;

public class Juego{

	private Jugador jugador;
	private List<Enemigo> listaEnemigos;
	private int cantEnemigos;
	private Mapa mapa;
	private GUI gui;
	private int puntaje;
	private Thread tDisparo,tEnemigo;
	
	public Juego(Mapa m,GUI g){
		jugador=new Jugador(32,32);
		listaEnemigos= new LinkedList<Enemigo>();
		cantEnemigos=0;
		mapa=m;
		puntaje=0;
		gui=g;
	}
	
	public boolean puedoMover(Rectangle nuevaPos,Visitor v){
		boolean puedo=true;
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).aceptar(v,nuevaPos);
		if(puedo){
			puedo=!v.colisionarJugador(jugador, nuevaPos);
			Iterator<Enemigo> it= listaEnemigos.iterator();
			while(it.hasNext()&&puedo){
				Enemigo aux=it.next();
				if(aux!=v)
					puedo=!v.colisionarEnemigo(aux, nuevaPos);
			}
		}
		return puedo;
	}
	
	public Enemigo crearEnemigo(int x,int y){
		if(cantEnemigos<5){
			Enemigo ene = new EnemigoBasico(x,y,this);
			cantEnemigos++;
			listaEnemigos.add(ene);
			InteligenciaEnemigo ie = new InteligenciaEnemigo(ene,this);
			tEnemigo=new Thread(ie);
			tEnemigo.start();
			return ene;
		}
		return null;
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
			gui.getPanelMapa().remove(listaEnemigos.get(0).getEtiqueta());
			gui.repintar();
			listaEnemigos.remove(0);
			cantEnemigos--;
		}
	}
	
	public void eliminarEnemigo(Enemigo ene){
		if(cantEnemigos!=0){
			gui.getPanelMapa().remove(ene.getEtiqueta());
			gui.repintar();
			listaEnemigos.remove(ene);
			cantEnemigos--;
		}
	}
	
	public List<Enemigo> getEnemigos(){
		
		return listaEnemigos;
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

	public void quitarEtiqueta(JLabel etiqueta) {
		gui.getPanelMapa().remove(etiqueta);
		gui.repintar();
	}
	
}
