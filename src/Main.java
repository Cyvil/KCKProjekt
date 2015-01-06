

public class Main
{

	public static void main(String[] args)
	{
		Path path = new Path();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Punkt nr:" + i + " x="
					+ path.Tables[i].getx() + " y="
					+ path.Tables[i].gety());
		}

		//generowanie landmarkow
		Environment environment = new Environment(path);		
		for (int i = 0; i < environment.landmarkArraySize; i++)
		{
			System.out.println("Landmark " + i + ": " + environment.landmarkArray[i].getType() +
				" pozycja : x = " + environment.landmarkArray[i].getPoint().getX() + 
				" y = "  + environment.landmarkArray[i].getPoint().getY()  +  
				" widocznoœæ :" + environment.landmarkArray[i].getRadius(false)*environment.landmarkArray[i].getRadius(false)*3.14 +
				" Kolizja :" + environment.landmarkArray[i].getRadius(true)*environment.landmarkArray[i].getRadius(true)*3.14);
		}
		
		for (int i = 0; i < 20; i++)
		{
			path.Tables[i].setLandmarks(environment.landmarkArray);
			
			System.out.println("Dla punktu " + i +" o wspó³rzêdnych:  x = " + path.Tables[i].getx() + " y = " + path.Tables[i].gety());
			path.Tables[i].printLandmarks();
		}
		
		//tworzenie okna
		Window Okno=new Window(path, environment);
		
				
	}

	
}
