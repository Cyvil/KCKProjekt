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
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

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
	private Image BICYCLE = Toolkit.getDefaultToolkit().getImage(
			"img/bicycle.png");
	private Image CROSS = Toolkit.getDefaultToolkit().getImage("img/cross.png");
	private Image DOG = Toolkit.getDefaultToolkit().getImage("img/dog.png");
	private Image FONT = Toolkit.getDefaultToolkit().getImage("img/font.png");
	private Image MAN = Toolkit.getDefaultToolkit().getImage("img/man.png");
	private Image BALL = Toolkit.getDefaultToolkit().getImage("img/PILKA.png");
	private Image FLOWER = Toolkit.getDefaultToolkit().getImage(
			"img/flower.png");
	private Image BIRD = Toolkit.getDefaultToolkit().getImage("img/bird.png");
	private Image CAR = Toolkit.getDefaultToolkit().getImage("img/car.png");
	private Image BUSH = Toolkit.getDefaultToolkit().getImage("img/bush.png");
	private Image BENCH = Toolkit.getDefaultToolkit().getImage("img/bench.png");

	public int test = 0;
	public boolean active = true, active2=false;

	public boolean isDrew = true;

	public int[][] Table = new int[20][2];
	public float[][] tab_sciezka = new float[16][5];

	public Window(Path path, Environment environment) {

		super("Find me"); // nazwa okienka -> pasek
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie opcji
														// zmykania
														// okna->klikniêcie na x

		setSize(800, 600);
		setResizable(false); // nie mozna rozciagnac okna

		setBackground(Color.WHITE);
		Sciezka = path;
		Srodowisko = environment;

		JPanel panel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				GeneralPath path2;
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND));
				g2d.setColor(Color.BLACK);

				path2 = new GeneralPath();

				// generowanie sciezki

				for (int i = 0; i < 16; i++) { // dlugosc sciezki -> 15
					float x = 0.0f, y = 0.0f;
					int z = 0;
					if (active) {
						x = (float) Sciezka.Tables[i].getx() * 8.0f;
						y = (float) Sciezka.Tables[i].gety() * 6.0f;
						z = Sciezka.Tables[i].getcurve();
						tab_sciezka[i][0] = x;
						tab_sciezka[i][1] = y;
						tab_sciezka[i][2] = (float) z;
					} else {
						x = tab_sciezka[i][0];
						y = tab_sciezka[i][1];
						z = (int) tab_sciezka[i][2];
					}
					// System.out.println("rodzaj sciezki: "+Sciezka.Tables[i].getcurve()+"po "+i+
					// " kropce");

					// Graphics2D g2d = (Graphics2D) g;
					Ellipse2D.Float circle = new Ellipse2D.Float(x - 4.0f,
							y - 4.0f, 10.0f, 10.0f);
					g2d.fill(circle); // kropka przejsciowa
					
					// ustawnienie kropki START
					if (i == 0) {
						path2.moveTo(x, y);
						g2d.setColor(Color.GREEN); // ustawienie koloru
													// napisu
						g2d.drawString("START", x - 5.0f, y - 5.0f);
						g2d.setColor(Color.BLACK); // ustawienie koloru
													// kropki
					} else if (i == 15) { // ustawienie kropki META
						g2d.setColor(Color.red);
						g2d.drawString("META", x - 5.0f, y - 5.0f);
						g2d.setColor(Color.BLACK);// kolor sciezki
					}

					// posrednie kropki sciezki

					if (i > 0) {
						path2.moveTo(x, y);
						float x_begin = 0.0f, y_begin = 0.0f;
						if (active) {
							x_begin = (float) Sciezka.Tables[i - 1].getx() * 8.0f;
							y_begin = (float) Sciezka.Tables[i - 1].gety() * 6.0f;
							tab_sciezka[i][3] = x_begin;
							tab_sciezka[i][4] = y_begin;
						} else {
							x_begin = tab_sciezka[i][3];
							y_begin = tab_sciezka[i][4];

						}
						if (z == 0 || z == 1 || z == 2 || z == 3 || z == 4
								|| z == 5 || z == 10) {
							//path.lineTo(x, y);
							QuadCurve2D quadcurve = new QuadCurve2D.Float(
									x_begin, y_begin, (x_begin+x)/2, (y_begin+y)/2, x, y);
							g2d.draw(quadcurve);
							g2d.setColor(Color.black);
						}

						// ostry ³uk w lewo
						if (z == 6) {
							QuadCurve2D quadcurve = new QuadCurve2D.Float(
									x_begin, y_begin, x_begin + 20.0f, y, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							g2d.setColor(Color.black);
						}

						// ³agodny ³uk w lewo
						if (z == 7) {
							QuadCurve2D quadcurve = new QuadCurve2D.Float(
									x_begin, y_begin, x_begin - 20.0f,
									y - 20.0f, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							g2d.setColor(Color.black);
						}

						// ³agodny ³uk w prawo
						if (z == 8) {
							QuadCurve2D quadcurve = new QuadCurve2D.Float(
									x_begin, y_begin, x, y_begin + 20.0f, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							g2d.setColor(Color.black);
						}

						// ostry ³uk w prawo
						if (z == 9) {
							QuadCurve2D quadcurve = new QuadCurve2D.Float(
									x_begin, y_begin, x, y_begin, x, y);
							g2d.draw(quadcurve);
							// path.lineTo(x, y);
							g2d.setColor(Color.black);
						}

						// rysowanie skrzyzowania

						Random generator = new Random();
						double c = (double) (generator.nextInt(20) + 15)
								* Math.pow(-1.0, generator.nextInt(2) * 1.0);
						path2.moveTo(x - c, y - c);
						path2.lineTo(x, y);

						if (i != 15) {
							String s = Integer.toString(i);
							g2d.drawString(s, x - 5, y - 5);
						}

					}

				}

				drawLandmarks(g2d, Srodowisko);
				g2d.draw(path2); // rysowanie drogi
//				for(int i=0;i<16;i++)
//				{System.out.println(tab_sciezka[i][0]+" "+tab_sciezka[i][1]+" "+tab_sciezka[i][2]+" "+tab_sciezka[i][3]+" "+tab_sciezka[i][4]+" ");}
				this.setVisible(true);
			}

		};

		add(panel); // dodanie rysowania sciezki do okna
		//Sciezka = new Path();

		// wypisanie sciezki
		/*
		 * for (int i = 0; i < 20; i++) { System.out.println("Punkt nr:" + i +
		 * " x=" + Sciezka.Tables[i].getx() + " y=" + Sciezka.Tables[i].gety());
		 * }
		 */
		setVisible(true); // wyswietlanie
	}

	// metoda na landmarki
	private void drawLandmarks(Graphics2D g, Environment e) {

		Graphics2D landmarki2d = (Graphics2D) g; // rysowanie landmarkow
		Graphics2D napis2d = (Graphics2D) g;
		Environment environment = e;

		for (int i = 0; i < environment.landmarkArraySize; i++) {
			int a = 0, b = 0;
			if (active) {
				a = (int) environment.landmarkArray[i].getPoint().getX() * 8; // wspolrzedne
																				// landmarkow
																				// przechowywane
																				// w
																				// tablicy
																				// Table[][]
				b = (int) environment.landmarkArray[i].getPoint().getY() * 6; // mimo
																				// wielokrotnego
																				// repainta
																				// beda
																				// w
																				// tym
																				// samym
																				// miejscu
				Table[i][0] = a;
				Table[i][1] = b;
			} else {
				a = Table[i][0];
				b = Table[i][1];
			}
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

/*			String s = Integer.toString(i);
			s += "l";
			s += Integer.toString(a);
			s += " ";
			s += Integer.toString(b);
			napis2d.setColor(Color.BLUE);
			napis2d.drawString(s, a - 5, b - 5);
			napis2d.setColor(Color.BLACK);
*/
		}
		landmarki2d.finalize();
		
		active = false;
		active2 = true;
	}
}