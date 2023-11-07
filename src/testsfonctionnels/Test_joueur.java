package testsfonctionnels;
import jeu.*;
import cartes.*;
import cartes.Probleme.Type;
public class Test_joueur {

		public static void main(String[] args) {
			
			//instanciation de sjoueur
	        Joueur joueur1 = new Joueur("Joueur 1");
	        Joueur joueur2 = new Joueur("Joueur 2");

	        ///creation des carte 
	        Attaque c=new Attaque(50, Type.ACCIDENT);
	        Attaque c3=new Attaque(50, Type.CREVAISON);
	        Attaque a1=new Attaque(50,Type.FEU);
	        Attaque a2=new Attaque(50,Type.ESSENCE);
	        
	        
			Botte bot1= new Botte(50,Type.ACCIDENT);
			Botte bot2= new Botte(50,Type.FEU);
			
			
			Borne b1=new Borne(50,10);
			Borne b2=new Borne(49,10);
			Borne b3=new Borne(60,10);
			
			Parade c6=new Parade(50,Type.ACCIDENT);
			Parade c7=new Parade(89,Type.ESSENCE);
			Parade c1=new Parade(50,Type.CREVAISON);
			Parade c8=new Parade(50,Type.CREVAISON);
			
			
			FinLimite f1=new FinLimite(50);
			FinLimite f2=new FinLimite(75);
			
			
			DebutLimite d1= new DebutLimite(25);
			DebutLimite d2=new DebutLimite(50);

	        joueur1.donner(c1);
	        joueur1.donner(c);
	        joueur1.donner(c3);
	        //taille de la main est 3 
	      
	        joueur1.getCollectionBorne().add(b1);
	        joueur1.getCollectionBorne().add(b2);
	        joueur1.getCollectionBorne().add(b3);
	        
	 
	        System.out.println("Cartes en main du Joueur 1 :");
	        for (Carte carte : joueur1.getMain().getlist())
	        {
	        	 System.out.println("-"+ carte);
	        	 
	        }
	        
	        
	        ///////test de getLimite()
	      
	        //cas1 pile vide 
	        System.out.println("Pile vide limite :"+joueur1.getLimite());
	        
	        ///cas2 sommet de pil est une lin fe limite 
	        joueur1.getLimiteV().add(d2);
	        joueur1.getLimiteV().add(f1);
	        
	        System.out.println("sommet finlimite, la limite est: "+joueur1.getLimite());
	        
	        
	        //cas3:le joueur a la bote feu 
	        joueur1.getEnsBotte().add(bot1);
	        joueur1.getEnsBotte().add(bot2);
	        
	        System.out.println("botte feu, la limite est: "+joueur1.getLimite());
	        
	        joueur1.getEnsBotte().clear();
	        joueur1.getLimiteV().clear();//vide la pile
	        joueur1.getEnsBotte().add(bot2);
	        //dernier cas
	        joueur1.getLimiteV().add(d2);
	        joueur1.getLimiteV().add(f2);
	        joueur1.getLimiteV().add(d1);
	        
	        System.out.println("Last, la limite est: "+joueur1.getLimite());
	        
	        
	        /////GetLimite Marche
	        
	        
	        
	        System.out.println("Kilométrage du Joueur 1 : " + joueur1.getKM());

	        System.out.println("Limite de vitesse du Joueur 1 : " + joueur1.getLimite());

	
	        
	        ////test-estbloque

	        // Test 1: Ajouter un FEU_ROUGE (true)
	        joueur2.getpileBataille().add(a1);
	        System.out.println("Est bloqué (après ajout FEU_ROUGE) : " + joueur2.estBloque());

	        // Test 2: Ajouter un VEHICULE_PRIORITAIRE (false)
	        joueur2.getEnsBotte().add(bot2);
	        System.out.println("Est bloqué (après ajout VEHICULE_PRIORITAIRE) : " + joueur2.estBloque());

	        // Test 3: Ajouter un ACCIDENT (true)
	        joueur2.getpileBataille().add(c6);
	        System.out.println("Est bloqué (après ajout ACCIDENT) : " + joueur2.estBloque());

	        // Test 4: Ajouter un AS_DU_VOLANT (false)
	        joueur2.getpileBataille().add(bot1);
	        System.out.println("Est bloqué (après ajout AS_DU_VOLANT) : " + joueur2.estBloque());

	        // Test 5: Ajouter une PANNE_D_ESSENCE (true)
	        joueur2.getpileBataille().add(a2);
	        System.out.println("Est bloqué (après ajout PANNE_D_ESSENCE) : " + joueur2.estBloque());

	        // Test 6: Ajouter de L_ESSENCE (false)
	        joueur2.getpileBataille().add(c7);
	        System.out.println("Est bloqué (après ajout L_ESSENCE) : " + joueur2.estBloque());

	        // Test 7: Effacer les bottes (true)
	        joueur2.getEnsBotte().clear();
	        System.out.println("Est bloqué (après effacement des bottes) : " + joueur2.estBloque());

	        // Test 8: Ajouter un FEU_VERT (false)
	        joueur2.getpileBataille().add(c8);
	        System.out.println("Est bloqué (après ajout FEU_VERT) : " + joueur2.estBloque());
	        
		}
}
		
		

