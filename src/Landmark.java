import java.lang.Math;

public class Landmark {
	
	/* stworzenie klasy Landmark o polach: position, type i colour; 
	 * ka�dy Landmark ustawiany przez nas na mapie posiada� wi�c b�dzie trzy cechy:
	 * typ - rodzaj przedmiotu,budynku,miejsca itp.
	 * kolor landmarka w danym typie, poszerza gam� dost�pnych w puli generatora landmark�w 
	 * pozycj� - na bazie obiektu typu Point, wyznacza� b�dzie miejsce na mapie, w kt�rym dany landmark zostanie umieszczony;
	 * 
	 * wywo�anie konstruktora bezargumentowego skutkuje postawieniem landmarka w formie szarego kamienia w punkcie Point=(50,50);
	 * wywo�anie konstruktora tr�jargumentowego generuje losowy landmark:
	 * 		-oblicza modulo 9 z podanej na wej�ciu liczby, uzyskuj�c liczb� typu integer, kt�rej na sta�e odpowiada dany typ landmarku
	 * 		-oblicza modulo 10 z kolejnej podanej na wej�ciu liczby, kt�rej na sta�e przypisane zosta�y kolory z dost�pnej gamy
	 * 		-ustawia warto�ci x i y Punktu, kt�ry b�dzie wskazywa� miejsce umieszczenia landmarka
	 */
	
	protected enum Type
	{
		STONE, TREE, SANTA, GRAVE, WINDMILL, CHURCH, HOUSE, SIGN, STATUE 
	}
	
	private Type type;
	
	private Point position;
	
	private double visibilityRadius;
	
	private double collisionRadius;
	
/*	private enum Colour
	{
		WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, RED, BROWN, BLACK, GREY, 
	}
	*/
//	Colour colour;
	
	Landmark()
	{
		position = new Point(50,50);
		type = Type.STONE;
		visibilityRadius = 10.0;
		collisionRadius = visibilityRadius/10;
	}
	
	
	//Konstruktor, ustala typ a tak�e przypisan� do niego widoczno�� Landmarku
	Landmark(int t, Point p)
	{
		t = t % 9;
		
		
		switch(t){
		case 0:
			type = Type.STONE;
			visibilityRadius = 10.0;
			break;
		case 1:
			type = Type.TREE;
			visibilityRadius = 15.0;
			break;
		case 2:
			type = Type.SANTA;
			visibilityRadius = 10.0;
			break;
		case 3:
			type = Type.GRAVE;
			visibilityRadius = 10.0;
			break;
		case 4:
			type = Type.WINDMILL;
			visibilityRadius = 20.0;
			break;
		case 5:
			type = Type.CHURCH;
			visibilityRadius = 25.0;
			break;
		case 6:
			type = Type.HOUSE;
			visibilityRadius = 20.0;
			break;
		case 7:
			type = Type.SIGN;
			visibilityRadius = 10.0;
			break;
		case 8:
			type = Type.STATUE;
			visibilityRadius = 10.0;
			break;
		}
			
		collisionRadius = visibilityRadius/10;
		position = new Point();
		position.setX(p.getX());
		position.setY(p.getY());

	}
	
	//Widoczno�� - dla uproszczenia i realizmu zawsze jest jakby ko�em wok� tego obiektu o promieniu visibilityRadius
	//�eby sprawdzi� czy obiekt jest widoczny sprawdzamy jego odleg�o�� od punktu w kt�rym stoimy 
	//Je�eli ta odleg�o�� jest mniejsza ni� promie� widoczno�ci to wtedy obiekt jest "widoczny"
	
	boolean visibility(Point p)
	{
		double distance = Math.sqrt((position.getX() - p.getX())*(position.getX() - p.getX()) - (position.getY() - p.getY())*(position.getY() - p.getY()));
		if (distance <= visibilityRadius)
			return true;
		else return false;
	}
	
	//Kolizja - tutaj sprawa ma si� analogicznie, w istocie to tylko kopiuj wklej,
	//ale zasadniczo te dwie metody s�u�� do r�nych rzeczy
	//Tutaj dla UPROSZCZENIA przyjmujemy, �e to obiekty ko�owe, �eby nie musie� kombinowa� z kolizjami 
	//Generalnie tak dla u�atwienia przyj��em, �e promien kolizji jest 10 razy mniejszy od promienia widocznosci
	
	boolean collision(Point p)
	{
		double distance = Math.sqrt((position.getX() - p.getX())*(position.getX() - p.getX()) - (position.getY() - p.getY())*(position.getY() - p.getY()));
		if (distance <= collisionRadius)
			return true;
		else return false;
	}
	
	//Zwracamy typ
	
	Type getType()
	{
		return this.type;
	}
	
	//Zwracamy kt�ry� z promieni - jezeli jest true to zwracamy promien kolizji, jesli false - promien widoczno�ci
	
	double getRadius(boolean collision)
	{
		if (collision == true) return collisionRadius;
		else return visibilityRadius;
	}

	//Zwracamy punkt - a Ty my�la�e�, �e co?
	
	Point getPoint()
	{
		return position;
	}
}
