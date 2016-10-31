package PowerUps;

import java.awt.Rectangle;

import ObjetosDelJuego.Visitor;

public class SubeNivel extends PowerUp {

	public SubeNivel(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean aceptar(Visitor v, Rectangle nuevaPos) {
		return false;
	}

}
