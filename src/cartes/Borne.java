package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km,int n)
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
	public boolean equals(Object ob)
	{
		Borne p=(Borne) ob;
		return super.equals(ob) && this .getKilo()==p.getKilo();
	}

}
