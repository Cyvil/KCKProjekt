import java.util.Random;

public class Path {
	public PointPath[] Tables;
	public boolean CheckOutsideMap(int x, int y) {
		if (x>100||x<0||y>100||y<0) 
			return true; 
		return false;
	}
	
	public Path(){
	Random generator = new Random();
	
	Tables = new PointPath[20];
	//Punkt startowy
	int stA = generator.nextInt(20)*5; 
	int stB = generator.nextInt(20)*5;	
	Tables[0] = new PointPath(stA, stB, 0);
	int k = 0;
	int x =0;
	int y = 0;
	//Wszystkie kolejne punkty
	for(int i=1; i<20;i++)
	{
		boolean ValidPoint = false;
		boolean Backtrack = true;
		boolean OutsideMap = true;
		
		while(ValidPoint==false) {
			//na razie sprawdza tylko czy nastepny punkt nie pokrywa sie z poprzednim i czy nie wychodzi poza mapa
			k = generator.nextInt(8)+1;
			x = Tables[i-1].gennextx(k);
			y = Tables[i-1].gennexty(k);
			Backtrack = Tables[i-1].Backtrack(k);
			OutsideMap = CheckOutsideMap(x,y);
			if (Backtrack==false && OutsideMap==false) ValidPoint = true;
		}
		Tables[i] = new PointPath(x,y,k);
	}
	}
}
