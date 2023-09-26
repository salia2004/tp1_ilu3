package jeu;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private int nbCartes;
	private Carte[] pioche;
	private int indiceiter=0;
	
	public Sabot(int capacite)
	{
		this.pioche=new Carte[capacite];
		this.nbCartes=0;
		
	}
	
	public boolean estVide()
	{
		return pioche.length==0;
	}
	
	public void ajouterCarte(Carte c) 
	{
		if (this.nbCartes>pioche.length)
		{
			 throw new ArrayIndexOutOfBoundsException("Capacité atteinte");
		}
		else
		{
			pioche[nbCartes]=c;
			nbCartes++;}}
	
	 public void ajouterFamilleCarte(Carte c, int nb )
	 {
		 for(int i=0;i<nb;i++)
		 {
			 ajouterCarte(c);
		 }
	 }
	
	public void ajouterFamilleCarte(Carte...cartes)
	{
		for(Carte c:cartes)
		{
			pioche[nbCartes++]=c;
		}
	}

	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return new Iterateur();
	}
	
	///////////////////////
	////////////CLASSE INTERNE
	private class Iterateur implements Iterator<Carte>
	{
		private boolean nextEffectue = false;
		
		
		/////////////
		/////HASNEXT
		public boolean hasNext()
		{
			return indiceiter<pioche.length;
			}
		
		///////////
		//////NEXT
		public Carte next()
		{
			if (hasNext()){
				Carte carte=pioche[indiceiter];
				nextEffectue=true;
				indiceiter++;
				return carte;}
			else{
				throw new NoSuchElementException();}
			}
		
		/////////////////////
		///////////REMOVE
		public void remove()
		{
			if (pioche.length < 1 || !nextEffectue) { throw new IllegalStateException(); }
			else {
				for(int i=indiceiter-1;i<nbCartes;i++)
				{
					pioche[i]=pioche[i+1];////on decale 
				}	
			}
			nextEffectue = false;
			indiceiter--;
			nbCartes--;	
		}
	}
	////////fin classe interne 
	///////////////////
	
	public Carte piocher()
	{
		Iterator<Carte> c =iterator();
		Carte car=iterator().next();
		c.remove();
		return car;
	}
	
	
	
	
	
}
