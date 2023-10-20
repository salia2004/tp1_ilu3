package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main{
	private List<Carte> l =new ArrayList<>();
	
	
	public void prendre(Carte c) {
		l.add(c);
		
	}
	public void jouer(Carte c) {
		assert(l.contains(c));
		l.remove(c);
	}

	@Override
	public Iterator<Carte> iter_c() {
		return l.iterator();
	}

}