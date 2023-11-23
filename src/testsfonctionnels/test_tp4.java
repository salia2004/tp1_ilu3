package testsfonctionnels;
import jeu.*;
import cartes.*;
import cartes.Probleme.Type;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;


public class test_tp4 {
	
	
	public static void main(String[] args) {
		
		
	
		//instanciation de sjoueur
	    Joueur joueur1 = new Joueur("Joueur 1");
	    Joueur joueur2 = new Joueur("Joueur 2");
	    List<Joueur> participant= new ArrayList<>();
	    participant.add(joueur2);
	    participant.add(joueur1);

	    
        System.out.println("les COUSP POSSIBLES SONT:"+joueur1.coupsPossibles(participant));
        
        
        // TEST QUESTION 2
        System.out.println("\n TEST appliquer:");
        
        Joueur j = new Joueur("J");
        Carte c111 = new Parade(0,Probleme.Type.FEU);
        Limite limite = new DebutLimite(1);
        Borne borne = new Borne(5,100);
        Botte botte = new Botte(1,Type.FEU);
        Carte parade = new Parade(3,Type.ACCIDENT);
        Carte carte4 = new Parade(0,Type.ESSENCE);
        //Coup coup1= new Coup(ccc,j);
        Joueur joueur = new Joueur("Joueur");
        Carte carte1 = new Parade(0,Type.FEU);
        System.out.println("appliquer "+carte1+":"+carte1.appliquer(joueur));
        System.out.println("appliquer "+carte1+":"+carte1.appliquer(joueur));
        Carte carte2 = new Attaque(0,Type.FEU);
        System.out.println("appliquer "+carte2+":"+carte2.appliquer(joueur));
        System.out.println("appliquer "+borne+":"+carte4.appliquer(joueur));
        System.out.println("appliquer "+botte+":"+botte.appliquer(joueur));
        System.out.println("appliquer "+borne+":"+borne.appliquer(joueur));
        System.out.println("appliquer "+borne+":"+borne.appliquer(joueur));
        System.out.println("appliquer "+limite+":"+limite.appliquer(joueur));
        Carte carte3 = new Attaque(0,Type.ESSENCE);
        System.out.println("appliquer "+carte3+":"+carte3.appliquer(joueur));
        System.out.println("appliquer "+borne+":"+carte1.appliquer(joueur));
        System.out.println("appliquer "+parade+":"+parade.appliquer(joueur));
        
        System.out.println("appliquer "+carte4+":"+carte4.appliquer(joueur));
        System.out.println("TEST JOUER CLASSE COUP");
        ///System.out.println(coup1.jouer(joueur2));
//        System.out.println("appliquer "+c111+":"+c111.appliquer(j));
//        System.out.println("appliquer "+c111+":"+c111.appliquer(j));
//        
//        System.out.println("appliquer "+c2+":"+c2.appliquer(j));
//        System.out.println("appliquer "+c2+":"+c2.appliquer(j));
//        
//        System.out.println("appliquer "+c17+":"+c17.appliquer(j));
//        System.out.println("appliquer "+c17+":"+c17.appliquer(j));
//       
//        System.out.println("appliquer "+c1+":"+c1.appliquer(j));
//        System.out.println("appliquer "+c1+":"+c1.appliquer(j));
	
	}
}
