package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import Logica.Juego;
import javax.swing.*;


import Mapa.*;
import ObjetosDelJuego.gameObject;

public class GUI {

	private JFrame frame;
	private Mapa mapa;
	private Juego j;
	private JLabel labelJugador;
	
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
		j=new Juego(this);
		mapa=new Mapa(12,13,"Mapa1.txt");
		
		initialize();	
		frame.addKeyListener(new KeyAdapter() {
			@Override
			/*public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}*/
			public void keyPressed(KeyEvent arg0){
				
				mover(arg0);
			}
		});
		iniciarJugador();
		ponerObstaculos();
	}

	private void iniciarJugador(){
		
		labelJugador=new JLabel(j.getJugador().getImagen());
		labelJugador.setBounds(j.getJugador().x(), j.getJugador().y(), 32, 32);
		frame.add(labelJugador);
	}
	
	private void ponerObstaculos() {
		int pos1,pos2;
		pos1=pos2=0;
		for(int i=0;i<mapa.getLargo();i++){
			for(int j=0;j<mapa.getAncho();j++){
				if(mapa.obtenerCelda(i, j)!=null){
					gameObject aux=mapa.obtenerCelda(i, j);
					aux.setX(pos2); aux.setY(pos1);
					JLabel etiqueta = new JLabel(aux.getIcon());
					etiqueta.setBounds(pos2, pos1, 32, 32);
					frame.getContentPane().add(etiqueta);
				}
				else{
					JLabel etiqueta = new JLabel();
					etiqueta.setBackground(Color.BLACK);
					etiqueta.setOpaque(true);
					etiqueta.setBounds(pos2, pos1, 32, 32);
					frame.getContentPane().add(etiqueta);
				}
				pos2+=32;
			}
			pos2=0;
			pos1+=32;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(640, 480);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void mover(KeyEvent k){
		
		int direccion = 4;
		
		switch (k.getKeyCode()){
			case KeyEvent.VK_UP : 
				direccion = 0;
				break;
			case KeyEvent.VK_DOWN :
				direccion = 1;
				break;
			case KeyEvent.VK_LEFT : 
				direccion = 2;
				break;
			case KeyEvent.VK_RIGHT : 
				direccion = 3;
				break;
		}
		if (direccion!=4)
			j.mover(direccion);
		labelJugador.setIcon(j.getJugador().getIcon());
		labelJugador.setBounds(j.getJugador().x(),j.getJugador().y(),32,32);
		System.out.println(j.getJugador().x());
		frame.repaint();
		
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	
}
