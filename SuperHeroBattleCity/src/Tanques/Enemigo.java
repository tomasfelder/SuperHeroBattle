package Tanques;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Logica.InteligenciaEnemigo;
import Logica.Juego;
import ObjetosDelJuego.Visitor;
import PowerUps.PCasco;
import PowerUps.PEstrella;
import PowerUps.PGranada;
import PowerUps.PPala;
import PowerUps.PTanque;
import PowerUps.PTimer;

public abstract class Enemigo extends Tanque {
	
	protected int puntosQueDa;
	protected boolean puedoDisparar;
	protected InteligenciaEnemigo tEnemigo;
	
	public Enemigo(int x, int y,Juego j) {
		super(x, y,j);
		puedoDisparar=true;
	}
	
	public Thread getThreadEnemigo(){
		return tEnemigo;
	}
	
	public int getPuntos(){
		return puntosQueDa;
	}
	
	public Rectangle simularMovimiento(int direccion){
		imagen=iconos[direccion];
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
		Rectangle nuevaPos = new Rectangle(28, 28);
		switch (direccion){
		case 0:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y-velocidadMovimiento;
			break;
		case 1:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y+velocidadMovimiento;
			break;
		case 2:
			nuevaPos.x=rectangulo.x-velocidadMovimiento; nuevaPos.y=rectangulo.y;
			break;
		case 3:
			nuevaPos.x=rectangulo.x+velocidadMovimiento; nuevaPos.y=rectangulo.y;
			break;
		}
		return nuevaPos;
	}
	
	public void mover(int direccion){
		
		switch (direccion){
		case 0:
			this.moverArriba();
			break;
		case 1:
			this.moverAbajo();
			break;
		case 2:
			this.moverIzquierda();
			break;
		case 3:
			this.moverDerecha();
			break;
		}
		
		imagen=iconos[direccion];
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}	
	
	private void moverDerecha(){
		
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		rectangulo.x=rectangulo.x+velocidadMovimiento;

		
	}
	private void moverIzquierda(){
		
		coordenadas.x=coordenadas.x-velocidadMovimiento;
		rectangulo.x=rectangulo.x-velocidadMovimiento;
	}
	private void moverArriba(){
		
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		rectangulo.y=rectangulo.y-velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		rectangulo.y=rectangulo.y+velocidadMovimiento;
		
	}
	
	public int direccion(){
		if(imagen==iconos[0])
			return 0;
		if(imagen==iconos[1])
			return 1;
		if(imagen==iconos[2])
			return 2;
		if(imagen==iconos[3])
			return 3;
		return -1;
	}
	
	public Disparo disparar(){
		puedoDisparar=false;
		switch (direccion()){
		case 0:
			return new DisparoEnemigo(rectangulo.x+10,rectangulo.y-10,0,velocidadDisparo);
		case 1:
			return new DisparoEnemigo(rectangulo.x+10,rectangulo.y+28,1,velocidadDisparo);
		case 2:
			return new DisparoEnemigo(rectangulo.x-10,rectangulo.y+10,2,velocidadDisparo);
		case 3:
			return new DisparoEnemigo(rectangulo.x+28,rectangulo.y+10,3,velocidadDisparo);
		}
		return null;
	}
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return v.colisionarEnemigo(this, posNueva);
	}
	
	public boolean colisionarJugador(Jugador j,Rectangle posNueva){
		return j.getRectangulo().intersects(posNueva);
	}
	
	public boolean colisionarEnemigo(Enemigo e,Rectangle posNueva){
		return e.getRectangulo().intersects(posNueva);
	}
	
	public boolean puedeDisparar(){
		return puedoDisparar;
	}
	
	public void devolverDisparo(){
		puedoDisparar=true;
	}
	
	public void afectar(){
		golpesQueResiste--;
		if(golpesQueResiste==0){
			tEnemigo.terminate();
			juego.eliminarEnemigo(this);
		}
	}
	public boolean colisionarPGranada(PGranada g,Rectangle posNueva){
			return false;
	}
	public boolean colisionarPCasco(PCasco c,Rectangle posNueva){
			return false;
	}
	public boolean colisionarPEstrella(PEstrella e,Rectangle posNueva){
	
		return false;
	}
	public boolean colisionarPPala(PPala p,Rectangle posNueva){
			return false;
	}
	public boolean colisionarPTanque(PTanque t,Rectangle posNueva){
			return false;
	}
	public boolean colisionarPTimer(PTimer t,Rectangle posNueva){
			return false;
	}
	
	
}
