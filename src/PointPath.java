import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class PointPath {
	//    private double x = 0;
	//    private double y = 0;
            private Point point;
	    private int type = 0;
	    private double distance = 0;
	    private int curve = 0;
            private List<Landmark> visibleLandmarks;
	    
	    public double getx() {return point.getX();}
	    public double gety() {return point.getY();}
	    public int gettype() {return type;}
	    public int getcurve() {return curve;}
            public void setLandmarks(Landmark[] landmarks)
            {
                visibleLandmarks = new ArrayList<Landmark>();
            
                for(int i = 0; i > landmarks.length; i++)
                {
                    if(landmarks[i].visibility(point))
                    {
                        visibleLandmarks.add(landmarks[i]);
                    }
                }
            
            }
            public Point getBetween(PointPath p, int i)
            {
                i = i % 3;
                Point tempPoint = new Point();
               if( i == 0)
                {    
                tempPoint.setX((p.getx() + this.getx())/2);
                tempPoint.setY((p.getx() + this.gety())/2);
                }
                   if( i == 1)
                {    
                tempPoint.setX((p.getx() + this.getx())/3);
                tempPoint.setY((p.getx() + this.gety())/3);
                }
                    if( i == 2)
                {    
                tempPoint.setX(2*(p.getx() + this.getx())/3);
                tempPoint.setY(2*(p.getx() + this.gety())/3);
                }
                return tempPoint;
            }
            
            public Point getBetween(Point p, int i)
            {
                i = i % 3;
                Point tempPoint = new Point();
                if( i == 0)
                {    

                tempPoint.setX((p.getX() + this.getx())/2);
                tempPoint.setY((p.getX() + this.gety())/2);
                }
                   if( i == 1)
                {    
                tempPoint.setX((p.getX() + this.getx())/3);
                tempPoint.setY((p.getX() + this.gety())/3);
                }
                    if( i == 2)
                {    
                tempPoint.setX(2*(p.getX() + this.getx())/3);
                tempPoint.setY(2*(p.getX() + this.gety())/3);
                }
                 return tempPoint;
            }
	    
	    //dwie nastepne metody generuja nastepny punkt w 8 mozliwych kierunkach (w praktyce mozliwych jest 7)
	    public double gennextx(int o) {
	    	if(o == 1 || o == 7) return point.getX() - (distance*1.4142136)/2;
	    	if(o == 2 || o == 6) return point.getX();
	    	if(o == 3 || o == 5) return point.getX() + (distance*1.4142136)/2;
	    	if( o == 4 ) return point.getX() + distance;
	    	if( o == 8 ) return point.getX() - distance;
//	    	if(o==1||o==8||o==7) return x-10;
//	    	else if (o==2||o==6) return x;
//	    	else if (o==3||o==4||o==5) return x+10;
	    	return -1;
	    }
	    public double gennexty(int o) {
			if(o == 1 || o == 3) return point.getY() + (distance*1.4142136)/2;
	    	if(o == 4 || o == 8) return point.getY();
	    	if(o == 5 || o == 7) return point.getY() - (distance*1.4142136)/2;
	    	if( o == 2 ) return point.getY() + distance;
	    	if( o == 6 ) return point.getY() - distance;
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
                point = new Point(a,b);
	        type = c;
	        distance = d;
	        curve = e;
	    }
	}
