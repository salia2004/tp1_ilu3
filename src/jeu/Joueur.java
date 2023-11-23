package jeu;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cartes.*;

import cartes.Probleme.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Joueur  {
	
	private String nom;
	
	private List<Limite> pileLimitesVitesse;
	private List<Carte> pileBataille;
	private Collection<Borne> collectionBornes;
	private Set<Botte> ensembleBottes;
	
	private MainAsListe main_joueur;//main du joueur 
	Jeu jeu;
	
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
	
	public Jeu getJeu() {
		return jeu;
	}
	

	
	
	
	
	
	
	
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
	public boolean estPrioritaire() {
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
		 
		if(pileBataille.isEmpty()&& estPrioritaire()){
			return false;}
		
		Parade p= new Parade(0, Type.FEU);//parade de type Feu_vert
		Attaque a=new Attaque(50, Type.FEU);///Feu_rouge
		Carte sommetPile = pileBataille.get(pileBataille.size() - 1);
		if (sommetPile.equals(p)){
				return false;}
			
		if (estPrioritaire()) 
		{
				if(estParade(sommetPile)){
					//System.out.println("12");
					return false;}
				if( sommetPile.equals(a)){
					//System.out.println("13");
					return false;}
				if(estAttaque(sommetPile)&&sommetaBottes(sommetPile)){
					return false;	}
		}
		return true;}
	
	
	
	private boolean estParade(Carte c)
		{
			return c instanceof Parade;}
				
	
	private boolean estAttaque(Carte c)
	{
		return c instanceof Attaque ;}
	private boolean sommetaBottes(Carte sommetPile)
	{
		String t=sommetPile.toString();
		switch(t)
		{
		case  "ACCIDENT":
			return test(new Botte(50, Type.ACCIDENT));
		case "CREVAISON":
			return test(new Botte(50, Type.CREVAISON));
		default:
			return test(new Botte(50, Type.ESSENCE));
		}
		
	}
	
	private boolean test(Botte b)
	{
		for(Botte c:ensembleBottes)
	    {
	    	if(c.equals(b))
	    	{
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public Set<Coup> coupsPossibles(List<Joueur> participant){
		Set<Coup> listcoups= new HashSet<>();
		for(Joueur j: participant){
			for(Carte c: pileBataille){
				Coup cp= new Coup(j,c);
				if(cp.estValide(this)){
					listcoups.add(cp);}
			}
		}
		return listcoups;}
	
	
	
	 public Set<Coup>  coupsParDefaut(){
		 Set<Coup> list= new HashSet<>();
		 for(Carte c: pileBataille){
				Coup cp= new Coup(null,c);
				if(cp.estValide(this)){
					list.add(cp);
				}
			}
		 return list;
	 }
	 public Object getBornes() {
			// TODO Auto-generated method stub
			return collectionBornes;
		}


	
	 public Coup selectionner() {
	        Set<Coup> ensemble = coupsPossibles(jeu.getJoueurs());
	        if (ensemble.isEmpty()) {
	            return null;
	        }
	        Iterator<Coup> it = ensemble.iterator();
	        Coup coup = it.next();
	        coup.jouer(this);
	        return coup;
	    }

	 public Coup rendreCarte() {
	        Set<Coup> ensemble = coupsParDefaut();
	        if (ensemble.isEmpty()) {
	            return null;
	        }
	        Iterator<Coup> it = ensemble.iterator();
	        Coup coup = it.next();
	        coup.jouer(this);
	        return coup;
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
}

