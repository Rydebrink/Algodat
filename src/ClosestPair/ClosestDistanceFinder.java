package ClosestPair;

import java.util.ArrayList;
import java.util.Collections;

public class ClosestDistanceFinder {

	public ClosestDistanceFinder() {
	}

	public Pair closestPair(ArrayList<Point> points) {
		ArrayList<Point> Px = new ArrayList<Point>();
		ArrayList<Point> Py = new ArrayList<Point>();
		// n*log(n)²
		constructLists(points, Px, Py);
		return closestPairRec(Px, Py);
	}

	// n*log(n)
	private Pair closestPairRec(ArrayList<Point> Px, ArrayList<Point> Py) {
		if (Px.size() <= 3) {
			return findClosestPair(Px);
		}

		int halfIndex = Px.size() / 2;

		ArrayList<Point> Q = new ArrayList<Point>();
		for (int i = 0; i < halfIndex; i++) {
			Q.add(Px.get(i));
		}
		ArrayList<Point> Qx = new ArrayList<Point>();
		ArrayList<Point> Qy = new ArrayList<Point>();
		// n*log(n)
		constructLists(Q, Qx, Qy);

		ArrayList<Point> R = new ArrayList<Point>();
		for (int i = halfIndex; i < Px.size(); i++) {
			R.add(Px.get(i));
		}
		ArrayList<Point> Rx = new ArrayList<Point>();
		ArrayList<Point> Ry = new ArrayList<Point>();
		// n*log(n)
		constructLists(R, Rx, Ry);

		Pair closestQPair = closestPairRec(Qx, Qy);
		Pair closestRPair = closestPairRec(Rx, Ry);

		Pair closestPair = closestQPair;
		if (closestRPair.getDistance() < closestPair.getDistance()) {
			closestPair = closestRPair;
		}

		double minDistance = closestPair.getDistance();
		double l = Qx.get(Qx.size() - 1).getX();

		ArrayList<Point> Sy = new ArrayList<Point>();
		for (Point p : Py) {
			if (Math.abs(p.getX() - l) <= minDistance) {
				Sy.add(p);
			}
		}

		Pair closestMiddlePair = null;

		for (int i = 0; i < Sy.size(); i++) {
			Point s = Sy.get(i);
			int endIndex = 15;
			if (Sy.size() - 1 - i < 15) {
				endIndex = Sy.size() - 1 - i;
			}
			for (int j = i + 1; j < i + 1 + endIndex; j++) {
				Point nextS = Sy.get(j);
				if (s.distanceTo(nextS) < minDistance) {
					closestMiddlePair = new Pair(s, nextS);
				}
			}
		}

		if (closestMiddlePair != null) {
			return closestMiddlePair;
		} else {
			return closestPair;
		}
	}

	private Pair findClosestPair(ArrayList<Point> points) {
		Point p1 = points.get(0);
		Point p2 = points.get(1);
		if (points.size() == 2) {
			return new Pair(p1, p2);
		}
		Point p3 = points.get(2);
		Pair pair1 = new Pair(p1, p2);
		Pair pair2 = new Pair(p1, p3);
		Pair pair3 = new Pair(p2, p3);
		Pair closestPair = pair1;
		if (pair2.getDistance() < closestPair.getDistance()) {
			closestPair = pair2;
		}
		if (pair3.getDistance() < closestPair.getDistance()) {
			closestPair = pair3;
		}
		return closestPair;
	}

	// n*log(n)
	private void constructLists(ArrayList<Point> points, ArrayList<Point> pX,
			ArrayList<Point> pY) {
		pX.addAll(points);
		pY.addAll(points);
		// 2*n*log(n)
		Collections.sort(pY, new YComp());
		Collections.sort(pX, new XComp());

		for (int i = 0; i < pX.size(); i++) {
			Point x = pX.get(i);
			// n
			int yIndex = pY.indexOf(x);
			x.setIndexInOtherList(yIndex);
			pY.get(yIndex).setIndexInOtherList(i);
		}
	}

}
