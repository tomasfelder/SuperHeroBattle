package Mapa;
import java.io.*;

import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.Obstaculo;
import Obstaculos.ParedDeAcero;
import Obstaculos.ParedDeLadrillo;

public class Mapa {
	
	//Atributos de instancia
	protected Obstaculo[][] matriz;
	protected String linea;
	protected BufferedReader br;
	
	//Constructor
	public Mapa(int x,int y,String archivo){
		matriz=new Obstaculo[x][y];
		try {
			br= new BufferedReader(new FileReader(archivo));
			int nroLinea=0;
			 while ((linea = br.readLine()) != null) {
				 	int j=0;
	            	for(int i = 0; i < linea.length(); i++){
	            		char letra = linea.charAt(i);
	            		switch (letra) {
	            		case 'x' :
	            			matriz[nroLinea][j]=null;
	            			j++;
	            			break;
	            		case 'p' :
	            			matriz[nroLinea][j]=new ParedDeLadrillo();
	            			j++;
	            			break;
	            		case 'z' :
	            			matriz[nroLinea][j]=new ParedDeAcero();
	            			j++;
	            			break;
	            		case 'b' :
	            			matriz[nroLinea][j]=new Base();
	            			j++;
	            			break;
	            		case 'a' :
	            			matriz[nroLinea][j]=new Agua();
	            			j++;
	            			break;
	            		case 'B' :
	            			matriz[nroLinea][j]=new Bosque();
	            			j++;
	            			break;
	            		case 'N' :
	            			matriz[nroLinea][j]=new Borde();
	            			j++;
	            			break;
	            		case ' ' :
	            			break;
	            		}
	            	}
	            	nroLinea++;
			 }
		}catch (IOException e){
				e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getAncho(){
		return matriz[0].length;
	}
	
	public int getLargo(){
		return matriz.length;
	}
	
	public Obstaculo obtenerCelda(int x, int y){
		return matriz[x][y];
	}
	
	public void eliminarCelda(int x,int y){
		matriz[x][y]=null;
	}
	
}
