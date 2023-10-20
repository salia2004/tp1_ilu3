package jeu;

import java.util.List;
import java.util.Set;

import cartes.Botte;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Probleme.Type;

import java.util.Collection;

public class Joueur  {
	
	private String nom;
	
	private List<Limite> pileLimitesVitesse;
	private List<Carte> pileBataille;
	private Collection<Borne> collectionBornes;
	private Set<Botte> ensembleBottes;
	private Main m;//main du joueur 
	
	
	public Joueur(String n)
	{
		this.nom=n;
	}
	
	
	/////debut getter 
	public String getNom()
	{
		return this.nom;
	}
	public List<Carte> getpileBataille() {
        return pileBataille;
    }

	public Collection<Borne> getCollectionBorne(){
		return this.collectionBornes;
	}
	
	public Set<Botte> getEnsBotte()
	{
		return this.ensembleBottes;
	}
	
	public List<Limite> getLimiteV()
	{
		return this.pileLimitesVitesse;
	}
	
	public Main getMai()
	{
		return this.m;
	}
	///fin getter 
	
	@Override
	public boolean equals(Object ob)
	{
		if(ob instanceof Joueur)
		{
			return this.getClass()==ob.getClass();
		}
		return false;
	}
	
	//methode tostring
	public String toString()
	{
		return nom;
	}
	
	
	
	public void donner(Carte c)
	{
		m.prendre(c);
	}
	
	public Carte PrendreCarte(List<Carte> sabot)
	{
		if (sabot.isEmpty())
		{
			return null;
		}
		Carte c=sabot.get(0);
		sabot.remove(0);
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
		Carte last=pileLimitesVitesse.get(pileLimitesVitesse.size());
		FinLimite k=new FinLimite(6);
		Botte i=new Botte(1, Type.FEU);
		if(pileLimitesVitesse.isEmpty() || (last.equals(k)) || ensembleBottes.contains(i)) 
		{
			return 200;}
		return 50;
	}
	
	public boolean estBloque()
	{
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
