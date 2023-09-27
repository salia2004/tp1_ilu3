package testsfonctionnels;
import cartes.Carte;
import jeu.Sabot;
import cartes.Probleme;
import cartes.Probleme.Type;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;


public class Test {

	private static final Type ACCIDENT = null;

	public static void main(String[] args) {
		Carte c=new Attaque(50, ACCIDENT);
		Carte c1=new Parade(50,ACCIDENT);
		Carte c2= new Botte(50,ACCIDENT);
		Sabot s=new Sabot(110);
		s.ajouterCarte(c);
		s.ajouterCarte(c1);
		System.out.println("Est ce que le tableau est vide ?:");
		s.estVide();
		System.out.println("/n");
		s.ajouterFamilleCarte(c1, 3);
		s.ajouterFamilleCarte(c,c,c );
		s.ajouterCarte(c2);
		///Carte res=s.piocher();
		////ajout test 
	
	}

}
