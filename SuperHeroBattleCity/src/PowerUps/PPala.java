package PowerUps;

import java.awt.Image;
import java.awt.Rectangle;
import ObjetosDelJuego.Visitor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PPala extends PowerUp{

	public PPala(int x,int y){
		super(x,y);
		rectangulo = new Rectangle(0, 0, ANCHO, ALTO);
		imagen = new ImageIcon(this.getClass().getResource("/imagenesPowerUp/PowerPala.png"));
		etiqueta = new JLabel();
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT)));
		etiqueta.setBounds(0, 0,ANCHO , ALTO);
	}
	public boolean aceptar(Visitor v,Rectangle nuevaPos){
		
		return v.colisionarPPala(this, nuevaPos);
		
	}
}