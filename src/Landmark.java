
public class Landmark {
	
	/* stworzenie klasy Landmark o polach: position, type i colour; 
	 * ka�dy Landmark ustawiany przez nas na mapie posiada� wi�c b�dzie trzy cechy:
	 * typ - rodzaj przedmiotu,budynku,miejsca itp.
	 * kolor landmarka w danym typie, poszerza gam� dost�pnych w puli generatora landmark�w 
	 * pozycj� - na bazie obiektu typu Point, wyznacza� b�dzie miejsce na mapie, w kt�rym dany landmark zostanie umieszczony;
	 * 
	 * wywo�anie konstruktora bezargumentowego skutkuje postawieniem landmarka w formie szarego kamienia w punkcie Point=(50,50);
	 * wywo�anie konstruktora tr�jargumentowego generuje losowy landmark:
	 * 		-oblicza modulo 9 z podanej na wej�ciu liczby, uzyskuj�c liczb� typu intiger, kt�rej na sta�e odpowiada dany typ landmarku
	 * 		-oblicza modulo 10 z kolejnej podanej na wej�ciu liczby, kt�rej na sta�e przypisane zosta�y kolory z dost�pnej gamy
	 * 		-ustawia warto�ci x i y Punktu, kt�ry b�dzie wskazywa� miejsce umieszczenia landmarka
	 */
	
	private enum Type
	{
		STONE, TREE, SANTA, GRAVE, WINDMILL, CHURCH, HOUSE, SIGN, STATUE, 
	}
	
	Type type;
	
	private Point position;
	
	private enum Colour
	{
		WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, RED, BROWN, BLACK, GREY, 
	}
	
	Colour colour;
	
	Landmark()
	{
		position = new Point(50,50);
		type = Type.STONE;
		colour = Colour.GREY;
	}
	
	Landmark(int t, int c, Point p)
	{
		t = t % 9;
		c = c % 10;
		
		
		switch(t){
		case 0:
			type = Type.STONE;
			break;
		case 1:
			type = Type.TREE;
			break;
		case 2:
			type = Type.SANTA;
			break;
		case 3:
			type = Type.GRAVE;
			break;
		case 4:
			type = Type.WINDMILL;
			break;
		case 5:
			type = Type.CHURCH;
			break;
		case 6:
			type = Type.HOUSE;
			break;
		case 7:
			type = Type.SIGN;
			break;
		case 8:
			type = Type.STATUE;
			break;
		}
		
		switch(c){
		case 0:
			colour = Colour.WHITE;
			break;
		case 1:
			colour = Colour.YELLOW;
			break;
		case 2:
			colour = Colour.ORANGE;
			break;
		case 3:
			colour = Colour.RED;
			break;
		case 4:
			colour = Colour.GREEN;
			break;
		case 5:
			colour = Colour.BLUE;
			break;
		case 6:
			colour = Colour.PURPLE;
			break;
		case 7:
			colour = Colour.GREY;
			break;
		case 8:
			colour = Colour.BROWN;
			break;
		case 9:
			colour = Colour.BLACK;
			break;
		}
		
		position.setX(p.getX());
		position.setY(p.getY());
	}

	
}
