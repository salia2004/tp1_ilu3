package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString()
	{
		Type x= super.gettype();//x est null pourquoi ?
		switch(x)
		{
		case FEU:
			return "FEU ROUGE";
		case ESSENCE:
			return "PANNE D'ESSENCE";
		case CREVAISON:
			return "CREVAISON";
		case ACCIDENT:
			return "ACCIDENT";
		default:
			return "LIMITE DE VITESSE";
		}
		
	}

}
