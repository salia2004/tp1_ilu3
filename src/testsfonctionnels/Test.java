package testsfonctionnels;
import cartes.Carte;
import jeu.Sabot;
import cartes.Probleme;
import cartes.Probleme.Type;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;


public class Test {


	public static void main(String[] args) {
		
		Carte c=new Attaque(50, Type.ACCIDENT);
		Carte c1=new Parade(50,Type.ACCIDENT);
		Carte c2= new Botte(50,Type.ACCIDENT);
		
		Sabot s=new Sabot(110);
		
		s.ajouterCarte(c);
		s.ajouterCarte(c1);
		
		s.ajouterFamilleCarte(c1, 3);
		
		s.ajouterFamilleCarte(c,c,c );		
		s.ajouterCarte(c2);
		
	//	while (s.nbcarte()!=0)
	//	{
	//		s.piocher();
	//	}
		
		while (s.nbcarte()!=0)
		{
			Iterator<Carte> iter1 =s.iterator();
			iter1.hasNext();
			iter1.next();
			s.ajouterCarte(c2);
			iter1.remove();

		}
		
	
	}

}
