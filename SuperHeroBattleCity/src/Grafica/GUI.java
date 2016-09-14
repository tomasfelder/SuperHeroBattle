package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
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
		
		initialize(12,13);	
		frame.addKeyListener(new KeyAdapter() {
			@Override
			/*public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}*/
			public void keyPressed(KeyEvent arg0){
				
				int direccion=movimiento(arg0);
				int[] coordenadas = j.getJugador().simularMovimiento(direccion);
				System.out.println(j.puedoMover(coordenadas));
				if(j.puedoMover(coordenadas)){
					j.mover(direccion);
					labelJugador.setIcon(j.getJugador().getIcon());
					labelJugador.setBounds(j.getJugador().x(),j.getJugador().y(),32,32);
					System.out.println(j.getJugador().x()+","+j.getJugador().y());
					frame.repaint();
				}
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
					System.out.println(pos2+","+pos1);
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
	private void initialize(int ancho,int largo) {
		frame = new JFrame();
		frame.setSize(largo*32,ancho*32);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected int movimiento(KeyEvent k){
		
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
		return direccion;
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	
}
