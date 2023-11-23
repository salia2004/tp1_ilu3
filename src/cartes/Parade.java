package cartes;

import java.util.List;

import jeu.*;

public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		
		switch(super.gettype())
		{
		case FEU:
			return "FEU VERT";
		case ESSENCE:
			return "ESSENCE";
		case CREVAISON:
			return "ROUE DE SECOURS";
		case ACCIDENT:
			return "REPARATION";
		default:
			return "FIN DE LIMITE DE VITESSE";
		}
		
	}

	@Override
	 public boolean appliquer(Joueur j) {
        List<Carte> batailles = j.getpileBataille();


        if (batailles.isEmpty()) {
            if (this.gettype() == Type.FEU) {
                batailles.add(0,this);
                return true;}
            return false;}
        if (((Bataille) batailles.get(0)).gettype() == this.gettype() && batailles.get(0) instanceof Attaque) {
            batailles.add(0, this);
            return true;}

        return false;

    }
 
}

