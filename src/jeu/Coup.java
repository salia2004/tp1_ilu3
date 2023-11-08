package jeu;

import cartes.*;
public class Coup {
	private Carte carte;
	private Joueur j;//cible -->oeut etre null
	
	public Coup(Joueur j, Carte c) {
		this.carte=c;
		this.j=j;
	}
	 
	public Joueur getJoueur()
	{
		return j;
	}
	
	public Carte getCarte()
	{
		return carte;
	}
	
	public boolean estValide(Joueur j)///a revoir 
	{
		if ((this.carte instanceof Attaque)||(this.carte instanceof Limite))
		{
			return false;
		}
		return true;
	}
	
	public boolean equals(Object ob)
	{
		if(ob instanceof Coup)
		{
			Coup c= (Coup) ob;
			return this.j.equals(c.getJoueur())&& this.carte.equals(c.getCarte());
		}
		return false;
	}
	public int hashCode()
	{
		return 67*(j.hashCode()+carte.hashCode());
	}
}
