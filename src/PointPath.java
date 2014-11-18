import java.lang.Math;

public class PointPath {
	    private double x = 0;
	    private double y = 0;
	    private int type = 0;
	    private double distance = 0;
	    private int curve = 0;
	    
	    public double getx() {return x;}
	    public double gety() {return y;}
	    public int gettype() {return type;}
	    public int getcurve() {return curve;}
	    
	    //dwie nastepne metody generuja nastepny punkt w 8 mozliwych kierunkach (w praktyce mozliwych jest 7)
	    public double gennextx(int o) {
	    	if(o == 1 || o == 7) return x - (distance*1.4142136)/2;
	    	if(o == 2 || o == 6) return x;
	    	if(o == 3 || o == 5) return x + (distance*1.4142136)/2;
	    	if( o == 4 ) return x + distance;
	    	if( o == 8 ) return x - distance;
//	    	if(o==1||o==8||o==7) return x-10;
//	    	else if (o==2||o==6) return x;
//	    	else if (o==3||o==4||o==5) return x+10;
	    	return -1;
	    }
	    public double gennexty(int o) {
			if(o == 1 || o == 3) return y + (distance*1.4142136)/2;
	    	if(o == 4 || o == 8) return y;
	    	if(o == 5 || o == 7) return y - (distance*1.4142136)/2;
	    	if( o == 2 ) return y + distance;
	    	if( o == 6 ) return y - distance;
//	    	if(o==5||o==6||o==7) return y-10;
//	    	else if (o==4||o==8) return y;
//	    	else if (o==1||o==2||o==3) return y+10;
			return -1;
	    }
	    public boolean Backtrack(int o){
	    	if (type==0) return false; else if(o-type==4||o-type==-4)return true; else return false;} 
	    //ta metoda bada, czy nastepny punkt nie jest generowny w tym samym miejscu co poprzedni
	        	    
	    //Constructor
	    public PointPath(double a, double b, int c, double d, int e) {
	        x = a;
	        y = b;
	        type = c;
	        distance = d;
	        curve = e;
	    }
	}
	
