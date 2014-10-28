import java.util.Random;

// stworzenie klasy Environment, kt�ra ma by� �rodowiskiem, map�;

public class Environment {

	Point corner = new Point(100,100); // ustalenie wielkosci mapy na 100x100px
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
		
		/*
		 * wywo�anie konstruktowa bezargumentowego klasy Environment tworzy tablic� jednowymiarow� o nazwie landmarkArray
		 * wype�nion� obiektami typu Landmark;
		 * ilo�� landmakr�w, kt�re maj� pojawi� si� na mapie (tu: wielko�� tablicy landmarkArray)
		 * generowana jest losowo, nie ma przekracza� 21;
		 * tablica wype�niana jest kolejno nowo tworzonymi landmarkami, kt�rych cechy najpierw s� ustalane: 
		 * pozycja(warto�� x i y losuje generator),
		 * typ i kolor, wybierane z zakresu dost�pnych w danych polch mo�liwo�ci 
		 * 
		 */
		
	}
	
	
}
