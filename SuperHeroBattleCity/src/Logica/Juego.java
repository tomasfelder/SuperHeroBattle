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
import PowerUps.*;

public class Juego{
	
	protected static final int TOTAL_ENEMIGOS=16;
	
	protected Jugador jugador;
	protected List<Enemigo> listaEnemigos;
	protected List<Disparo> listaDisparos;
	protected List<PowerUp> listaPowerUps;
	protected int cantEnemigosActuales,puntaje,vidasJugador,cantEnemigosCreados,cantEnemigosMatados;
	protected Mapa mapa;
	protected GUI gui;
	protected Thread tDisparo;
	protected ThreadJuego tJuego;
	
	
	public Juego(Mapa m,GUI g){
		jugador=new Jugador(162,388,this);
		vidasJugador=2;
		listaEnemigos= new LinkedList<Enemigo>();
		listaDisparos= new LinkedList<Disparo>();
		listaPowerUps= new LinkedList<PowerUp>();
		cantEnemigosActuales=0;
		cantEnemigosCreados=0;
		cantEnemigosMatados=0;
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
			Iterator<PowerUp> itP = listaPowerUps.iterator();
			while(itP.hasNext()&&puedo)
				puedo=!itP.next().aceptar(v, nuevaPos);
			puedo=!jugador.aceptar(v, nuevaPos);
			Iterator<Enemigo> itE= listaEnemigos.iterator();
			while(itE.hasNext()&&puedo){
				Enemigo aux=itE.next();
				if(aux!=v)
					puedo=!aux.aceptar(v, nuevaPos);
			}
		}
		return puedo;
	}
	
	public void crearEnemigo(int x,int y){
		if(cantEnemigosActuales<4&&cantEnemigosCreados<TOTAL_ENEMIGOS){
			Enemigo ene = new EnemigoBasico(x,y,this);
			cantEnemigosActuales++;
			cantEnemigosCreados++;
			listaEnemigos.add(ene);
			gui.getPanelMapa().add(ene.getEtiqueta());
			gui.repintar();
		}
	}
	
	public void agregarDisparo(Disparo d){
		listaDisparos.add(d);
	}
	
	public void removerDisparo(Disparo d){
		listaDisparos.remove(d);
	}
	
	public void removerPowerUp(PowerUp p){
		gui.getPanelMapa().remove(p.getEtiqueta());
		new MuestraEtiqueta(p.getRectangulo(),p.getPuntosQueDa(),gui).start();
		puntaje+=p.getPuntosQueDa();
		listaPowerUps.remove(p);
	}
	
	public void disparar(){
		Disparo disp= jugador.disparar();
		gui.getPanelMapa().add(disp.getEtiqueta());
		listaDisparos.add(disp);
	}
	
	public void eliminarEnemigo(){
		if(cantEnemigosActuales!=0){
			gui.getPanelMapa().remove(listaEnemigos.get(0).getEtiqueta());
			gui.repintar();
			listaEnemigos.remove(0);
			cantEnemigosActuales--;
		}
	}
	
	public void eliminarEnemigo(Enemigo ene){
		if(cantEnemigosActuales!=0){
			new MuestraEtiqueta(ene.getRectangulo(),ene.getPuntos(),gui).start();
			gui.getPanelMapa().remove(ene.getEtiqueta());
			gui.repintar();
			puntaje+=ene.getPuntos();
			listaEnemigos.remove(ene);
			cantEnemigosActuales--;
			cantEnemigosMatados++;
			if(cantEnemigosMatados%4==0){
				int x = new java.util.Random().nextInt(480);
				int y = new java.util.Random().nextInt(448);
				Rectangle auxiliar= new Rectangle(x,y,32,32);
				Enemigo pruebaLugar = new EnemigoBasico(0,0,this);
				while(!this.puedoMover(auxiliar, pruebaLugar)){
					auxiliar.x=new java.util.Random().nextInt(480);
					auxiliar.y=new java.util.Random().nextInt(448);
				}
				PowerUp p=new PGranada(auxiliar.x,auxiliar.y);
				listaPowerUps.add(p);
				gui.getPanelMapa().add(p.getEtiqueta());
			}
			if(cantEnemigosMatados==TOTAL_ENEMIGOS)
				ganar();
		}
	}
	
	public void eliminarEnemigos(){
		Iterator<Enemigo> itE= listaEnemigos.iterator();
		while(itE.hasNext()){
			Enemigo aux= itE.next();
			aux.terminarThread();
			gui.getPanelMapa().remove(aux.getEtiqueta());
		}
		cantEnemigosMatados+=listaEnemigos.size();
		cantEnemigosActuales=0;
		listaEnemigos.clear();
		if(cantEnemigosMatados==TOTAL_ENEMIGOS)
			ganar();
	}
	
	private void ganar() {
		gui.getPanelMapa().removeAll();
		gui.repintar();
		tJuego.terminate();
		for(Enemigo e:listaEnemigos)
			e.terminarThread();
		JLabel gameOver = new JLabel();
		gameOver.setBounds(gui.getPanelMapa().getBounds());
		gameOver.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/You_Win.jpg")));
		gui.getPanelMapa().add(gameOver);
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
		return cantEnemigosActuales;
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
		gui.repintar();
		tJuego.terminate();
		for(Enemigo e:listaEnemigos)
			e.terminarThread();
		JLabel gameOver = new JLabel();
		gameOver.setBounds(gui.getPanelMapa().getBounds());
		gameOver.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Game_Over.jpg")));
		gui.getPanelMapa().add(gameOver);
	}

	public void eliminarJugador() {
		vidasJugador--;
		if(vidasJugador!=0){
			gui.getPanelMapa().remove(jugador.getEtiqueta());
			jugador = new Jugador(162,388,this);
			gui.getPanelMapa().add(jugador.getEtiqueta());
		}
		else
			perder();
	}
	
}
