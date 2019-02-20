package ClosestPair;


public class Point {
	
	private String name;
	private double x;
	private double y;
	private int indexInOtherList;
	
	public Point(String name, String x, String y)	{
		this.name = name;
		this.x = Double.parseDouble(x);
		this.y = Double.parseDouble(y);
	}
	
	public void setIndexInOtherList(int index)	{
		indexInOtherList = index;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distanceTo(Point p2)	{
		double xDist = Math.abs(p2.getX()-this.getX());
		double yDist = Math.abs(p2.getY()-this.getY());
		double totDist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		return totDist;
	}

	public String getName() {
		return name;
	}
}
