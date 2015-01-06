
public class Language {
	private int startA;
	private int startB;
	private int iter;
	private int direction;
	private int curve;
	private PointPath point;

	
	public String[] LangArray = new String[20];
	
	public void addStart(int x, int y){
		String a = "Start(" + x + "," + y + ")";	
		LangArray[0] = a;
	}
	
	public void addLine(int k, int z, int i, PointPath p){
		String a = ""; 
		if (z < 0){
			a = a + "STR(" + k + ")";
			a += addLandmarks(p);
			LangArray[i] = a;
		}
		if ((z > 1 && z < 2) && k == 7 || k == 8 || k == 1 ){
			a = a + "AGR(" + k + ")";
			a += addLandmarks(p);
			LangArray[i] = a;
		}
		if ((z > 3 && z < 4) && k == 3 || k == 4 || k == 5 ){
			a = a + "AGL(" + k + ")";
			a += addLandmarks(p);
			LangArray[i] = a;
		}
		if ((z > 4 ) && k == 7 || k == 8 || k == 1 ){
			a = a + "ASR(" + k + ")";
			a += addLandmarks(p);
			LangArray[i] = a;
		}
		if ((z > 5 ) && k == 3 || k == 4 || k == 5 ){
			a = a + "ASL(" + k + ")";
			a += addLandmarks(p);
			LangArray[i] = a;
		}
		
	}
	
	public String addLandmarks(PointPath pp)
	{
		String a = "";
		String side = "";
		PointPath.Location loc = PointPath.Location.LEFT;
		Landmark land = null;
		
		int size = pp.getListSize();
		
		for(int i = 0; i < size; i++)
		{
			pp.getLandmark(loc, land, i);
			if(loc == PointPath.Location.LEFT)
			{
				side = "L";
			}
			else
			{
				side = "R";
			}
			
			if(land.getType()==Landmark.Type.SANTA) 
			{
				a +=  "SNT(" + side + ")";
			}
			if(land.getType()==Landmark.Type.HOUSE) 
			{
				a +=  "HSE(" + side + ")";
			}
			if(land.getType()==Landmark.Type.TREE) 
			{
				a +=  "TRE(" + side + ")";
			}
			if(land.getType()==Landmark.Type.STONE) 
			{
				a +=  "STN(" + side + ")";
			}
			if(land.getType()==Landmark.Type.CHURCH) 
			{
				a +=  "CHU(" + side + ")";
			}
			if(land.getType()==Landmark.Type.WINDMILL) 
			{
				a +=  "WND(" + side + ")";
			}
			if(land.getType()==Landmark.Type.STATUE) 
			{
				a +=  "STA(" + side + ")";
			}
			if(land.getType()==Landmark.Type.SIGN) 
			{
				a +=  "SGN(" + side + ")";
			}
			
		}
		
		return a;
	}
	
	
	//Constructors
	public Language (int x, int y){
		startA = x;
		startB = y;
		addStart(x,y);
	}
	public Language (int k, int z,int i, PointPath p){
		direction = k;
		curve = z;
		iter = i;
		point = p;
		addLine(k,z,i,p);
	}
		
}

