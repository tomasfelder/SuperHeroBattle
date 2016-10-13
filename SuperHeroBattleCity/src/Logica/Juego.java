package Logica;

import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.GUI;
import Mapa.Mapa;

public class Juego{

	private Jugador jugador;
	private Enemigo enemigo;
	private Mapa mapa;
	private GUI gui;
	private int puntaje;
	protected volatile boolean ejecutar;
	private Thread tDisparo,tEnemigo;
	
	public Juego(Mapa m){
	
		jugador=new Jugador(0,0);
		mapa=m;
		puntaje=0;
	}
	
	public boolean puedoMover(int[] coord){
		boolean puedo=true;
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).hayColision(coord);
		return puedo;
	}
	
	public boolean puedoMover(Rectangle nuevaPos){
		boolean puedo=true;
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).getRectangulo().intersects(nuevaPos);
		return puedo;
	}
	
	public void crearEnemigo(int x,int y){
		enemigo = new EnemigoBasico(x,y);
		InteligenciaEnemigo ie = new InteligenciaEnemigo(enemigo,this);
		tEnemigo=new Thread(ie);
		tEnemigo.start();
	}
	
	public JLabel disparar(){
		Disparo disp= jugador.disparar();
		IntelegenciaDisparo id=new IntelegenciaDisparo(disp,this);
		tDisparo= new Thread(id);
		tDisparo.start();
		return disp.getEtiqueta();
	}
	
	public void eliminarEnemigo(){
		puntaje+=enemigo.getPuntos();
		enemigo=null;
	}
	
	public Enemigo getEnemigo(){
		
		return enemigo;
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
	
}
