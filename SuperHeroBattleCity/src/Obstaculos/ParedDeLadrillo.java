package Obstaculos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import ObjetosDelJuego.Visitor;
public class ParedDeLadrillo extends Pared {
	
	/**
	 * Constructor
	 */
	public ParedDeLadrillo(int i,int j,Mapa m){
		super(i,j,m);
		vida=4;
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Tierra_2.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(rectangulo);
	}
	
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		return v.colisionarParedDeLadrillo(this, nuevaPos);
	}
	
	public void afectar(){
		vida--;
		if(vida==0){
			m.eliminarCelda(i, j);
			etiqueta.setIcon(null);
		}
	}
	
}
