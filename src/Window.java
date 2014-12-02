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
	public boolean isDrew = true;

	public Window() {
		super("Find me"); // nazwa okienka -> pasek
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie opcji
														// zmykania
														// okna->klikniêcie na x
		setVisible(true); // wyswietlanie
		setSize(800, 600);
		setResizable(false); // nie mozna rozciagnac okna

		setBackground(Color.WHITE);

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

				for (int i = 0; i < 11; i++) {

					float x = (float) Sciezka.Tables[i].getx() * 8.0f;
					float y = (float) Sciezka.Tables[i].gety() * 6.0f;

					int z = Sciezka.Tables[i].getcurve();
					// System.out.println("rodzaj sciezki: "+Sciezka.Tables[i].getcurve()+"po "+i+
					// " kropce");

					Graphics2D kropka2d = (Graphics2D) g;
					Ellipse2D.Float circle = new Ellipse2D.Float(x - 4.0f,
							y - 4.0f, 10.0f, 10.0f);
					System.out.println("Punkt nr " + i + ": " + (x - 4.0f)
							+ " " + (y - 4.0f) + " ");
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
						
						QuadCurve2D quadcurve = new QuadCurve2D.Float(x_begin,
								y_begin, x_begin + 20.0f, y, x, y);
						g2d.draw(quadcurve);
						// path.lineTo(x, y);
						kropka2d.setColor(Color.black);
						
						
						//rysowanie skrzyzowania
						Random generator=new Random();
						double c = (double)(generator.nextInt(20)+10)*Math.pow(-1.0, generator.nextInt(2)*1.0);
						path.moveTo(x-c,y-c);
						path.lineTo(x, y);
						
						if(i!=10){
						String s = Integer.toString(i);
						napis2d.drawString(s, x - 5, y - 5);
						}

					}

				}

				drawLandmarks(g);
				g2d.draw(path); // rysowanie drogi

			}
		};

		add(panel); // dodanie rysowania sciezki do okna

		Sciezka = new Path();

		// wypisanie sciezki
		for (int i = 0; i < 20; i++) {
			System.out.println("Punkt nr:" + i + " x="
					+ Sciezka.Tables[i].getx() + " y="
					+ Sciezka.Tables[i].gety());
		}

	}

	// metoda na landmarki
	private void drawLandmarks(Graphics g) {
		Graphics2D landmarki2d = (Graphics2D) g; // rysowanie landmarkow
		Environment environment = new Environment();
		for (int i = 0; i < environment.landmarkArraySize; i++) {

			int a = (int) environment.landmarkArray[i].getPoint().getX();
			int b = (int) environment.landmarkArray[i].getPoint().getY();

			if (environment.landmarkArray[i].getType() == Landmark.Type.TREE)
				landmarki2d.drawImage(TREE, a, b, 30, 30, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.STONE)
				landmarki2d.drawImage(STONE, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.SANTA)
				landmarki2d.drawImage(SANTA, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.WINDMILL)
				landmarki2d.drawImage(WINDMILL, a, b, 45, 45, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.CHURCH)
				landmarki2d.drawImage(CHURCH, a, b, 50, 50, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.HOUSE)
				landmarki2d.drawImage(HOUSE, a, b, 45, 45, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.STATUE)
				landmarki2d.drawImage(STATUE, a, b, 40, 40, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.SIGN)
				landmarki2d.drawImage(SIGN, a, b, 25, 25, this);

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