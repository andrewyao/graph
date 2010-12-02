package graph;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class BFSearch {

	AdjacencyLists g;
	PrintStream ps = System.out;
	boolean[] processed;
	boolean[] discovered;
	int[] parent;

	public BFSearch(boolean directed) {
		g = new AdjacencyLists(directed);
	}

	public void read(InputStream s) {
		g.read(s);
		init();
	}

	protected void init() {
		processed = new boolean[g.nvertices];
		discovered = new boolean[g.nvertices];
		parent = new int[g.nvertices];

		for (int i = 0; i < g.nvertices; ++i) {

			processed[i] = discovered[i] = false;
			parent[i] = -1;
		}
	}

	public void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(new Integer(start));

		discovered[start] = true;

		while (!q.isEmpty()) {
			int v = q.remove().intValue();
			processVertexEarly(v);

			processed[v] = true;
			EdgeNode p = g.edges[v];

			while (p != null) {
				int y = p.y;
				if (!processed[y] || g.directed) {
					processEdge(v, y);
				}
				if (!discovered[y]) {
					q.add(new Integer(y));
					discovered[y] = true;
					parent[y] = v;
				}
				p = p.next;
			}
			processVertexLate(v);
		}
	}

	protected void processVertexLate(int v) {

	}

	protected void processVertexEarly(int v) {
		this.ps.printf("Vertex %d\n", v);
	}

	protected void processEdge(int x, int y) {
		this.ps.printf("Edge (%d,%d)\n", x, y);
	}
}
