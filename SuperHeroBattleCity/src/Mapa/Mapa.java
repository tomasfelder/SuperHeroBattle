package Mapa;
import java.io.*;

import ObjetosDelJuego.*;

public class Mapa {
	
	//Atributos de instancia
	protected Object[][] matriz;
	protected String st="";
	
	//Constructor
	public Mapa(int x,int y,File archivo){
		matriz=new Object[x][y];
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br= new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null){
				st+=linea+"\n";
				linea=br.readLine();
			}
		}catch (IOException e){
				e.printStackTrace();
		}
		
	}
	
	public String muestraMapa(){
		return st;
	}
}
