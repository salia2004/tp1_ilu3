package tests;
import cartes.*;
import cartes.Probleme.Type;

public class test 
{
	public static void main(String[] args) {
		
		Carte c=new Attaque(50, Type.ACCIDENT);
		Carte c1=new Parade(50,Type.CREVAISON);
		Carte c2= new Botte(50,Type.ACCIDENT);
		Carte c3=new Attaque(50, Type.ACCIDENT);
		Carte c4=new Borne(50,10);
		Carte c5=new Borne(49,10);
		
		Carte c6=new Parade(50,Type.ACCIDENT);
		Carte c7=new Parade(89,Type.ACCIDENT);
		
		boolean x=c.equals(c1);
		boolean y= c2.equals(c);
		System.out.println("c et c1"+ x);
		System.out.println("c et c2"+ y);
		boolean Z= c3.equals(c);
		System.out.println("c et c3"+ Z);
		boolean k= c4.equals(c5);
		System.out.println("c4 et c5"+ k);
		boolean o= c.equals(c6);
		System.out.println("c et c6"+ o);
		boolean p= c7.equals(c6);
		System.out.println("c7 et c6"+ p);
		////FIN premiere partie 
	}
}
