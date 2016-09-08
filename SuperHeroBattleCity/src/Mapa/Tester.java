package Mapa;

import java.io.File;

public class Tester {

	public static void main(String[] args) {
		File archivo = new File("D:\\Documentos\\GitHub\\BattleCitySuperHero\\Mapa1.txt");
		Mapa m = new Mapa(13,14,archivo);
		System.out.println(m.muestraMapa());
	}

}
