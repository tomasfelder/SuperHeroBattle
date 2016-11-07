package Grafica;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import Logica.Juego;
import javax.swing.*;


import Mapa.*;
import Obstaculos.Obstaculo;


public class GUI {

	private JFrame frame;
	private JPanel panelMapa;
	private Mapa mapa;
	private Juego juego;
	
	
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
		mapa=new Mapa(14,15,"Mapa1.txt");
		juego=new Juego(mapa,this);
		initialize(14,15);
		ponerObstaculos();
	}
	
	public JPanel getPanelMapa(){
		return panelMapa;
	}
	
	public void repintar(){
		frame.repaint();
	}
	

	private void ponerObstaculos() {
		panelMapa = new PanelConFondo();
		panelMapa.setBounds(0,0,480,448);
		panelMapa.setLayout(null);
		int pos1,pos2;
		pos1=pos2=0;
		for(int i=0;i<mapa.getLargo();i++){
			for(int j=0;j<mapa.getAncho();j++){
				if(mapa.obtenerCelda(i, j)!=null){
					Obstaculo aux=mapa.obtenerCelda(i, j);
					aux.setX(pos2); aux.setY(pos1);
					System.out.println(pos2+","+pos1);
					panelMapa.add(aux.getEtiqueta());
				}
				pos2+=32;
			}
			pos2=0;
			pos1+=32;
		}
		mapa.getBase().setJuego(juego);
		panelMapa.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0){
				if (arg0.getKeyCode()==KeyEvent.VK_SPACE){
					if(juego.getJugador().getCantidadDisparos()!=0){
						juego.disparar();
						frame.repaint();
					}
				}
				else{
				int direccion=movimiento(arg0);
				Rectangle coordenadas = juego.getJugador().simularMovimiento(direccion);
				System.out.println(juego.puedoMover(coordenadas,juego.getJugador()));
				if(juego.puedoMover(coordenadas,juego.getJugador())){
					juego.mover(direccion);
					System.out.println(juego.getJugador().x()+","+juego.getJugador().y());
					frame.repaint();
					}
				}
			}

		});
		
		
		panelMapa.add(juego.getJugador().getEtiqueta());
		panelMapa.setFocusable(true);
		frame.getContentPane().add(panelMapa);
		frame.repaint();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int ancho,int largo) {
		frame = new JFrame();
		
		frame.setSize(800,600);
		
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
