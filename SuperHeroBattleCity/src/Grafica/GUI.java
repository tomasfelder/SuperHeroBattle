package Grafica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import Logica.Juego;

import javax.sound.sampled.Clip;
import javax.swing.*;


import Mapa.*;
import Obstaculos.Obstaculo;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI {

	private JFrame frame;
	private JPanel panelMapa,panelInicio;
	private JLabel labelPortada,lblMovimientoDeldiego,lblFlechas,lblEspacio,lblDisparo;
	private JButton btnEmpezar,btnVolver;
	private Mapa mapa;
	private Juego juego;
	private AudioClip audioDisparo,audioMovimiento,audioAmbiente,audioInicio;
	private JButton btnOpciones;
	
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
		crearFrame(14,15);
		panelInicio = new JPanel();
		panelInicio.setBackground(Color.BLACK);
		panelInicio.setBounds(frame.getBounds());
		panelInicio.setLayout(null);
		panelInicio.setFocusable(false);
		audioInicio=Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Intro.wav"));
		audioInicio.loop();
		panelDeInicio();
		
	}
	
	private void panelDeInicio() {
		
		labelPortada = new JLabel("New label");
		labelPortada.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/Portada.png")));
		labelPortada.setBounds(50, 50, 700, 300);
		panelInicio.add(labelPortada);
		
		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(panelInicio);
				frame.repaint();
				audioInicio.stop();
				iniciarComponentesJuego();
			}
		});
		btnEmpezar.setForeground(Color.WHITE);
		btnEmpezar.setFont(new Font("Symtext", Font.PLAIN, 30));
		btnEmpezar.setBounds(101, 449, 200, 50);
		btnEmpezar.setBorderPainted(false);
		btnEmpezar.setContentAreaFilled(false);
		btnEmpezar.setOpaque(false);
		btnEmpezar.setFocusable(false);
		panelInicio.add(btnEmpezar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.removeAll();
				mostrarOpciones();
				frame.repaint();
			}
		});
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setFont(new Font("Symtext", Font.PLAIN, 30));
		btnOpciones.setBounds(504, 458, 205, 33);
		btnOpciones.setBorderPainted(false);
		btnOpciones.setContentAreaFilled(false);
		btnOpciones.setOpaque(false);
		btnOpciones.setFocusable(false);
		panelInicio.add(btnOpciones);
		
		frame.getContentPane().add(panelInicio);
		
		
	}
	
	protected void mostrarOpciones() {
		
		lblMovimientoDeldiego = new JLabel("Movimiento del \"Diego\"");
		lblMovimientoDeldiego.setForeground(Color.WHITE);
		lblMovimientoDeldiego.setFont(new Font("Symtext", Font.PLAIN, 30));
		lblMovimientoDeldiego.setBounds(258, 119, 437, 45);
		panelInicio.add(lblMovimientoDeldiego);
		
		lblFlechas = new JLabel("");
		lblFlechas.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/Flechas_2.png")));
		lblFlechas.setBounds(70, 70, 156, 142);
		panelInicio.add(lblFlechas);
		
		lblEspacio = new JLabel("New label");
		lblEspacio.setBounds(54, 223, 219, 56);
		Image im=new ImageIcon(GUI.class.getResource("/imagenes/Barra_Espaciadora.png")).getImage().getScaledInstance(lblEspacio.getWidth(), lblEspacio.getHeight(), Image.SCALE_DEFAULT);
		lblEspacio.setIcon(new ImageIcon(im));
		panelInicio.add(lblEspacio);
		
		lblDisparo = new JLabel("Disparo");
		lblDisparo.setForeground(Color.WHITE);
		lblDisparo.setFont(new Font("Symtext", Font.PLAIN, 30));
		lblDisparo.setBounds(304, 229, 148, 45);
		panelInicio.add(lblDisparo);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.removeAll();
				frame.repaint();
				panelDeInicio();
			}
		});
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Symtext", Font.PLAIN, 30));
		btnVolver.setBounds(522, 449, 194, 45);
		panelInicio.add(btnVolver);
	}

	private void iniciarComponentesJuego(){
		audioDisparo = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Patada_Futbol.wav"));
		audioMovimiento = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Cesped.wav"));
		audioAmbiente = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Ambiente.wav"));
		audioAmbiente.loop();
		mapa=new Mapa(14,15,"Mapa1.txt");
		juego=new Juego(mapa,this);
		ponerObstaculos();
		juego.empezar();
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
		frame.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0){
				if (arg0.getKeyCode()==KeyEvent.VK_SPACE){
					if(juego.getJugador().getCantidadDisparos()!=0){
						audioDisparo.play();
						juego.disparar();
						frame.repaint();
					}
				}
				else{
				int direccion=movimiento(arg0);
				Rectangle coordenadas = juego.getJugador().simularMovimiento(direccion);
				System.out.println(juego.puedoMover(coordenadas,juego.getJugador()));
				if(juego.puedoMover(coordenadas,juego.getJugador())){
					audioMovimiento.play();
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
	private void crearFrame(int ancho,int largo) {
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
