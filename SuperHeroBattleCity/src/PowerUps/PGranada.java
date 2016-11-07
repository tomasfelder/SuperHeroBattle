package PowerUps;

import java.awt.Image;
import java.awt.Rectangle;
import ObjetosDelJuego.Visitor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PGranada extends PowerUp{

	public PGranada(int x,int y){
		super(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/imagenesPowerUp/PowerGranada.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(x, y,ANCHO , ALTO);
	}
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		
		return v.colisionarPGranada(this, nuevaPos);
		
	}
}
