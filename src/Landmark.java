
public class Landmark {
	
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
