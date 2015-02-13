import java.util.Random;


// stworzenie klasy Environment, która ma być środowiskiem, mapą;

public class Environment {

	Point corner = new Point(100,100); // ustalenie wielkosci mapy na 100x100px
	int landmarkArraySize = 0;			
	Landmark[] landmarkArray;		
	
	public Landmark[] getLandmarkArray()
	{
	 return landmarkArray;	
	}
	
	Environment()
	{
		Random generator = new Random();
		while(landmarkArraySize < 15)
		{
			landmarkArraySize = generator.nextInt(21);
		}
		
	//	landmarkArraySize = 15;
		
		landmarkArray = new Landmark[landmarkArraySize];
		

		
		for(int i = 0; i < landmarkArraySize; i++)
		{
			int t;
			Point tempPoint = new Point((double)generator.nextInt(800),(double)generator.nextInt(600));
			
			t = generator.nextInt(9);
			
			boolean collision = true;
			
			while(collision)
			{
				
			tempPoint.setX((double)generator.nextInt(800) + generator.nextDouble());
			tempPoint.setY((double)generator.nextInt(600) + generator.nextDouble());
			
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
		 * wywołanie konstruktowa bezargumentowego klasy Environment tworzy tablicę jednowymiarową o nazwie landmarkArray
		 * wypełnioną obiektami typu Landmark;
		 * ilość landmarków, które mają pojawić się na mapie (tu: wielkość tablicy landmarkArray)
		 * generowana jest losowo, nie ma przekraczać 21;
		 * tablica wypełniana jest kolejno nowo tworzonymi landmarkami, których cechy najpierw są ustalane: 
		 * pozycja(wartość x i y losuje generator),
		 * przy czym po wylosownaiu pozycji następuje sprawdzenie czy nie dochodzi do kolizji z innymi landmarkami
		 * typ, wybierany z zakresu dostępnych w danych polu możliwości 
		 * 
		 */
		
	}
	
	  Environment(Path path)
	{
		Random generator = new Random();
                while(landmarkArraySize < 15)
		{
			landmarkArraySize = generator.nextInt(21);
		}
		
//		landmarkArraySize = 10;
		
		landmarkArray = new Landmark[landmarkArraySize];
                
                double xMin = 100, xMax = 0, yMin = 100, yMax = 0;
                
                for(int i = 0; i < path.Tables.length; i++)
                { 
                    double xTemp = path.Tables[i].getx();
                    double yTemp = path.Tables[i].gety();
                    if(xTemp < xMin)
                        xMin = xTemp;
                    if(yTemp < yMin)
                        yMin = yTemp;
                    if(xTemp > xMax)
                        xMax = xTemp;
                    if(yTemp > yMax)
                        yMax = yTemp;
                        
                }
		
        System.out.println("xMin: " + xMin );  
        System.out.println("xMax: " + xMax );  
        System.out.println("yMin: " + yMin );  
        System.out.println("yMax: " + yMax );  
        
        
		
		for(int i = 0; i < landmarkArraySize; i++)
		{
			int t;
			Point tempPoint = new Point((double)generator.nextInt((int)xMax+5),(double)generator.nextInt((int)yMax+5));
			
			t = generator.nextInt(9);
			
			boolean collision = true, borders = true, visibility = false;
			
			while(collision || borders || !visibility)
			{
				
			tempPoint.setX((double)generator.nextInt((int)xMax+5) + generator.nextDouble());
			tempPoint.setY((double)generator.nextInt((int)yMax+5) + generator.nextDouble());
                        
            if(tempPoint.getX() < xMin - 5 || tempPoint.getY() < yMin - 5) 
                 borders = true;
            else borders = false;
			
            Landmark tempLandmark =new Landmark(t, tempPoint);
                        
			int collisionSum = 0, visibilitySum = 0;	
				for (int j = 0; j < i; j++)
				{
					if (landmarkArray[j].collision(tempPoint))
						collisionSum++;
                                        
				}
				
                for (int z = 0; z < path.Tables.length; z++)
				{
  
                                    
                                    
					if (path.Tables[z].collision(tempLandmark.getPoint()))
                    {
                       collisionSum++;
                    }
				
					if (collisionSum == 0) collision = false;
                                
				}
                
                
				for (int zi = 0; zi < path.Tables.length; zi++)
				{
					if(path.Tables[zi].visibility(tempLandmark.getPoint()))
					{
						visibilitySum++;
					}

				} 
				
				if (visibilitySum > 0) visibility = true;
                
			}
			
			landmarkArray[i] = new Landmark(t,tempPoint);
			
		}
		
		
	}
	
 	
}
