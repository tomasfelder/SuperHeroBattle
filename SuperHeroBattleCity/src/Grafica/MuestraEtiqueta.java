package Grafica;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MuestraEtiqueta extends Thread {
	
	protected JLabel label;
	protected GUI gui;
	
	public MuestraEtiqueta(Rectangle rectangulo, int puntosQueDa,GUI g){
		gui=g;
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/Puntaje_100.png"));
		label=new JLabel();
		label.setBounds((int) rectangulo.getCenterX()-5,(int) rectangulo.getCenterY(),15,9);
		label.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(15, 9, Image.SCALE_DEFAULT)));
		gui.getPanelMapa().add(label);
		gui.repintar();
	}
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long elapsedTime=0;
		long elapsedSeconds=0;
		while(elapsedSeconds<=1){
			elapsedTime = System.currentTimeMillis() - startTime;
			elapsedSeconds = elapsedTime / 1000;
		}
		gui.getPanelMapa().remove(label);
		gui.repintar();
	}

}
