public class Dot {
	    private int x = 0;
	    private int y = 0;
	    private int type = 0;
	    
	    public int getx() {return x;}
	    public int gety() {return y;}
	    public int gettype() {return type;}
	    
	    //dwie nastepne metody generuja nastepny punkt w 8 mozliwych kierunkach (w praktyce możliwych jest 7)
	    public int gennextx(int o) {
	    	if(o==1||o==8||o==7) return x-5;
	    	else if (o==2||o==6) return x;
	    	else if (o==3||o==4||o==5) return x+5;
	    }
	    public int gennexty(int o) {
	    	if(o==5||o==6||o==7) return y-5;
	    	else if (o==4||o==8) return y;
	    	else if (o==1||o==2||o==3) return y+5;
	    }
	    public boolean Backtrack(int o){
	    	if (type==0) return false; else if(o-type==4||o-type==-4)return true; else return false;} //ta metoda bada, czy następny punkt nie jest generowny w tym samym miejscu co poprzedni
	    
	    //Constructor
	    public Dot(int a, int b, int c) {
	        x = a;
	        y = b;
	        type = c;
	    }
	}
	

