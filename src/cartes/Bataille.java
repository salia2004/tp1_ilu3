package cartes;
import jeu.*;
public abstract class Bataille extends Probleme {

	protected Bataille(int nombre, Type t) {
		super(nombre, t);
	}
	
	@Override
    public boolean appliquer(Joueur j) {
		Carte c=j.getpileBataille().get(j.getpileBataille().size());//sommet pile 
        return false;
	}

}
