package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;

import Logica.Juego;
import javax.swing.*;


import Mapa.*;
import Obstaculos.Obstaculo;
import Tanques.Disparo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JFrame frame;
	private JPanel panelMapa,panelBotones;
	private Mapa mapa;
	private Juego j;
	private JButton btnCrearEnemigo,btnEliminarEnemigo,btnCambiarNivel,btnDisparar;
	private Thread th;
	
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
		j=new Juego(mapa,this);
		initialize(12,13);
		ponerObstaculos();
		crearBotones();
	}
	
	public Juego getJuego(){
		return j;
	}
	
	public Rectangle getMapaBounds(){
		return panelMapa.getBounds();
	}
	
	private void crearBotones(){
		
			panelBotones = new JPanel();
			panelBotones.setBounds(426, 198, 156, 186);
			
			btnCrearEnemigo = new JButton("Crear Enemigo");
			btnCrearEnemigo.setFocusable(false);
			btnCrearEnemigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					j.crearEnemigo(64, 0);
					panelMapa.add(j.getEnemigo().getEtiqueta());
					btnCrearEnemigo.setEnabled(false);
					btnEliminarEnemigo.setEnabled(true);
					th = new Thread(j);
					th.start();
					frame.repaint();
				}
			});
			btnCrearEnemigo.setBounds(650, 495, 112, 23);
			panelBotones.add(btnCrearEnemigo);
			btnEliminarEnemigo = new JButton("Eliminar Enemigo");
			btnEliminarEnemigo.setFocusable(false);
			btnEliminarEnemigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					j.terminate();
					panelMapa.remove(j.getEnemigo().getEtiqueta());
					j.eliminarEnemigo();
					j.sumarPuntaje(100);
					btnCrearEnemigo.setEnabled(true);
					btnEliminarEnemigo.setEnabled(false);
					frame.repaint();
					JLabel labelPuntaje = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Puntaje_100.png")));
					labelPuntaje.setBounds(80, 16, 13, 7);
					panelMapa.add(labelPuntaje);
					frame.repaint();
				}
			});
			btnEliminarEnemigo.setEnabled(false);
			btnEliminarEnemigo.setBounds(650, 529, 112, 23);
			panelBotones.add(btnEliminarEnemigo);
			frame.getContentPane().add(panelBotones);
			
			JButton btnEliminarPared = new JButton("Eliminar pared");
			btnEliminarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Random rnd = new Random();
					int x=rnd.nextInt(12); int y= rnd.nextInt(13);
					System.out.println(x+","+y);
					Obstaculo aux = mapa.obtenerCelda(x, y);
					while(aux==null){
						x=rnd.nextInt(12); y= rnd.nextInt(13);
						System.out.println(x+","+y);
						aux = mapa.obtenerCelda(x, y);
					}
					panelMapa.remove(aux.getEtiqueta());
					mapa.eliminarCelda(x, y);
					frame.repaint();
				}
			});
			btnEliminarPared.setFocusable(false);
			panelBotones.add(btnEliminarPared);
			panelBotones.setFocusable(false);
			
			btnCambiarNivel = new JButton("Cambiar Nivel");
			btnCambiarNivel.setFocusable(false);
			btnCambiarNivel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					j.getJugador().setNivel(new Random().nextInt(4));
				}
			});
			panelBotones.add(btnCambiarNivel);
			
			btnDisparar = new JButton("Disparar");
			btnDisparar.setFocusable(false);
			btnDisparar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Disparo disp = j.getJugador().disparar();
					
				}
			});
			panelBotones.add(btnDisparar);
			frame.repaint();
	}

	private void ponerObstaculos() {
		panelMapa = new JPanel();
		panelMapa.setBackground(Color.BLACK);
		panelMapa.setBounds(0,0,416,384);
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
		panelMapa.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0){
				int direccion=movimiento(arg0);
				int[] coordenadas = j.getJugador().simularMovimiento(direccion);
				System.out.println(j.puedoMover(coordenadas));
				if(j.puedoMover(coordenadas)){
					j.mover(direccion);
//					labelJugador.setIcon(j.getJugador().getIcon());
//					labelJugador.setBounds(j.getJugador().x(),j.getJugador().y(),32,32);
					System.out.println(j.getJugador().x()+","+j.getJugador().y());
					frame.repaint();
				}
			}

		});
//		panelMapa.add(labelJugador);
		panelMapa.add(j.getJugador().getEtiqueta());
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
