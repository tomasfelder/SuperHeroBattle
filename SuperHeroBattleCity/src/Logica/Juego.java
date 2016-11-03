package Logica;

import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.EnemigoBasico;
import Tanques.Jugador;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.GUI;
import Grafica.MuestraEtiqueta;
import Mapa.Mapa;
import ObjetosDelJuego.Visitor;

public class Juego{

	protected Jugador jugador;
	protected List<Enemigo> listaEnemigos;
	protected int cantEnemigos,puntaje,vidasJugador;
	protected Mapa mapa;
	protected GUI gui;
	protected Thread tDisparo,tJuego;
	
	
	public Juego(Mapa m,GUI g){
		jugador=new Jugador(32,32,this);
		vidasJugador=2;
		listaEnemigos= new LinkedList<Enemigo>();
		cantEnemigos=0;
		mapa=m;
		puntaje=0;
		gui=g;
		tJuego=new ThreadJuego(this);
		tJuego.start();
	}
	
	public boolean puedoMover(Rectangle nuevaPos,Visitor v){
		boolean puedo=true;
		for(int i=0;i<mapa.getLargo()&&puedo;i++)
			for(int j=0;j<mapa.getAncho()&&puedo;j++)
				if(mapa.obtenerCelda(i, j)!=null)
					puedo=!mapa.obtenerCelda(i, j).aceptar(v,nuevaPos);
		if(puedo){
			puedo=!jugador.aceptar(v, nuevaPos);
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
		if(cantEnemigos<4){
			Enemigo ene = new EnemigoBasico(x,y,this);
			cantEnemigos++;
			listaEnemigos.add(ene);
			gui.getPanelMapa().add(ene.getEtiqueta());
			gui.repintar();
			return ene;
		}
		return null;
	}
	
	public JLabel disparar(){
		Disparo disp= jugador.disparar();
		tDisparo = new IntelegenciaDisparo(disp,this);
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
			new MuestraEtiqueta(ene.getRectangulo(),ene.getPuntos(),gui).start();
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
	
	public void agregarEtiqueta(JLabel etiqueta){
		gui.getPanelMapa().add(etiqueta);
		gui.repintar();
	}

	public void perder() {
		gui.getPanelMapa().removeAll();
		JLabel gameOver = new JLabel();
		gameOver.setBounds(gui.getPanelMapa().getBounds());
		gameOver.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Game_Over.jpg")));
		gui.getPanelMapa().add(gameOver);
	}

	public void eliminarJugador() {
		vidasJugador--;
		if(vidasJugador!=0){
			gui.getPanelMapa().remove(jugador.getEtiqueta());
			jugador = new Jugador(32,32,this);
			gui.getPanelMapa().add(jugador.getEtiqueta());
		}
		else
			perder();
	}
	
}
