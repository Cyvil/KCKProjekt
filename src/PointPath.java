import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class PointPath {
	// private double x = 0;
	// private double y = 0;
	private Point point;
	private int type = 0;
	private double distance = 0;
	private int curve = 0;
	private List<Landmark> visibleLandmarks;
	private List<Integer> landmarkNumber;

	private double visibilityRadius = 3.0;
	private double collisionRadius = 1.0;

	protected enum Location {
		LEFT, RIGHT
	}

	private List<Location> landmarkLocation;

	public double getx() {
		return point.getX();
	}

	public double gety() {
		return point.getY();
	}

	public int gettype() {
		return type;
	}

	public int getcurve() {
		return curve;
	}

	boolean visibility(Point p) {
		double distance = Math.sqrt((point.getX() - p.getX())
				* (point.getX() - p.getX()) + (point.getY() - p.getY())
				* (point.getY() - p.getY()));
		if (distance <= visibilityRadius)
			return true;
		else
			return false;
	}

	boolean collision(Point p) {
		double distance = Math.sqrt((point.getX() - p.getX())
				* (point.getX() - p.getX()) + (point.getY() - p.getY())
				* (point.getY() - p.getY()));
		if (distance <= collisionRadius)
			return true;
		else
			return false;
	}

	public void setLandmarks(Landmark[] landmarks) {
		visibleLandmarks = new ArrayList<Landmark>();
		landmarkNumber = new ArrayList<Integer>();
		landmarkLocation = new ArrayList<Location>();

		for (int i = 0; i < landmarks.length; i++) {
			if (this.visibility(landmarks[i].getPoint())) {
				visibleLandmarks.add(landmarks[i]);
				landmarkNumber.add(i);
				Location loc = landmarkSide(landmarks[i]);
				landmarkLocation.add(loc);
			}
		}

	}

	public void getLandmark(Location loc, Landmark land, int j) {
		if (visibleLandmarks.size() > 0) {
			land = getLandmarkType(j);
			loc = getLandmarkSide(j);
		}
	}

	public int getListSize() {
		return visibleLandmarks.size();
	}

	private Landmark getLandmarkType(int j) {
		return visibleLandmarks.get(j);
	}

	private Location getLandmarkSide(int j) {
		return landmarkLocation.get(j);
	}

	// Ustalanie czy landmark jest po lewej czy prawej stronie punktu (zale¿nie
	// od kierunku drogi wywodz¹cej sie z tego punktu)
	private Location landmarkSide(Landmark l) {

		Location loc = Location.LEFT;

		if (this.type == 1 || this.type == 5) {
			double constant = this.gety() + this.getx();

			if (l.getPoint().getX() + l.getPoint().getY() < constant) {
				if (this.type == 1)
					return Location.RIGHT;
				else
					return Location.LEFT;
			} else {
				if (this.type == 5)
					return Location.LEFT;
				else
					return Location.RIGHT;
			}
		}

		if (this.type == 3 || this.type == 7) {
			double constant = this.gety() - this.getx();

			if (l.getPoint().getX() + constant < l.getPoint().getY()) {
				if (this.type == 3)
					return Location.RIGHT;
				else
					return Location.LEFT;
			} else {
				if (this.type == 7)
					return Location.LEFT;
				else
					return Location.RIGHT;
			}
		}

		if (this.type == 2 || this.type == 6) {
			double constant = this.gety();

			if (l.getPoint().getX() < constant) {
				if (this.type == 2)
					return Location.RIGHT;
				else
					return Location.LEFT;
			} else {
				if (this.type == 6)
					return Location.LEFT;
				else
					return Location.RIGHT;
			}

		}

		if (this.type == 4 || this.type == 8) {
			double constant = this.getx();

			if (l.getPoint().getY() < constant) {
				if (this.type == 8)
					return Location.RIGHT;
				else
					return Location.LEFT;
			} else {
				if (this.type == 4)
					return Location.LEFT;
				else
					return Location.RIGHT;
			}

		}
		return loc;
	}

	// dwie nastepne metody generuja nastepny punkt w 8 mozliwych kierunkach (w
	// praktyce mozliwych jest 7)
	public double gennextx(int o) {
		if (o == 1 || o == 7)
			return point.getX() - (distance * 1.4142136) / 2;
		if (o == 2 || o == 6)
			return point.getX();
		if (o == 3 || o == 5)
			return point.getX() + (distance * 1.4142136) / 2;
		if (o == 4)
			return point.getX() + distance;
		if (o == 8)
			return point.getX() - distance;
		// if(o==1||o==8||o==7) return x-10;
		// else if (o==2||o==6) return x;
		// else if (o==3||o==4||o==5) return x+10;
		return -1;
	}

	public double gennexty(int o) {
		if (o == 1 || o == 3)
			return point.getY() + (distance * 1.4142136) / 2;
		if (o == 4 || o == 8)
			return point.getY();
		if (o == 5 || o == 7)
			return point.getY() - (distance * 1.4142136) / 2;
		if (o == 2)
			return point.getY() + distance;
		if (o == 6)
			return point.getY() - distance;
		// if(o==5||o==6||o==7) return y-10;
		// else if (o==4||o==8) return y;
		// else if (o==1||o==2||o==3) return y+10;
		return -1;
	}

	public boolean Backtrack(int o) {
		if (type == 0)
			return false;
		else if (o - type == 4 || o - type == -4)
			return true;
		else
			return false;
	}

	// ta metoda bada, czy nastepny punkt nie jest generowny w tym samym miejscu
	// co poprzedni

	// Constructor
	public PointPath(double a, double b, int c, double d, int e) {
		point = new Point(a, b);
		type = c;
		distance = d;
		curve = e;
	}

	public void printLandmarks() {
		int listSize = visibleLandmarks.size();

		for (int i = 0; i < listSize; i++) {
			System.out.println("Widaæ landmarki: "
					+ this.visibleLandmarks.get(i).getType() + " o numerze :"
					+ this.landmarkNumber.get(i));
			System.out.println("o wspó³rzêdnych:  x = "
					+ this.visibleLandmarks.get(i).getPoint().getX() + " y = "
					+ this.visibleLandmarks.get(i).getPoint().getY());
			System.out.println("Po stronie " + this.landmarkLocation.get(i)
					+ " punktu");
		}

	}
}
