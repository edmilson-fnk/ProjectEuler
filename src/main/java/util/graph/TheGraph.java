package util.graph;

import java.util.Collection;

public class TheGraph {

	private int last;
	private final Integer[][] rows;
	
	public TheGraph(int size) {
		this.rows = new Integer[size][size];
		this.last = 0;
	}
	
	public void insertRow(Collection<Integer> nodes) {
		this.rows[last++] = nodes.toArray(new Integer[0]);
	}

	public Integer[][] rows() {
		return this.rows;
	}
	
	public Integer[] longestPath() {
		return null;
	}
	
}
