package Grafica;

import java.awt.EventQueue;

import javax.swing.*;

import Mapa.*;

public class GUI {

	private JFrame frame;
	private Mapa mapa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		mapa=new Mapa(12,13,"Mapa1.txt");
		initialize();
		ponerObstaculos();
	}

	private void ponerObstaculos() {
		int pos1,pos2;
		pos1=pos2=0;
		for(int i=0;i<mapa.getLargo();i++){
			for(int j=0;j<mapa.getAncho();j++){
				if(mapa.obtenerCelda(i, j)!=null){
					JLabel etiqueta = new JLabel(mapa.obtenerCelda(i, j).getImagen());
					etiqueta.setBounds(pos1, pos2, 16, 16);
					frame.add(etiqueta);
				}
				pos2+=16;
			}
			pos2=0;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
