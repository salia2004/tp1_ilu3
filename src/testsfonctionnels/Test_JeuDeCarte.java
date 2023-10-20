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
		
		///Test sur le nombre d'exemplaire
		
		System.out.println(c.checkCount());
		
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
		
		
		///question 7 a faire 
	}

}
