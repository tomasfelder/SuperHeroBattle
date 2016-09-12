package Mapa;
import java.io.*;

import ObjetosDelJuego.*;

public class Mapa {
	
	//Atributos de instancia
	protected gameObject[][] matriz;
	protected String linea;
	BufferedReader br;
	
	//Constructor
	public Mapa(int x,int y,File archivo){
		matriz=new gameObject[x][y];
		try {
			br= new BufferedReader(new FileReader(archivo));
			int j=0;
			 while ((linea = br.readLine()) != null) {
	            	for(int i = 0; i < linea.length(); i++){
	            		char letra = linea.charAt(i);
	            		switch (letra) {
	            		case 'x' :
	            			matriz[i][j]=null;
	            			break;
	            		case 'p' :
	            			matriz[i][j]=new ParedDeLadrillo();
	            			break;
	            		case 'P' :
	            			matriz[i][j]=new ParedDeAcero();
	            			break;
	            		}
	            	}
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
	
	public gameObject obtenerCelda(int x, int y){
		return matriz[x][y];
	}
	
}
