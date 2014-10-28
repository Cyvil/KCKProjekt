//stworzenie klasy Point, która umo¿liwa powolanie do zycia obiektu Point o atrybutach x,y typu double; klasa prywatna
public class Point {

	private double x,y;
	
	Point() 
	{
		x = 0.0;
		y = 0.0;
	}
	
	Point(double a, double b)
	{
		x = a;
		y = b;
	}
	
	double getX()
	{
		return x;
	}
	
	double getY()
	{
		return y;
	}
	
	void setX(double a)
	{
		x = a;
	}
	
	void setY(double a)
	{
		y = a;
	}
}
