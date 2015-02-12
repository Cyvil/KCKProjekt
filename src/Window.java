import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private Path Sciezka;
	private Environment Srodowisko;
	private Image TREE = Toolkit.getDefaultToolkit().getImage("img/tree.png");
	private Image STONE = Toolkit.getDefaultToolkit().getImage("img/stone.png");
	private Image SANTA = Toolkit.getDefaultToolkit().getImage("img/santa.png");
	private Image WINDMILL = Toolkit.getDefaultToolkit().getImage(
			"img/windmill.png");
	private Image STATUE = Toolkit.getDefaultToolkit().getImage(
			"img/statue.png");
	private Image CHURCH = Toolkit.getDefaultToolkit().getImage(
			"img/church.png");
	private Image SIGN = Toolkit.getDefaultToolkit().getImage("img/sign.png");
	private Image HOUSE = Toolkit.getDefaultToolkit().getImage("img/house.png");
	private Image CAT = Toolkit.getDefaultToolkit().getImage("img/cat.png");
	private Image BICYCLE = Toolkit.getDefaultToolkit().getImage("img/bicycle.png");
	private Image CROSS = Toolkit.getDefaultToolkit().getImage("img/cross.png");
	private Image DOG = Toolkit.getDefaultToolkit().getImage("img/dog.png");
	private Image FONT = Toolkit.getDefaultToolkit().getImage("img/font.png");
	private Image MAN = Toolkit.getDefaultToolkit().getImage("img/man.png");
	private Image BALL = Toolkit.getDefaultToolkit().getImage("img/PILKA.png");
	private Image FLOWER = Toolkit.getDefaultToolkit().getImage("img/flower.png");
	private Image BIRD = Toolkit.getDefaultToolkit().getImage("img/bird.png");
	private Image CAR = Toolkit.getDefaultToolkit().getImage("img/car.png");
	private Image BUSH = Toolkit.getDefaultToolkit().getImage("img/bush.png");
	private Image BENCH = Toolkit.getDefaultToolkit().getImage("img/bench.png");
	
	
	public boolean isDrew = true;

	public Window(Path path, Environment environment) {
		
		
		super("Find me"); // nazwa okienka -> pasek
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie opcji
														// zmykania
														// okna->klikniêcie na x
		setVisible(true); // wyswietlanie
		setSize(800, 600);
		setResizable(false); // nie mozna rozciagnac okna

		setBackground(Color.WHITE);
		
		Sciezka = path;
		Srodowisko = environment;
		
	

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				GeneralPath path;
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND));
				g2d.setColor(Color.BLACK);

				path = new GeneralPath();

				// generowanie sciezki

				for (int i = 0; i < 20; i++) {

					float x = (float) Sciezka.Tables[i].getx() * 8.0f;
					float y = (float) Sciezka.Tables[i].gety() * 6.0f;
					int z = Sciezka.Tables[i].getcurve();
					
					// System.out.println("rodzaj sciezki: "+Sciezka.Tables[i].getcurve()+"po "+i+
					// " kropce");

					Graphics2D kropka2d = (Graphics2D) g;
					Ellipse2D.Float circle = new Ellipse2D.Float(x - 4.0f,
							y - 4.0f, 10.0f, 10.0f);
//					System.out.println("Punkt nr " + i + ": " + (x - 4.0f)
//							+ " " + (y - 4.0f) + " ");
					kropka2d.fill(circle); // kropka przejsciowa
					Graphics2D napis2d = (Graphics2D) g;

					// ustawnienie kropki START
					if (i == 0) {
						path.moveTo(x, y);
						kropka2d.setColor(Color.GREEN); // ustawienie koloru
						napis2d.drawString("START", x - 5.0f, y - 5.0f);
						kropka2d.setColor(Color.BLACK); // ustawienie koloru
					} 
					else if (i == 10) { // ustawienie kropki META
						kropka2d.setColor(Color.red);
						napis2d.drawString("META", x - 5.0f, y - 5.0f);
						g2d.setColor(Color.BLACK);// kolor sciezki
					}
					
					// posrednie kropki sciezki

					if (i > 0) {
						
						float x_begin = (float) Sciezka.Tables[i - 1].getx() * 8.0f;
						float y_begin = (float) Sciezka.Tables[i - 1].gety() * 6.0f;
						
						if(z==0 || z==1 || z==2 || z==3 || z==4 || z==5 || z==10){
							path.lineTo(x, y);
							kropka2d.setColor(Color.black);
						}
						
						//ostry ³uk w lewo
						if(z==6){
						QuadCurve2D quadcurve = new QuadCurve2D.Float(x_begin,
								y_begin, x_begin + 20.0f, y, x, y);
						g2d.draw(quadcurve);
						// path.lineTo(x, y);
						kropka2d.setColor(Color.black);
						}
						
						//³agodny ³uk w lewo
						if(z==7){
							QuadCurve2D quadcurve = new QuadCurve2D.Float(x_begin,
									y_begin, x_begin - 20.0f, y-20.0f, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							kropka2d.setColor(Color.black);
						}
						
						//³agodny ³uk w prawo
						if(z==8){
							QuadCurve2D quadcurve = new QuadCurve2D.Float(x_begin,
									y_begin, x, y_begin+20.0f, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							kropka2d.setColor(Color.black);
						}
						
						//ostry ³uk w prawo
						if(z==9){
							QuadCurve2D quadcurve = new QuadCurve2D.Float(x_begin,
									y_begin, x, y_begin, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							kropka2d.setColor(Color.black);
						}
						
						//rysowanie skrzyzowania
						Random generator=new Random();
						double c = (double)(generator.nextInt(20)+15)*Math.pow(-1.0, generator.nextInt(2)*1.0);
						path.moveTo(x-c,y-c);
						path.lineTo(x, y);
						
						if(i!=19){
						String s = Integer.toString(i);
						napis2d.drawString(s, x - 5, y - 5);
						}

					}

				}

				drawLandmarks(g,Srodowisko);
				g2d.draw(path); // rysowanie drogi

			}
		};

		add(panel); // dodanie rysowania sciezki do okna

		Sciezka = new Path();

		// wypisanie sciezki
/*		for (int i = 0; i < 20; i++) {
			System.out.println("Punkt nr:" + i + " x="
					+ Sciezka.Tables[i].getx() + " y="
					+ Sciezka.Tables[i].gety()); 
		}*/

	}

	// metoda na landmarki
	private void drawLandmarks(Graphics g, Environment e) {
		Graphics2D landmarki2d = (Graphics2D) g; // rysowanie landmarkow
		Graphics2D napis2d = (Graphics2D) g;
		Environment environment = e;
		for (int i = 0; i < environment.landmarkArraySize; i++) {

			int a = (int) environment.landmarkArray[i].getPoint().getX() * 8;
			int b = (int) environment.landmarkArray[i].getPoint().getY() * 6;

			if (environment.landmarkArray[i].getType() == Landmark.Type.TREE)
				landmarki2d.drawImage(TREE, a, b, 40, 40, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.STONE)
				landmarki2d.drawImage(STONE, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.SANTA)
				landmarki2d.drawImage(SANTA, a, b, 35, 35, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.WINDMILL)
				landmarki2d.drawImage(WINDMILL, a, b, 55, 55, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.CHURCH)
				landmarki2d.drawImage(CHURCH, a, b, 50, 50, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.HOUSE)
				landmarki2d.drawImage(HOUSE, a, b, 50, 50, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.STATUE)
				landmarki2d.drawImage(STATUE, a, b, 70, 70, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.SIGN)
				landmarki2d.drawImage(SIGN, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.CAT)
				landmarki2d.drawImage(CAT, a, b, 35, 35, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.BICYCLE)
				landmarki2d.drawImage(BICYCLE, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.CROSS)
				landmarki2d.drawImage(CROSS, a, b, 35, 35, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.DOG)
				landmarki2d.drawImage(DOG, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.FONT)
				landmarki2d.drawImage(FONT, a, b, 30, 30, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.MAN)
				landmarki2d.drawImage(MAN, a, b, 30, 30, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.BALL)
				landmarki2d.drawImage(BALL, a, b, 20, 20, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.FLOWER)
				landmarki2d.drawImage(FLOWER, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.BIRD)
				landmarki2d.drawImage(BIRD, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.CAR)
				landmarki2d.drawImage(CAR, a, b, 30, 30, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.BUSH)
				landmarki2d.drawImage(BUSH, a, b, 30, 30, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.BENCH)
				landmarki2d.drawImage(BENCH, a, b, 55, 55, this);
			

			
			String s = Integer.toString(i);
			s += "l";
			s += Integer.toString(a);
			s += " ";
			s += Integer.toString(b);
			napis2d.setColor(Color.BLUE);
			napis2d.drawString(s, a - 5, b - 5);
			napis2d.setColor(Color.BLACK);

			// wyswietlanie pomocnicze rozlozenia landmarkow na mapie
			/*
			 * System.out.println("Landmark " + i + ": " +
			 * environment.landmarkArray[i].getType() + " pozycja : x = " +
			 * environment.landmarkArray[i].getPoint().getX() + " y = " +
			 * environment.landmarkArray[i].getPoint().getY() + " widocznoœæ :"
			 * + environment.landmarkArray[i].getRadius(false) + " Kolizja :" +
			 * environment.landmarkArray[i].getRadius(true));
			 */
		}
		landmarki2d.finalize();
	}
}