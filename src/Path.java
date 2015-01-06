import java.util.Random;

public class Path {
	public PointPath[] Tables;
	public boolean CheckOutsideMap(double x, double y) {
		if (x>90||x<10||y>90||y<10) 
			return true; 
		return false;
	}
	
	double distance = 0;
	
	public Path(){
		
	Random generator = new Random();
	
	Tables = new PointPath[20];
	
	//Punkt startowy
	
	int stA = generator.nextInt(20)*5; 
	int stB = generator.nextInt(20)*5;	
	Tables[0] = new PointPath(stA, stB, 0, 10, 0);
	
	int k = 0;
	int z = 0;
	double x =0;
	double y = 0;
	distance = 23;
	
	//Wszystkie kolejne punkty
	
	for(int i=1; i<20;i++)
	{
		boolean ValidPoint = false;
		boolean Backtrack = true;
		boolean OutsideMap = true;
		while(ValidPoint==false) {
			
			Backtrack = true;
			OutsideMap = true;
			k = generator.nextInt(8)+1;
			x = Tables[i-1].gennextx(k);
			y = Tables[i-1].gennexty(k);
			z = generator.nextInt(10)+1;
			Backtrack = Tables[i-1].Backtrack(k);
			OutsideMap = CheckOutsideMap(x,y);
			if (Backtrack==false && OutsideMap==false) ValidPoint = true;
		}
		Tables[i] = new PointPath(x,y,k,distance,z);
	}
	}
}
