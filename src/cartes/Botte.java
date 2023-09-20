package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type t) {
		super(nombre, t);
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		
		switch(super.gettype())
		{
		case FEU:
			return "VEHICULE PRIORITAIRE";
		case ESSENCE:
			return "CITERNE D'ESSENCE";
		case CREVAISON:
			return "inCREVABLE";
		default:
			return "AS DU VOLANT";
		}
		
	}
}
