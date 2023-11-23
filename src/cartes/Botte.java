package cartes;
import java.util.List;
import java.util.Set;

import jeu.*;
public class Botte extends Probleme {

	public Botte(int nombre, Type t) {
		super(nombre, t);
	}
	public String toString()
	{
		
		switch(super.gettype())
		{
		case FEU:
			return "VEHICULE PRIORITAIRE";
		case ESSENCE:
			return "CITERNE D'ESSENCE";
		case CREVAISON:
			return "inCREVABLE";
		default:
			return "AS DU VOLANT";
		}
		
	}
	
	//si la carte est une botte, elle est ajoutée
	//aux bottes du joueur. Si elle répond à une attaque, l’attaque est supprimée.
	@Override
	 public boolean appliquer(Joueur j) {
        Set<Botte> bottes = j.getEnsBotte();
        if (bottes.contains(this)) {
            return false;
        }
        bottes.add(this);

        List<Carte> batailles = j.getpileBataille();
        Bataille sommet = (Bataille) batailles.get(0);

        if (sommet.gettype() == this.gettype()) {
            batailles.remove(0);
        }
        return true;
    }

}
