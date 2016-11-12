package Grafica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.KeyAdapter;

import Logica.Juego;

import javax.swing.*;

import Mapa.*;
import Obstaculos.Obstaculo;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI {

	private JFrame frame;
	private JPanel panelMapa,panelInicio,panelFinal;
	private JLabel labelPortada,lblMovimientoDeldiego,lblFlechas,lblEspacio,lblDisparo;
	private JButton btnEmpezar,btnVolver,btnTeclas;
	private Mapa mapa;
	private Juego juego;
	private AudioClip audioDisparo,audioMovimiento,audioAmbiente,audioInicio;
	protected List<JLabel> listaCantEnemigosQuedan;
	
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
	
	
	public GUI() {
		crearFrame(14,19);
		crearPanelInicio();
	}
	
	protected void crearPanelInicio(){
		panelInicio = new JPanel();
		panelInicio.setBackground(Color.BLACK);
		panelInicio.setBounds(0, 0,1106 , 728);
		panelInicio.setLayout(null);
		panelInicio.setFocusable(false);
		audioInicio=Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Intro.wav"));
		audioInicio.loop();
		panelDeInicio();
	}
	
	protected void panelDeInicio() {
		
		labelPortada = new JLabel();
		labelPortada.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/Portada.png")));
		labelPortada.setBounds(203, 142, 700, 300);
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
		btnEmpezar.setFont(new Font("Symtext", Font.PLAIN, 40));
		btnEmpezar.setBounds(202, 500, 286, 50);
		btnEmpezar.setBorderPainted(false);
		btnEmpezar.setContentAreaFilled(false);
		btnEmpezar.setOpaque(false);
		btnEmpezar.setFocusable(false);
		panelInicio.add(btnEmpezar);
		
		btnTeclas = new JButton("Teclas");
		btnTeclas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.removeAll();
				mostrarOpciones();
				frame.repaint();
			}
		});
		btnTeclas.setForeground(Color.WHITE);
		btnTeclas.setFont(new Font("Symtext", Font.PLAIN, 40));
		btnTeclas.setBounds(594, 504, 257, 42);
		btnTeclas.setBorderPainted(false);
		btnTeclas.setContentAreaFilled(false);
		btnTeclas.setOpaque(false);
		btnTeclas.setFocusable(false);
		panelInicio.add(btnTeclas);
		
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

	protected void iniciarComponentesJuego(){
		audioDisparo = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Patada_Futbol.wav"));
		audioMovimiento = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Cesped.wav"));
		audioAmbiente = Applet.newAudioClip(this.getClass().getResource("/Sonidos/Sonido_Ambiente.wav"));
		audioAmbiente.loop();
		mapa=new Mapa(14,19,"Mapa1.txt");
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
	

	protected void ponerObstaculos() {
		panelMapa = new PanelConFondo();
		panelMapa.setBounds(0,0,19*52,14*52);
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
				pos2+=52;
			}
			pos2=0;
			pos1+=52;
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
				if (direccion!=4){
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
			}

		});
		
		
		panelMapa.add(juego.getJugador().getEtiqueta());
		panelMapa.setFocusable(true);
		frame.getContentPane().add(panelMapa);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(987, 0, 119, 728);
		panelInfo.setLayout(null);
		int x1=panelInfo.getX()+20; int y1=panelInfo.getY()+10;
		boolean primeroDeFila=true;
		listaCantEnemigosQuedan = new LinkedList<JLabel>();
		for(int i=0;i<juego.getTotalEnemigos();i++){
			JLabel aux= new JLabel();
			aux.setBounds(x1,y1,32,32);
			ImageIcon icono= new ImageIcon(this.getClass().getResource("/imagenes/Camiseta.png"));
			aux.setIcon(new ImageIcon(icono.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
			listaCantEnemigosQuedan.add(aux);
			frame.getContentPane().add(aux);
			if(primeroDeFila){
				x1+=37;
				primeroDeFila=false;
			}
			else{
				x1-=37;
				y1+=37;
				primeroDeFila=true;
			}
		}
		frame.repaint();
	}
	
	protected void crearFrame(int ancho,int largo) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("Maradona Soccer SuperStar");
		
		frame.setSize(1122,767);
		
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

	public void pantallaPerder(int puntaje) {
		panelMapa.removeAll();
		frame.getContentPane().remove(panelMapa);
		frame.repaint();
		audioAmbiente.stop();
		panelFinal=new JPanel();
		panelFinal.setBounds(frame.getBounds());
		panelFinal.setBackground(Color.BLACK);
		panelFinal.setLayout(null);
		frame.getContentPane().add(panelFinal);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/Maradona_Pierde.png")));
		lblNewLabel.setBounds(560, 181, 435, 550);
		panelFinal.add(lblNewLabel);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setFont(new Font("Symtext", Font.PLAIN, 80));
		lblGameOver.setBounds(41, 135, 527, 79);
		panelFinal.add(lblGameOver);
		
		JLabel lblQuersVolverA = new JLabel("Quer\u00E9s volver a jugar?");
		lblQuersVolverA.setForeground(Color.WHITE);
		lblQuersVolverA.setFont(new Font("Symtext", Font.PLAIN, 35));
		lblQuersVolverA.setBounds(41, 616, 554, 37);
		panelFinal.add(lblQuersVolverA);
		
		JButton btnSi = new JButton("SI");
		btnSi.setForeground(Color.WHITE);
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panelFinal);
				frame.repaint();
				crearPanelInicio();
			}
		});
		btnSi.setFont(new Font("Symtext", Font.PLAIN, 25));
		btnSi.setBounds(109, 675, 89, 23);
		btnSi.setBorderPainted(false);
		btnSi.setContentAreaFilled(false);
		btnSi.setOpaque(false);
		btnSi.setFocusable(false);
		panelFinal.add(btnSi);
		
		JButton btnNo = new JButton("NO");
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Symtext", Font.PLAIN, 25));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNo.setBounds(422, 675, 89, 23);
		btnNo.setBorderPainted(false);
		btnNo.setContentAreaFilled(false);
		btnNo.setOpaque(false);
		btnNo.setFocusable(false);
		panelFinal.add(btnNo);
	}

	public void pantallaGanar(int puntaje) {
		panelMapa.removeAll();
		frame.getContentPane().remove(panelMapa);
		frame.repaint();
		audioAmbiente.stop();
		panelFinal=new JPanel();
		panelFinal.setBounds(frame.getBounds());
		panelFinal.setBackground(Color.BLACK);
		panelFinal.setLayout(null);
		frame.getContentPane().add(panelFinal);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/Maradona_Gana.png")));
		lblNewLabel_1.setBounds(491, 118, 504, 625);
		panelFinal.add(lblNewLabel_1);
		
		JLabel lblGanasteElNivel = new JLabel("Ganaste el nivel!");
		lblGanasteElNivel.setForeground(Color.WHITE);
		lblGanasteElNivel.setFont(new Font("Symtext", Font.PLAIN, 60));
		lblGanasteElNivel.setBounds(24, 49, 682, 67);
		panelFinal.add(lblGanasteElNivel);
		
		JLabel lblPuntaje = new JLabel("Puntaje: ");
		lblPuntaje.setFont(new Font("Symtext", Font.PLAIN, 40));
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(24, 176, 257, 38);
		panelFinal.add(lblPuntaje);
		
		JLabel label = new JLabel(""+puntaje);
		label.setForeground(Color.RED);
		label.setFont(new Font("Symtext", Font.PLAIN, 40));
		label.setBounds(277, 176, 174, 38);
		panelFinal.add(label);
		
		JLabel lblQuersVolverA = new JLabel("Quer\u00E9s volver a jugar?");
		lblQuersVolverA.setForeground(Color.WHITE);
		lblQuersVolverA.setFont(new Font("Symtext", Font.PLAIN, 35));
		lblQuersVolverA.setBounds(24, 388, 554, 37);
		panelFinal.add(lblQuersVolverA);
		
		JButton btnSi = new JButton("SI");
		btnSi.setForeground(Color.WHITE);
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panelFinal);
				frame.repaint();
				crearPanelInicio();
			}
		});
		btnSi.setFont(new Font("Symtext", Font.PLAIN, 25));
		btnSi.setBounds(63, 436, 89, 23);
		btnSi.setBorderPainted(false);
		btnSi.setContentAreaFilled(false);
		btnSi.setOpaque(false);
		btnSi.setFocusable(false);
		panelFinal.add(btnSi);
		
		JButton btnNo = new JButton("NO");
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Symtext", Font.PLAIN, 25));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNo.setBounds(362, 436, 89, 23);
		btnNo.setBorderPainted(false);
		btnNo.setContentAreaFilled(false);
		btnNo.setOpaque(false);
		btnNo.setFocusable(false);
		panelFinal.add(btnNo);
		
	}


	
	public void quitarEtiquetaDeLista() {
		frame.getContentPane().remove(listaCantEnemigosQuedan.get(listaCantEnemigosQuedan.size()-1));
		listaCantEnemigosQuedan.remove(listaCantEnemigosQuedan.size()-1);
	}
}
