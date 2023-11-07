package cartes;

public abstract class Carte {
	private int nombre;
	
	public static final int FEU_ROUGE = 1;
	
	protected  Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	public boolean equals(Object ob)
	{
		if(ob instanceof Carte)
		{
			return this.getClass()==ob.getClass();
		}
		return false;
	}
}
