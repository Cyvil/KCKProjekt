

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Environment environment = new Environment();
		
		for (int i = 0; i < environment.landmarkArraySize; i++)
		{
			System.out.println("Landmark " + i + ": " + environment.landmarkArray[i].getType() +" pozycja : x = " + environment.landmarkArray[i].getPoint().getX() + " y = "  + environment.landmarkArray[i].getPoint().getY()  +  " widocznoœæ :" + environment.landmarkArray[i].getRadius(false) + " Kolizja :" + environment.landmarkArray[i].getRadius(true));
		}
	}

}
