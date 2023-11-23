package cartes;
import jeu.*;

public class Borne extends Carte {
	private int km;
	
	public Borne(int n,int km)
	{
		super(n);
		this.km=km;
	}
	
	public int getKilo()
	{
		return km;
	}
	public String toString()
	{
		
		switch(km)
		{
		case 25:
			return "25";
		case 50:
			return "50";
		case 100:
			return "100";
		case 75:
			return "75";
		default:
			return "200";
		}
		
	}
	 @Override
	 public boolean equals(Object carte) {
	        if (carte instanceof Borne borne) {
	            return borne.km == this.km;
	        }
	        return false;
	    }
	 
	 
	 @Override
	 public boolean appliquer(Joueur j) {
	        int limite = j.getLimite();
	        if (!j.estBloque() && km <= limite && j.getKM() + km <= 1000) {
	            j.getCollectionBorne().add(this);
	            return true;
	        }
	        return false;
	    }

	 
	 
	 	////si la carte est une borne : si le joueur n’est pas bloqué, 
	 //la borne ne dépasse pas la vitesse limite et 
	 //que la somme des bornes ne dépasse pas 1000, la carte est ajoutée aux bornes
	 
	 
	 
}