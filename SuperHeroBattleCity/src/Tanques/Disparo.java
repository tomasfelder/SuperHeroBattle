package Tanques;

import java.awt.Image;
import PowerUps.*;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteligenciaDisparo;
import ObjetosDelJuego.Visitor;
import ObjetosDelJuego.gameObject;
import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.ParedDeAcero;
import Obstaculos.ParedDeLadrillo;

public abstract class Disparo extends gameObject implements Visitor {
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int direccion;
	protected InteligenciaDisparo tDisparo;
	
	public Disparo(int x,int y,int dir,int vel){
		rectangulo = new Rectangle(x, y, 22, 22);
		velocidadMovimiento=vel;
		direccion=dir;
		switch(dir){
		case(0):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Pelota.png"));
			break;
		case(1):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Pelota.png"));
			break;
		case(2):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Pelota.png"));
			break;
		case(3):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Pelota.png"));
			break;
		}
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}
	
	public Rectangle simularMovimiento(){
		Rectangle nuevaPos = new Rectangle(22, 22);
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
	
	public InteligenciaDisparo getThreadDisparo(){
		return tDisparo;
	}
	
	public void mover(){
		switch (direccion){
		case 0:
			avanzarArriba();
			break;
		case 1:
			avanzarAbajo();
			break;
		case 2:
			avanzarIzquierda();
			break;
		case 3:
			avanzarDerecha();
			break;
		}
		etiqueta.setBounds(rectangulo);
	}
	
	public void avanzarArriba(){
		rectangulo.y=rectangulo.y-velocidadMovimiento;
	}
	public void avanzarAbajo(){
		rectangulo.y=rectangulo.y+velocidadMovimiento;
	}
	public void avanzarDerecha(){
		rectangulo.x=rectangulo.x+velocidadMovimiento;
	}
	public void avanzarIzquierda(){
		rectangulo.x=rectangulo.x-velocidadMovimiento;
	}

	public boolean colisionarParedDeLadrillo(ParedDeLadrillo p,Rectangle posNueva){
		boolean colisiono = p.getRectangulo().intersects(posNueva);
		if(colisiono)
			p.afectar(direccion);
		return colisiono;
	}
	
	public boolean colisionarParedDeAcero(ParedDeAcero p,Rectangle posNueva){
		return p.getRectangulo().intersects(posNueva);
	}
	
	public boolean colisionarBosque(Bosque b,Rectangle posNueva){
		return false;
	}
	
	public boolean colisionarAgua(Agua a,Rectangle posNueva){
		return false;
	}
	
	public boolean colisionarBase(Base b,Rectangle posNueva){
		boolean colisiono = b.getRectangulo().intersects(posNueva);
		if(colisiono)
			b.afectar();
		return colisiono;
	}
	
	public boolean colisionarDisparo(Disparo d,Rectangle posNueva){
		boolean colisiono = d.getRectangulo().intersects(posNueva);
		if(colisiono){
			d.getThreadDisparo().terminate();
			this.tDisparo.terminate();
		}
		return colisiono;
	}
	
	public boolean colisionarBorde(Borde b,Rectangle posNueva){
		return b.getRectangulo().intersects(posNueva);
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
	
	public boolean colisionarPTimer(PTimer t,Rectangle posNueva){
		
		return false;
		
	}
	
	public boolean colisionarPGranada(PGranada c,Rectangle posNueva){
		
		return false;
		
	}
	
	public boolean colisionarPTanque(PTanque t,Rectangle posNueva){
		
		return false;
		
	}
	
	public abstract boolean colisionarEnemigo(Enemigo e, Rectangle posNueva);

	public abstract boolean colisionarJugador(Jugador j, Rectangle posNueva);
	
	
	
}
