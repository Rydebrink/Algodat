package ClosestPair;

import java.util.Comparator;

public class XComp implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		Double result = new Double(o1.getX() - o2.getX());
		if(result < 0) return -1;
		if(result > 0) return 1;
		return 0;
		//return result.intValue();
	}

}
