package Tanques;

import java.awt.Image;
import PowerUps.*;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ObjetosDelJuego.Visitor;
import ObjetosDelJuego.gameObject;
import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.Pared;

public abstract class Disparo extends gameObject implements Visitor {
	
	protected ImageIcon[] iconos;
	protected int velocidadMovimiento;
	protected int direccion;
	
	public Disparo(int x,int y,int dir,int vel){
		coordenadas = new Point(x,y);
		rectangulo = new Rectangle(x, y, 7, 10);
		velocidadMovimiento=vel;
		direccion=dir;
		switch(dir){
		case(0):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Arriba.png"));
			break;
		case(1):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Abajo.png"));
			break;
		case(2):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Izq.png"));
			break;
		case(3):
			imagen = new ImageIcon(this.getClass().getResource("/imagenes/Disparo_Der.png"));
			break;
		}
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(7, 10, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}
	
	public Rectangle simularMovimiento(){
		Rectangle nuevaPos = new Rectangle(7, 10);
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
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		rectangulo.y=rectangulo.y-velocidadMovimiento;
	}
	public void avanzarAbajo(){
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		rectangulo.y=rectangulo.y+velocidadMovimiento;
	}
	public void avanzarDerecha(){
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		rectangulo.x=rectangulo.x+velocidadMovimiento;
	}
	public void avanzarIzquierda(){
		coordenadas.x=coordenadas.x-velocidadMovimiento;
		rectangulo.x=rectangulo.x-velocidadMovimiento;
	}
	
	public Icon getIcon(){
		
		return new ImageIcon(imagen.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		
	}
	
	public boolean aceptar(Visitor v,Rectangle posNueva){
		return false;
	}

	public boolean colisionarPared(Pared p,Rectangle posNueva){
		boolean colisiono = p.getRectangulo().intersects(posNueva);
		if(colisiono)
			p.afectar(direccion);
		return colisiono;
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
		return false;
	}
	
	public boolean colisionarBorde(Borde b,Rectangle posNueva){
		return b.getRectangulo().intersects(posNueva);
	}

	public abstract boolean colisionarEnemigo(Enemigo e, Rectangle posNueva);

	public abstract boolean colisionarJugador(Jugador j, Rectangle posNueva);
	
	
	
}
