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

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private Path Sciezka;
	private Image TREE = Toolkit.getDefaultToolkit().getImage("img/tree.png");
	private Image STONE = Toolkit.getDefaultToolkit().getImage("img/stone.jpg");
	private Image SANTA = Toolkit.getDefaultToolkit().getImage("img/santa.png");
	private Image WINDMILL = Toolkit.getDefaultToolkit().getImage("img/windmill.png");
	private Image STATUE = Toolkit.getDefaultToolkit().getImage("img/statue.jpg");
	private Image CHURCH = Toolkit.getDefaultToolkit().getImage("img/church.png");
	private Image SIGN = Toolkit.getDefaultToolkit().getImage("img/sign.png");
	private Image HOUSE = Toolkit.getDefaultToolkit().getImage("img/house.png");
	
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
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND));
				g2d.setColor(Color.BLACK);

				path = new GeneralPath();

				for (int i = 0; i < 20; i++) {

					double x = Sciezka.Tables[i].getx() * 8;
					double y = Sciezka.Tables[i].gety() * 6;
					if (i == 0) {
						path.moveTo(x, y);
						Graphics2D kropka2d = (Graphics2D) g;
						Ellipse2D.Double circle = new Ellipse2D.Double(x - 4,y - 4, 10, 10); // tworzenie kolka o danej
												// wielkosci
						kropka2d.setColor(Color.GREEN); // ustawienie koloru
						kropka2d.fill(circle); // wypelnianie
						Graphics2D napis2d = (Graphics2D) g;
						napis2d.drawString("START", (int)x - 5, (int)y - 5);
					} else {
						path.lineTo(x, y);
					}
					if (i == 19) {
						Graphics2D kropka2d = (Graphics2D) g;
						Ellipse2D.Double circle = new Ellipse2D.Double(x - 4,y - 4, 10, 10);
						kropka2d.setColor(Color.red);
						kropka2d.fill(circle); // kropka mety
						Graphics2D napis2d = (Graphics2D) g;
						napis2d.drawString("META", (int)x - 5, (int)y - 5);
						g2d.setColor(Color.BLACK);// kolor sciezki
					}
				}
				g2d.draw(path); // rysowanie drogi
				
				drawLandmarks(g);	// rysowanie landmarkow
				
			}
		};

		add(panel); // dodanie rysowania sciezki do okna

		// tworzenie sciezki
		Sciezka = new Path();
		for (int i = 0; i < 20; i++) {
			System.out.println("Punkt nr:" + i + " x="
					+ Sciezka.Tables[i].getx() + " y="
					+ Sciezka.Tables[i].gety());
		}

	}

	private void drawLandmarks(Graphics g) {
		Graphics2D landmarki2d = (Graphics2D) g; // rysowanie landmarkow
		Environment environment = new Environment();
		for (int i = 0; i < environment.landmarkArraySize; i++) {

			int a = (int) environment.landmarkArray[i].getPoint().getX()*8;
			int b = (int) environment.landmarkArray[i].getPoint().getY()*6;

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
				landmarki2d.drawImage(STATUE, a, b, 25, 25, this);
			if (environment.landmarkArray[i].getType() == Landmark.Type.SIGN)
				landmarki2d.drawImage(SIGN, a, b, 25, 25, this);
			

			System.out.println("Landmark " + i + ": "
					+ environment.landmarkArray[i].getType()
					+ " pozycja : x = "
					+ environment.landmarkArray[i].getPoint().getX() + " y = "
					+ environment.landmarkArray[i].getPoint().getY()
					+ " widocznoœæ :"
					+ environment.landmarkArray[i].getRadius(false)
					+ " Kolizja :"
					+ environment.landmarkArray[i].getRadius(true));
					
		}
		landmarki2d.finalize();
	}
}
