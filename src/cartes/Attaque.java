package cartes;

import java.util.List;
import java.util.Set;

import jeu.*;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
	}
	
	
	public String toString()
	{
		Type x= super.gettype();//x est null pourquoi ?
		switch(x)
		{
		case FEU:
			return "FEU ROUGE";
		case ESSENCE:
			return "PANNE D'ESSENCE";
		case CREVAISON:
			return "CREVAISON";
		case ACCIDENT:
			return "ACCIDENT";
		default:
			return "LIMITE DE VITESSE";
		}
		
	}
	@Override
	public boolean appliquer(Joueur j) {
        List<Carte> batailles = j.getpileBataille();
        Set<Botte> bottes = j.getEnsBotte();

        if (bottes.contains(new Botte(1, this.gettype()))) {
            return false;
        }

        if ((batailles.isEmpty() && !j.estPrioritaire()) || batailles.get(0) instanceof Attaque) {
            return false;
        }
        batailles.add(0, this);
        return true;

    }


	
	
	
	
	
	
	
	
	
	
	
	
}
