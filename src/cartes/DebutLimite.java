package cartes;

import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return "Debut Limite";
		
	}
	////si la carte est une limitation de vitesse : si le joueur n’a pas
	///la botte prioritaire et n’a pas déjà une limite de vitesse, la carte est ajoutée.
	@Override
    public boolean appliquer(Joueur j) {
        return false;
	}
}
