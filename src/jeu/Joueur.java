package jeu;

import java.util.List;
import java.util.Set;

import cartes.*;

import cartes.Probleme.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Joueur  {
	
	private String nom;
	
	private List<Limite> pileLimitesVitesse;
	private List<Carte> pileBataille;
	private Collection<Borne> collectionBornes;
	private Set<Botte> ensembleBottes;
	
	private MainAsListe main_joueur;//main du joueur 
	
	
	public Joueur(String n)
	{
		this.nom=n;
		this.main_joueur=new MainAsListe();
		this.pileLimitesVitesse= new ArrayList<>();
		this.pileBataille= new ArrayList<>();
		this.collectionBornes= new ArrayList<>();
		this.ensembleBottes= new HashSet<>();
		
	}
	
	
	/////debut getter 
	public String getNom()
	{
		return nom;
	}
	public List<Carte> getpileBataille() {
        return pileBataille;
    }

	public Collection<Borne> getCollectionBorne(){
		return collectionBornes;
	}
	
	public Set<Botte> getEnsBotte()
	{
		return ensembleBottes;
	}
	
	public List<Limite> getLimiteV()
	{
		return pileLimitesVitesse;
	}
	
	public MainAsListe getMain()
	{
		return main_joueur;
	}
	///fin getter 
	
	@Override
	public boolean equals(Object ob)
	{
		if(ob instanceof Joueur)
		{
			Joueur j=(Joueur) ob;
			return this.getClass()==ob.getClass()&& nom.equals(j.getNom());////peut etre ajoute run comparateur su rle nom 
		}
		return false;
	}
	
	//methode tostring
	public String toString()
	{
		return nom;
	}
	
	
	
	public void donner(Carte carte)
	{
		main_joueur.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot)
	{
		if (sabot.isEmpty())
		{
			return null;
		}
		Carte c=sabot.get(0);
		sabot.remove(0);
		main_joueur.prendre(c);//carte donner au joueru-> mise dans la mian
		return c; 
	}
	
	
	public int getKM()
	{
		int k=0;
		for(Borne c:collectionBornes )
		{
			k+=c.getKilo();
		}
		return k;
	}
	
	
	public int getLimite()
	{
		//System.out.println(pileLimitesVitesse.size());
		if(pileLimitesVitesse.isEmpty())
		{
			//System.out.println("cas pile vide");
			return 200;
		}
		Carte last=pileLimitesVitesse.get((pileLimitesVitesse.size())-1);
		FinLimite k=new FinLimite(0);
		Botte botteFeu=new Botte(0, Type.FEU);
		if((last.equals(k)) || ensembleBottes.contains(botteFeu)) 
		{
			System.out.println("cas autre");
			return 200; 
			}
		return 50;
	}
	
	// Méthode pour vérifier si le joueur est prioritaire
	private boolean estPrioritaire() {
	    Botte bottePrioritaire = new Botte(50, Type.FEU);
	    for(Botte c:ensembleBottes)
	    {
	    	if(c.equals(bottePrioritaire))
	    	{
	    		return true;
	    	}
	    }
	    return false;
	}

	public boolean estBloque()//renvoi tur si le joeur ne peut pas avancer
	{
		if(pileBataille.isEmpty()&& estPrioritaire())
		{
			return false;
		}
		Parade p= new Parade(0, Type.FEU);
		Attaque a=new Attaque(50, Type.FEU);
		System.out.println(estPrioritaire());
		Carte sommetPile = pileBataille.get(pileBataille.size() - 1); //on recupere le sommet 
		if (sommetPile.equals(p))
		{
			return false;
		}
		if(estParade(sommetPile) && estPrioritaire())///parade de type feu
		{
			return false;
		}
		if( estPrioritaire() && sommetPile.equals(a))
		{
			return false;
		}
		if ( estPrioritaire()&& estAttaque(sommetPile))
		{
			return false;
		}
			
		return true;
	}
	
		private boolean estParade(Carte c)
		{
			Parade c1=new Parade(89,Type.CREVAISON);
			Parade c2=new Parade(89,Type.ESSENCE);
			Parade c3=new Parade(89,Type.FEU);
			Parade c4=new Parade(89,Type.ACCIDENT);
			return c.equals(c1)||c.equals(c2)||c.equals(c3)||c.equals(c4);
		}
				
	
	private boolean estAttaque(Carte c)
	{
		Attaque c1=new Attaque(50,Type.ACCIDENT);
		Attaque c2=new Attaque(50,Type.ESSENCE);
		Attaque c3=new Attaque(50,Type.CREVAISON);
		return c.equals(c1)||c.equals(c2)||c.equals(c3);
	}
	
	
	
}

