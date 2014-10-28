import java.util.Random;

public class Environment {

	Point corner = new Point(100,100);
	int landmarkArraySize = 0;
	Landmark[] landmarkArray;
	
	Environment()
	{
		Random generator = new Random();
		while(landmarkArraySize < 15)
		{
			landmarkArraySize = generator.nextInt(21);
		}
		
		landmarkArray = new Landmark[landmarkArraySize];
		
		for(int i = 0; i < landmarkArraySize; i++)
		{
			int t,c;
			Point tempPoint = new Point(((double)generator.nextInt(100) + generator.nextDouble()),((double)generator.nextInt(100) + generator.nextDouble()));
			
			t = generator.nextInt(9);
			c = generator.nextInt(10);
			
			landmarkArray[i] = new Landmark(t,c,tempPoint);
			
			
		}
		
		
	}
	
	
}
