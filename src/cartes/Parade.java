package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		
		switch(super.gettype())
		{
		case FEU:
			return "FEU VERT";
		case ESSENCE:
			return "ESSENCE";
		case CREVAISON:
			return "ROUE DE SECOURS";
		case ACCIDENT:
			return "REPARATION";
		default:
			return "FIN DE LIMITE DE VITESSE";
		}
		
	}
}
