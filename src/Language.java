public class Language {
        private double startA;
        private double startB;
        private int iter;
        private int direction;
        private int curve;
        private Path point;
 
       
        public String[] LangArray = new String[20];
       
       
        public void printToConsole()
        {
                for (int i = 0 ; i< 20; i++)
                {
                        System.out.println(LangArray[i]);
                }
        }
       
        public void genLanguage(Path x){
                int i = 0;
                if (i == 0)
                {
                        PointPath punkt = x.Tables[i];
                        double startx = punkt.getx();
                        double starty = punkt.gety();
                        addStart(startx,starty);
                }
                for(i = 1; i < 19; i++){
                        PointPath punkt = x.Tables[i];
                        int k = punkt.gettype();
                        int z = punkt.getcurve();
                        addLine(k,z,i,punkt);  
                }
                if (i == 19){
                        PointPath punkt = x.Tables[i];
                        double endx = punkt.getx();
                        double endy = punkt.gety();
                        addEnd(endx,endy);
                }
               
               
        }
       
        public void addEnd(double x, double y){
                String a = "End(" + x + "," + y + ")";
                LangArray[19] = a;
        }
       
        public void addStart(double x, double y){
                String a = "Start(" + x + "," + y + ")";      
                LangArray[0] = a;
        }
       
        public void addLine(int direction, int curve, int iter, PointPath p){
                String a = "";
                if ((curve > 0 && curve < 6) || curve == 10){
                        a = a + "STR(" + direction + ")";
                        a += addLandmarks(p);
                        LangArray[iter] = a;
                }
                if ((curve == 8) ){
                        a = a + "AGR(" + direction + ")";
                        a += addLandmarks(p);
                        LangArray[iter] = a;
                }
                if ((curve == 7)){
                        a = a + "AGL(" + direction + ")";
                        a += addLandmarks(p);
                        LangArray[iter] = a;
                }
                if ((curve == 9 )){
                        a = a + "ASR(" + direction + ")";
                        a += addLandmarks(p);
                        LangArray[iter] = a;
                }
                if ((curve == 6 )){
                        a = a + "ASL(" + direction + ")";
                        a += addLandmarks(p);
                        LangArray[iter] = a;
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
                        
            			land = pp.getLandmarkType(i);
            			loc = pp.getLandmarkSide(i);
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
                        if(land.getType()==Landmark.Type.CAT)
                        {
                                a +=  "CAT(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.BICYCLE)
                        {
                                a +=  "BIC(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.CROSS)
                        {
                                a +=  "CRS(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.DOG)
                        {
                                a +=  "DOG(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.BENCH)
                        {
                                a +=  "BEN(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.FLOWER)
                        {
                                a +=  "FLW(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.FONT)
                        {
                                a +=  "FNT(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.MAN)
                        {
                                a +=  "MAN(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.BALL)
                        {
                                a +=  "FLW(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.BIRD)
                        {
                                a +=  "BRD(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.CAR)
                        {
                                a +=  "CAR(" + side + ")";
                        }
                        if(land.getType()==Landmark.Type.BUSH)
                        {
                                a +=  "BSH(" + side + ")";
                        }
                       
                }
               
                return a;
        }
 
       
        //Constructors
        public Language (Path p){
                genLanguage(p);
        }
               
}