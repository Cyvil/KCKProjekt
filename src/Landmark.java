import java.lang.Math;

public class Landmark {
	
	/* stworzenie klasy Landmark o polach: position, type i colour; 
	 * ka¿dy Landmark ustawiany przez nas na mapie posiada³ wiêc bêdzie trzy cechy:
	 * typ - rodzaj przedmiotu,budynku,miejsca itp.
	 * kolor landmarka w danym typie, poszerza gamê dostêpnych w puli generatora landmarków 
	 * pozycjê - na bazie obiektu typu Point, wyznaczaæ bêdzie miejsce na mapie, w którym dany landmark zostanie umieszczony;
	 * 
	 * wywo³anie konstruktora bezargumentowego skutkuje postawieniem landmarka w formie szarego kamienia w punkcie Point=(50,50);
	 * wywo³anie konstruktora trójargumentowego generuje losowy landmark:
	 * 		-oblicza modulo 9 z podanej na wejœciu liczby, uzyskuj¹c liczbê typu integer, której na sta³e odpowiada dany typ landmarku
	 * 		-oblicza modulo 10 z kolejnej podanej na wejœciu liczby, której na sta³e przypisane zosta³y kolory z dostêpnej gamy
	 * 		-ustawia wartoœci x i y Punktu, który bêdzie wskazywa³ miejsce umieszczenia landmarka
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
	
	
	//Konstruktor, ustala typ a tak¿e przypisan¹ do niego widocznoœæ Landmarku
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
	
	//Widocznoœæ - dla uproszczenia i realizmu zawsze jest jakby ko³em wokó³ tego obiektu o promieniu visibilityRadius
	//¯eby sprawdziæ czy obiekt jest widoczny sprawdzamy jego odleg³oœæ od punktu w którym stoimy 
	//Je¿eli ta odleg³oœæ jest mniejsza ni¿ promieñ widocznoœci to wtedy obiekt jest "widoczny"
	
	boolean visibility(Point p)
	{
		double distance = Math.sqrt((position.getX() - p.getX())*(position.getX() - p.getX()) - (position.getY() - p.getY())*(position.getY() - p.getY()));
		if (distance <= visibilityRadius)
			return true;
		else return false;
	}
	
	//Kolizja - tutaj sprawa ma siê analogicznie, w istocie to tylko kopiuj wklej,
	//ale zasadniczo te dwie metody s³u¿¹ do ró¿nych rzeczy
	//Tutaj dla UPROSZCZENIA przyjmujemy, ¿e to obiekty ko³owe, ¿eby nie musieæ kombinowaæ z kolizjami 
	//Generalnie tak dla u³atwienia przyj¹³em, ¿e promien kolizji jest 10 razy mniejszy od promienia widocznosci
	
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
	
	//Zwracamy któryœ z promieni - jezeli jest true to zwracamy promien kolizji, jesli false - promien widocznoœci
	
	double getRadius(boolean collision)
	{
		if (collision == true) return collisionRadius;
		else return visibilityRadius;
	}

	//Zwracamy punkt - a Ty myœla³eœ, ¿e co?
	
	Point getPoint()
	{
		return position;
	}
}
