import java.util.Random;

public class Path {
	
	Random generator = new Random();
	public boolean CheckOutsideMap(int x, int y) {if (x>100||x<0||y>100||y<0) return true; else return false;}
	Dot[] Table;
	Table = new Dot[20];
	//Punkt startowy
	int stA = generator.nextInt(20)*5; 
	int stB = generator.nextInt(20)*5;	
	Table[0] = new Dot(stA, stB, 0);
	//Wszystkie kolejne punkty
	for(int i=1; i<=20;i++)
	{
		boolean ValidPoint = false;
		boolean Backtrack = true;
		boolean OutsideMap = true;
		while(ValidPoint==false) //na razie sprawdza tylko czy następny punkt nie pokrywa się z poprzednim i czy nie wychodzi poza mapę
		{
		int t = generator.nextInt(8)+1;
		int x = Table[i-1].gennextx(t);
		int y = Table[i-1].gennexty(t);
		Backtrack = Table[i-1].Backtrack(t);
		OutsideMap = CheckOutsideMap(x,y);
		if (Backtrack==false && OutsideMap==false) ValidPoint = true;
		}
		Table[i] = new Dot(x,y,t);
	}
}

	
	
