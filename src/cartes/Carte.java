package cartes;
import jeu.*;
public abstract class Carte {
	private int nombre;
	
	
	protected  Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	public boolean equals(Object ob)
	{
		if(ob instanceof Carte)
		{
			return this.getClass()==ob.getClass();
		}
		return false;
	}
	
	public boolean appliquer(Joueur j) {
		return false;
	}
	
	
}
