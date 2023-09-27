package cartes;

public abstract class Probleme extends Carte {

	
	public enum Type { FEU,ESSENCE,CREVAISON,ACCIDENT}
	
	private Type t;
	
	public Probleme(int nombre, Type t ) {
		super(nombre);
		this.t=t;
	}
	
	public Type gettype()
	{
		return t;
	}
	

}
