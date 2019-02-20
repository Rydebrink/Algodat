package ClosestPair;


public class Pair {
	
	private Point p1, p2;
	private double distance;
	
	public Pair(Point p1, Point p2)	{
		this.p1 = p1;
		this.p2 = p2;
		distance = p1.distanceTo(p2);
	}

	public double getDistance() {
		return distance;
	}

	public String getP1() {
		return p1.getName();
	}

	public String getP2() {
		return p2.getName();
	}

}
