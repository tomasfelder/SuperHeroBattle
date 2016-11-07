package ObjetosDelJuego;

import java.awt.Rectangle;
import PowerUps.*;

import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.ParedDeAcero;
import Obstaculos.ParedDeLadrillo;
import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.Jugador;

public interface Visitor {
	
	public boolean colisionarParedDeAcero(ParedDeAcero p,Rectangle posNueva);
	public boolean colisionarParedDeLadrillo(ParedDeLadrillo p,Rectangle posNueva);
	public boolean colisionarEnemigo(Enemigo e,Rectangle posNueva);
	public boolean colisionarJugador(Jugador j,Rectangle posNueva);
	public boolean colisionarBosque(Bosque b,Rectangle posNueva);
	public boolean colisionarAgua(Agua a,Rectangle posNueva);
	public boolean colisionarBase(Base b,Rectangle posNueva);
	public boolean colisionarDisparo(Disparo d,Rectangle posNueva);
	public boolean colisionarBorde(Borde b,Rectangle posNueva);
	
	//Visitor de powerUps
	public boolean colisionarPGranada(PGranada g,Rectangle posNueva);
	public boolean colisionarPCasco(PCasco c,Rectangle posNueva);
	public boolean colisionarPEstrella(PEstrella e,Rectangle posNueva);
	public boolean colisionarPPala(PPala p,Rectangle posNueva);
	public boolean colisionarPTanque(PTanque t,Rectangle posNueva);
	public boolean colisionarPTimer(PTimer t,Rectangle posNueva);
}
