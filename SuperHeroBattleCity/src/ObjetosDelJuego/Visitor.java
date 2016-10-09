package ObjetosDelJuego;

public interface Visitor {
	public boolean colisionar(Pared p);
	public boolean colisionar(Enemigo e);
	public boolean colisionar(Bosque b);
	public boolean colisionar(Agua a);
	public boolean colisionar(Base b);
	public boolean colisionar(Disparo d);
}
