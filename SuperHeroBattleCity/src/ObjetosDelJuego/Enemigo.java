package ObjetosDelJuego;
import java.util.Random;

public abstract class Enemigo extends Tanque implements Runnable{
	
	protected int puntosQueDa;
	protected volatile boolean ejecutar;
	
	public Enemigo(int x, int y) {
		super(x, y);
	}
	
	public int getPuntos(){
		return puntosQueDa;
	}
	
	public void terminate(){
		ejecutar=false;
	}
	
	public void run(){
		ejecutar=true;
		while(ejecutar){
			try{
				int dir= new Random().nextInt(4);
				int[] mov= simularMovimiento(dir);
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				
			}
		}
	}
	
	public int[] simularMovimiento(int direccion){
		int coord[] = new int[2];
		switch (direccion){
		case 0:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y-velocidadMovimiento;
			break;
		case 1:
			coord[0]=coordenadas.x; coord[1]=coordenadas.y+velocidadMovimiento;
			break;
		case 2:
			coord[0]=coordenadas.x-velocidadMovimiento; coord[1]=coordenadas.y;
			break;
		case 3:
			coord[0]=coordenadas.x+velocidadMovimiento; coord[1]=coordenadas.y;
			break;
		}
		return coord;
	}
	
	public void mover(int direccion){
		
		switch (direccion){
		case 0:
			this.moverArriba();
			break;
		case 1:
			this.moverAbajo();
			break;
		case 2:
			this.moverIzquierda();
			break;
		case 3:
			this.moverDerecha();
			break;
		}
		
		imagen=iconos[direccion];
		
	}	
	
	private void moverDerecha(){
		
		coordenadas.x=coordenadas.x+velocidadMovimiento;
		
	}
	private void moverIzquierda(){
		
		coordenadas.x=coordenadas.x-velocidadMovimiento;
	}
	private void moverArriba(){
		
		coordenadas.y=coordenadas.y-velocidadMovimiento;
		
	}
	private void moverAbajo(){
		
		coordenadas.y=coordenadas.y+velocidadMovimiento;
		
	}
	
}
