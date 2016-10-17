package ObjetosDelJuego;

import java.awt.Rectangle;

import Obstaculos.Agua;
import Obstaculos.Base;
import Obstaculos.Borde;
import Obstaculos.Bosque;
import Obstaculos.Pared;
import Tanques.Disparo;
import Tanques.Enemigo;
import Tanques.Jugador;

public interface Visitor {
	public boolean colisionarPared(Pared p,Rectangle posNueva);
	public boolean colisionarEnemigo(Enemigo e,Rectangle posNueva);
	public boolean colisionarJugador(Jugador j,Rectangle posNueva);
	public boolean colisionarBosque(Bosque b,Rectangle posNueva);
	public boolean colisionarAgua(Agua a,Rectangle posNueva);
	public boolean colisionarBase(Base b,Rectangle posNueva);
	public boolean colisionarDisparo(Disparo d,Rectangle posNueva);
	public boolean colisionarBorde(Borde b,Rectangle posNueva);
}
