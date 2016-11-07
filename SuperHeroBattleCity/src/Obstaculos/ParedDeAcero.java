package Obstaculos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import ObjetosDelJuego.Visitor;

public class ParedDeAcero extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeAcero(int i,int j,Mapa m){
		super(i,j,m);
		
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		vida=4;
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/ParedDeAcero.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarParedDeAcero(this, nuevaPos);
	}
	
	public void afectar(){
		
		if(vida==0){
			m.eliminarCelda(i, j);
			etiqueta.setIcon(null);
		}
	}
}