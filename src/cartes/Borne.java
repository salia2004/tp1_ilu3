package cartes;

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
	 public boolean equals(Object carte) {
	        if (carte instanceof Borne borne) {
	            return borne.km == this.km;
	        }
	        return false;
	    }


}
