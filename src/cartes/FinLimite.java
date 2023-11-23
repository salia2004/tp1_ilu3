package cartes;
import java.util.List;

import jeu.*;
public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString()
	{
		return "Fin Limite";
		
	}
	//si la carte est une fin de limite de vitesse : si le 
	//joueur n’a pas de botte prioritaire et a une vitesse limitée, la carte est ajoutée.
	
	@Override
	 public boolean appliquer(Joueur j) {
	        List<Limite> limites = j.getLimiteV();


	        if (limites.isEmpty() && !limites.get(0).equals(this)&&  j.estPrioritaire()) {
	            return false;
	        }

	        limites.add(0,this);
	        return true;
	    }

}
