package cartes;

public abstract class Probleme extends Carte {

	
	public enum Type { FEU,ESSENCE,CREVAISON,ACCIDENT}
	
	private Type t;
	
	protected Probleme(int nombre, Type t ) {
		super(nombre);
		this.t=t;
	}
	
	public Type gettype()
	{
		return t;
	}
	
	public String toString()
	{
		switch(t)
		{
		case FEU:
			return "FEU";
		case ESSENCE:
			return "ESSENCE";
		case CREVAISON:
			return "CREVAISON";
		default:
			return "ACCIDENT";
		}
	}
	
	
	public boolean equals(Object obj) {
        return super.equals(obj) && this.t == ((Probleme)obj).t;
    }
 

}
