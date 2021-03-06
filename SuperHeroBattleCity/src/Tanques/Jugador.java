package Tanques;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;


import Logica.InteligenciaCasco;
import Logica.Juego;
import ObjetosDelJuego.Visitor;
import PowerUps.*;

 
public class Jugador extends Tanque{
	
	protected Nivel miNivel;
	protected boolean vulnerable;
	
	//Constructors
	public Jugador(int x,int y,Juego j){
		super(x,y,j);
		vulnerable=true;
		miNivel=new Nivel_1();
		etiqueta=new JLabel();
		etiqueta.setBounds(x, y, 48, 48);
		etiqueta.setIcon(miNivel.getIcon());
		etiqueta.setOpaque(false);
	}
	
	public void setNivel(int n){
		switch (n){
		case 0:
			miNivel = new Nivel_1();
			break;
		case 1:
			miNivel = new Nivel_2();
			break;
		case 2:
			miNivel = new Nivel_3();
			break;
		case 3:
			miNivel = new Nivel_4();
			break;
		}
		etiqueta.setIcon(miNivel.getIcon());
	}
	
	public Rectangle simularMovimiento(int direccion){
		Rectangle nuevaPos = new Rectangle(48, 48);
		if(direccion!=direccionQueApunta){
			miNivel.cambiarIcono(direccion);
			etiqueta.setIcon(miNivel.getIcon());
		}
		direccionQueApunta=direccion;
		switch (direccion){
		case 0:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y-miNivel.getVelocidadMovimiento();
			break;
		case 1:
			nuevaPos.x=rectangulo.x; nuevaPos.y=rectangulo.y+miNivel.getVelocidadMovimiento();
			break;
		case 2:
			nuevaPos.x=rectangulo.x-miNivel.getVelocidadMovimiento(); nuevaPos.y=rectangulo.y;
			break;
		case 3:
			nuevaPos.x=rectangulo.x+miNivel.getVelocidadMovimiento(); nuevaPos.y=rectangulo.y;
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
		
		etiqueta.setBounds(rectangulo);
		
	}	
	
	private void moverDerecha(){
		
		rectangulo.x=rectangulo.x+miNivel.getVelocidadMovimiento();
		
	}
	private void moverIzquierda(){
		
		rectangulo.x=rectangulo.x-miNivel.getVelocidadMovimiento();
	}
	private void moverArriba(){
		
		rectangulo.y=rectangulo.y-miNivel.getVelocidadMovimiento();
		
	}
	private void moverAbajo(){
		
		rectangulo.y=rectangulo.y+miNivel.getVelocidadMovimiento();
		
	}
	
	public ImageIcon getImagen(){
		return miNivel.getIcono();
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(miNivel.getIcono().getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));
		
	}
	
	public Disparo disparar(){
		miNivel.quitarDisparo();
		switch (direccionQueApunta){
		case 0:
			return new DisparoJugador(rectangulo.x+10,rectangulo.y-10,0,miNivel.getVelocidadDisparo(),juego);
		case 1:
			return new DisparoJugador(rectangulo.x+10,rectangulo.y+48,1,miNivel.getVelocidadDisparo(),juego);
		case 2:
			return new DisparoJugador(rectangulo.x-10,rectangulo.y+10,2,miNivel.getVelocidadDisparo(),juego);
		case 3:
			return new DisparoJugador(rectangulo.x+48,rectangulo.y+10,3,miNivel.getVelocidadDisparo(),juego);
		}
		return null;
	}
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return v.colisionarJugador(this, posNueva);
	}
	
	public boolean colisionarEnemigo(Enemigo e,Rectangle posNueva){
		return e.getRectangulo().intersects(posNueva);
	}
	
	public boolean colisionarJugador(Jugador j,Rectangle posNueva){
		return false;
	}
	
	public void setVulnerable(boolean b){
		
		vulnerable=b;
	}
	
	public int getCantidadDisparos(){
		return miNivel.getCantidadDisparos();
	}
	
	public void devolverDisparo(){
		miNivel.devolverDisparo();
	}
	
	public void quitarDisparo(){
		miNivel.quitarDisparo();
	}

	public void afectar() {
		if (vulnerable)
			miNivel.restarVida();
		if(miNivel.getResistencia()==0)
			juego.eliminarJugador();
			
	}
	public boolean colisionarPGranada(PGranada g,Rectangle posNueva){
		if(g.getRectangulo().intersects(posNueva)){
			juego.removerPowerUp(g);
			juego.eliminarEnemigos();
		}
		return false;
	}
	
	public boolean colisionarPCasco(PCasco c,Rectangle posNueva){
		if(c.getRectangulo().intersects(posNueva)){
			setVulnerable(false);
			new InteligenciaCasco(this).start();
			juego.removerPowerUp(c);
		}
		return false;
	}
	
	public boolean colisionarPEstrella(PEstrella e,Rectangle posNueva){
		if (e.getRectangulo().intersects(posNueva)){
			juego.removerPowerUp(e);
			if(miNivel.getSiguiente()!=null)
				miNivel=miNivel.getSiguiente();
		}
		return false;
	}
	
	public boolean colisionarPPala(PPala p,Rectangle posNueva){
		return false;
	}
	public boolean colisionarPTanque(PTanque t,Rectangle posNueva){
		if(t.getRectangulo().intersects(posNueva)){
			juego.agregarVida();
			juego.removerPowerUp(t);
		}
		return false;
	}
	public boolean colisionarPTimer(PTimer t,Rectangle posNueva){
		if(t.getRectangulo().intersects(posNueva)){
			juego.pararEnemigos();
			juego.removerPowerUp(t);
		}
		return false;
	}
	
}
