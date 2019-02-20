package SpanningUSA;

public class Edge implements Comparable<Edge> {

	private Town t1, t2;
	private int distance;

	public Edge(Town t1, Town t2, int distance) {
		this.t1=t1;
		this.t2=t2;
		this.distance = distance;
	}

	public Town town1() {
		return t1;
	}

	public Town town2() {
		return t2;
	}

	public int compareTo(Edge o) {
		if (o instanceof Edge) {
			return distance - ((Edge) o).distance();
		} else {
			throw new ClassCastException();
		}
	}



	public int distance() {
		return distance;
	}

}