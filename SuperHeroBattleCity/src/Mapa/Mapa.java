package Mapa;
import java.io.*;

import ObjetosDelJuego.*;

public class Mapa {
	
	//Atributos de instancia
	protected gameObject[][] matriz;
	protected String linea;
	protected BufferedReader br;
	
	//Constructor
	public Mapa(int x,int y,String archivo){
		matriz=new gameObject[x][y];
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
	            		case 'P' :
	            			matriz[nroLinea][i]=new ParedDeAcero();
	            			j++;
	            			break;
	            		case ' ' :
	            			break;
	            		}
	            	}
	            	System.out.println();
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
	
	public gameObject obtenerCelda(int x, int y){
		return matriz[x][y];
	}
	
}
