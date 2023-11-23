package jeu;

import cartes.*;
public class Coup {
	private Carte carte;
	private Joueur cible;//cible -->oeut etre null
	
	public Coup(Joueur joueur_cible, Carte c) {
		this.carte=c;
		this.cible=joueur_cible;
	}
	 
	public Joueur getJoueur()
	{
		return cible;
	}
	
	public Carte getCarte()
	{
		return carte;
	}
	
	  public void setCarte(Carte carte) {
	        this.carte = carte;
	    }

	  public void setJoueurcible(Joueur cible) {
	        this.cible = cible;
	    }

	
	
	public boolean estValide(Joueur j) {
	    if (carte instanceof Attaque || carte instanceof DebutLimite) {///
	        return j != null && !j.equals(cible);
	    }
	    return true;
	}
	 @Override
	public boolean equals(Object ob)
	{
		if(ob instanceof Coup)
		{
			Coup c= (Coup) ob;
			return this.cible.equals(c.getJoueur())&& this.carte.equals(c.getCarte());
		}
		return false;
	}
	 @Override
	public int hashCode()
	{
		return 67*(cible.hashCode()+carte.hashCode());
	}
	 
	 
	 
	 
	 

	  public boolean jouer(Joueur joueur) {
	        joueur.getMain().jouer(carte);
	        if (cible == null) {
	            joueur.getJeu().getSabot().ajouterCarte(carte);
	            System.out.println("Le joueur " + joueur + " respose la " + carte);
	            return true;
	        } else {
	            if (carte.appliquer(cible)) {
	                System.out.println("Le joueur " + joueur + " et le  " + joueur + " et : " + carte);
	                return true;
	            }
	            return false;
	        }
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
