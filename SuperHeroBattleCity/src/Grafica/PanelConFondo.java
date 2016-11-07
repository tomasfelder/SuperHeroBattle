package Grafica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
	
	private Image imagen; 
	
	public PanelConFondo() {
		super();
		imagen = new ImageIcon(this.getClass().getResource("/imagenes/Fondo.png")).getImage();
	}
	
	 @Override
	public void paint(Graphics g) {
	        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
	                        this);
	 
	        setOpaque(false);
	        super.paint(g);
	    }

}
