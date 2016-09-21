package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;

import Logica.Juego;
import javax.swing.*;


import Mapa.*;
import ObjetosDelJuego.gameObject;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JPanel panelMapa,panelBotones;
	private Mapa mapa;
	private Juego j;
	private JLabel labelJugador, labelEnemigo;
	private JButton btnCrearEnemigo;
	private JButton btnEliminarEnemigo;
	
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
		j=new Juego(mapa);
		initialize(12,13);
		crearBotones();
		iniciarJugador();
		ponerObstaculos();
	}
	
	private void crearBotones(){
		
			panelBotones = new JPanel();
			panelBotones.setBounds(438, 291, 135, 93);
			
			btnCrearEnemigo = new JButton("Crear Enemigo");
			btnCrearEnemigo.setFocusable(false);
			btnCrearEnemigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelEnemigo=new JLabel();
					j.crearEnemigo(64, 0);
					labelEnemigo.setIcon(j.getEnemigo().getIcon());
					labelEnemigo.setBounds(j.getEnemigo().x(), j.getEnemigo().y(), 32, 32);
					panelMapa.add(labelEnemigo);
					btnCrearEnemigo.setEnabled(false);
					btnEliminarEnemigo.setEnabled(true);
					frame.repaint();
				}
			});
			btnCrearEnemigo.setBounds(650, 495, 112, 23);
			panelBotones.add(btnCrearEnemigo);
			btnEliminarEnemigo = new JButton("Eliminar Enemigo");
			btnEliminarEnemigo.setFocusable(false);
			btnEliminarEnemigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					j.eliminarEnemigo();
					labelEnemigo.setIcon(null);
					btnCrearEnemigo.setEnabled(true);
					btnEliminarEnemigo.setEnabled(false);
					frame.repaint();
				}
			});
			btnEliminarEnemigo.setEnabled(false);
			btnEliminarEnemigo.setBounds(650, 529, 112, 23);
			panelBotones.add(btnEliminarEnemigo);
			frame.getContentPane().add(panelBotones);
			
			JButton btnEliminarPared = new JButton("Eliminar pared");
			btnEliminarPared.setFocusable(false);
			panelBotones.add(btnEliminarPared);
			panelBotones.setFocusable(false);
			frame.repaint();
	}
	
	private void iniciarJugador(){
		
		labelJugador=new JLabel();
		labelJugador.setIcon(j.getJugador().getIcon());
		labelJugador.setBounds(j.getJugador().x(), j.getJugador().y(), 32, 32);
		frame.getContentPane().add(labelJugador);
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
					gameObject aux=mapa.obtenerCelda(i, j);
					aux.setX(pos2); aux.setY(pos1);
					System.out.println(pos2+","+pos1);
					JLabel etiqueta = new JLabel(aux.getIcon());
					etiqueta.setBounds(pos2, pos1, 32, 32);
					panelMapa.add(etiqueta);
				}
				else{
					/*JLabel etiqueta = new JLabel();
					etiqueta.setBackground(Color.BLACK);
					etiqueta.setOpaque(true);
					etiqueta.setBounds(pos2, pos1, 32, 32);
					frame.getContentPane().add(etiqueta);
					*/
				}
				pos2+=32;
			}
			pos2=0;
			pos1+=32;
		}
		panelMapa.addKeyListener(new KeyAdapter() {
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
