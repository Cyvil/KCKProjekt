import java.awt.Image;
import java.awt.Toolkit;
import java.lang.Math;
import java.util.Random;

public class Landmark {
	
	/* stworzenie klasy Landmark o polach: position, type i colour; 
	 * każdy Landmark ustawiany przez nas na mapie posiadał więc będzie trzy cechy:
	 * typ - rodzaj przedmiotu,budynku,miejsca itp.
	 * kolor landmarka w danym typie, poszerza gamę dostępnych w puli generatora landmarków 
	 * pozycję - na bazie obiektu typu Point, wyznaczać będzie miejsce na mapie, w którym dany landmark zostanie umieszczony;
	 * 
	 * wywołanie konstruktora bezargumentowego skutkuje postawieniem landmarka w formie szarego kamienia w punkcie Point=(50,50);
	 * wywołanie konstruktora trójargumentowego generuje losowy landmark:
	 * 		-oblicza modulo 9 z podanej na wejściu liczby, uzyskując liczbę typu integer, której na stałe odpowiada dany typ landmarku
	 * 		-oblicza modulo 10 z kolejnej podanej na wejściu liczby, której na stałe przypisane zostały kolory z dostępnej gamy
	 * 		-ustawia wartości x i y Punktu, który będzie wskazywał miejsce umieszczenia landmarka
	 */
	
	protected enum Type
	{
		STONE, TREE, SANTA, WINDMILL, CHURCH, HOUSE, SIGN, STATUE, CAT, BICYCLE, CROSS, DOG, BENCH, FLOWER, FONT, MAN, BALL, BIRD, CAR, BUSH  
	}
	
	private Type type;
	
	private Point position;
	
	private double visibilityRadius;
	
	private double collisionRadius;

		Landmark()
	{
		position = new Point(50,50);
		type = Type.STONE;
		visibilityRadius = 10.0;
		collisionRadius = visibilityRadius/2.5;
	}
	
	
	//Konstruktor, ustala typ a tak�e przypisan� do niego widoczno�� Landmarku
	Landmark(int t, Point p)
	{
		
		t = t % 21;
		
		switch(t){
		case 0:
			type = Type.STONE;
			collisionRadius = 2.50;
			break;
		case 1:
			type = Type.TREE;
			collisionRadius = 2.5;
			break;
		case 2:
			type = Type.SANTA;
			collisionRadius = 2.50;
			break;
		case 3:
			type = Type.TREE;
			collisionRadius = 2.5;
			break;
		case 4:
			type = Type.WINDMILL;
			collisionRadius = 3.0;
			break;
		case 5:
			type = Type.CHURCH;
			collisionRadius = 3.0;
			break;
		case 6:
			type = Type.HOUSE;
			collisionRadius = 3.00;
			break;
		case 7:
			type = Type.SIGN;
			collisionRadius = 2.50;
			break;
		case 8:
			type = Type.STATUE;
			collisionRadius = 2.50;
			break;
		case 9:
			type = Type.CAT;
			collisionRadius = 2.50;
			break;
		case 10:
			type = Type.BICYCLE;
			collisionRadius = 2.50;
			break;
		case 11:
			type = Type.CROSS;
			collisionRadius = 2.50;
			break;
		case 12:
			type = Type.DOG;
			collisionRadius = 2.50;
			break;
		case 13:
			type = Type.FONT;
			collisionRadius = 2.50;
			break;
		case 14:
			type = Type.MAN;
			collisionRadius = 2.50;
			break;
		case 15:
			type = Type.BALL;
			collisionRadius = 2.50;
			break;
		case 16:
			type = Type.FLOWER;
			collisionRadius = 2.50;
			break;
		case 17:
			type = Type.BIRD;
			collisionRadius = 2.50;
			break;
		case 18:
			type = Type.CAR;
			collisionRadius = 2.50;
			break;
		case 19:
			type = Type.BUSH;
			collisionRadius = 2.50;
			break;
		case 20:
			type = Type.BENCH;
			collisionRadius = 2.50;
			break;
		}
			
		
		visibilityRadius = collisionRadius*3;
		
		position = new Point();
		position.setX(p.getX());
		position.setY(p.getY());

	}
	
	//Widoczność - dla uproszczenia i realizmu zawsze jest jakby kołem wokół tego obiektu o promieniu visibilityRadius
	//Żeby sprawdzić czy obiekt jest widoczny sprawdzamy jego odległość od punktu w ktorym stoimy 
	//Jeżeli ta odległość jest mniejsza niz promien widocznosci to wtedy obiekt jest "widoczny"
	
	boolean visibility(Point p)
	{
		double distance = Math.sqrt((position.getX() - p.getX())*(position.getX() - p.getX()) + ((position.getY() - p.getY())*(position.getY() - p.getY())));
		if (distance <= visibilityRadius)
			return true;
		else return false;
	}
	
	//Kolizja - tutaj sprawa ma się analogicznie, w istocie to tylko kopiuj wklej,
	//ale zasadniczo te dwie metody służą do różnych rzeczy
	//Tutaj dla UPROSZCZENIA przyjmujemy, że to obiekty kołowe, żeby nie musieć kombinować z kolizjami 
	//Generalnie tak dla ułatwienia przyjąłem, że promien kolizji jest 10 razy mniejszy od promienia widocznosci
	
	boolean collision(Point p)
	{
		double distance = Math.sqrt((position.getX() - p.getX())*(position.getX() - p.getX()) + ((position.getY() - p.getY())*(position.getY() - p.getY())));
		if (distance <= collisionRadius)
			return true;
		else return false;
	}
	
	//Zwracamy typ
	
	Type getType()
	{
		return this.type;
	}
	
	//Zwracamy któryś z promieni - jezeli jest true to zwracamy promien kolizji, jesli false - promien widoczności
	
	double getRadius(boolean collision)
	{
		if (collision) return collisionRadius;
		else return visibilityRadius;
	}

	Point getPoint()
	{
		return position;
	}
}
