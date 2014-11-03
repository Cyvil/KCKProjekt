import java.util.Random;


// stworzenie klasy Environment, która ma byæ œrodowiskiem, map¹;

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
			int t;
			Point tempPoint = new Point(((double)generator.nextInt(100) + generator.nextDouble()),((double)generator.nextInt(100) + generator.nextDouble()));
			
			t = generator.nextInt(9);
			
			boolean collision = true;
			
			while(collision)
			{
				
			tempPoint.setX((double)generator.nextInt(100) + generator.nextDouble());
			tempPoint.setX((double)generator.nextInt(100) + generator.nextDouble());
			
			int collisionSum = 0;	
				for (int j = 0; j < i; j++)
				{
					if (landmarkArray[j].collision(tempPoint))
						collisionSum++;
				}
				
				if (collisionSum == 0) collision = false;
			}
			
			landmarkArray[i] = new Landmark(t,tempPoint);
			
		}
		
		/*
		 * wywo³anie konstruktowa bezargumentowego klasy Environment tworzy tablicê jednowymiarow¹ o nazwie landmarkArray
		 * wype³nion¹ obiektami typu Landmark;
		 * iloœæ landmarków, które maj¹ pojawiæ siê na mapie (tu: wielkoœæ tablicy landmarkArray)
		 * generowana jest losowo, nie ma przekraczaæ 21;
		 * tablica wype³niana jest kolejno nowo tworzonymi landmarkami, których cechy najpierw s¹ ustalane: 
		 * pozycja(wartoœæ x i y losuje generator),
		 * przy czym po wylosownaiu pozycji nastêpuje sprawdzenie czy nie dochodzi do kolizji z innymi landmarkami
		 * typ, wybierany z zakresu dostêpnych w danych polu mo¿liwoœci 
		 * 
		 */
		
	}
	
	
}
