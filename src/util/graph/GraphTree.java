package util.graph;

import java.util.Collection;

public class GraphTree {

	private int last;
	public Integer[][] rows;
	
	public GraphTree(int size) {
		this.rows = new Integer[size][size];
		this.last = 0;
	}
	
	public void insertRow(Integer... nodes) {
		this.rows[last++] = nodes;
	}

	public void insertRow(Collection<Integer> nodes) {
		this.rows[last++] = nodes.toArray(new Integer[nodes.size()]);
	}

	public Integer[] longestPath() {
		return null;
	}
	
}
