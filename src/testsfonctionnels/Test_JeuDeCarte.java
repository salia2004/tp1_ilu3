package testsfonctionnels;
import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

import cartes.JeuDeCartes;
import utils.Utils;

public class Test_JeuDeCarte {

	public static void main(String[] args) {
		JeuDeCartes c = new JeuDeCartes();
		
		///affichage de toute les cartes
		
		List<Carte> L= c.getListeCartes();
		for(int i=0;i<L.size();i++) {
			System.out.println(L.get(i));
			
		}
		
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCartes(); 
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee); 
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
		
		
		///test verifiant que le nombre d'occurance de chaque carte est bien respecter 
		System.out.println("-----------debut test checkcount----------");
		System.out.println(c.checkCount());
		
		
	}

}
