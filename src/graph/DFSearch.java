package graph;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Stack;

public class DFSearch {

	AdjacencyLists g;
	PrintStream ps = System.out;

	boolean finished = false;
	boolean[] processed;
	boolean[] discovered;
	int[] parent;

	int[] entry_time;
	int[] exit_time;
	int time;

	DFSearch(boolean directed) {
		g = new AdjacencyLists(directed);
	}

	void read(InputStream s) {
		g.read(s);
		init();
	}

	void init() {
		processed = new boolean[g.nvertices];
		discovered = new boolean[g.nvertices];
		parent = new int[g.nvertices];

		entry_time = new int[g.nvertices];
		exit_time = new int[g.nvertices];
		
		for (int i = 0; i < g.nvertices; ++i) {

			processed[i] = discovered[i] = false;
			parent[i] = -1;
			
			entry_time[i] = 0;
			exit_time[i] = 0;
		}
	}

	void dfs(int start) {

		Stack<Integer> q = new Stack<Integer>();
		q.add(new Integer(start));
		discovered[start] = true;

		while (!q.isEmpty()) {
			int v = q.pop().intValue();
			time = time + 1;
			entry_time[v] = time;
			
			processVertexEarly(v);

			processed[v] = true;
			EdgeNode p = g.edges[v];

			while (p != null) {
				int y = p.y;
				
				if (!discovered[y]) {
					parent[y] = v;
					processEdge(v, y);
					
					q.add(new Integer(y));
					discovered[y] = true;
					
				} else if (!processed[y] || g.directed) {
					processEdge(v, y);
				}
				
				if (finished) {
					return;
				}
				
				p = p.next;
			}
			
			exit_time[v] = time;
			
			processVertexLate(v);
		}
	}

	void dfsRecursive(int v) {
		EdgeNode p;
		int y;

		if (finished) {
			return;
		}

		discovered[v] = true;
		time = time + 1;
		entry_time[v] = time;

		processVertexEarly(v);

		p = g.edges[v];
		while (p != null) {
			y = p.y;
			if (!discovered[y]) {
				parent[y] = v;
				processEdge(v, y);
				dfsRecursive(y);
			} else if (!processed[y] || g.directed) {
				processEdge(v, y);
			}
			if (finished) {
				return;
			}
			p = p.next;
		}

		processVertexLate(v);

		time = time + 1;
		exit_time[v] = time;

		processed[v] = true;
	}

	void processVertexLate(int v) {

	}

	void processVertexEarly(int v) {
		ps.printf("Vertex %d\n", v);
	}

	void processEdge(int x, int y) {
		ps.printf("Edge (%d,%d)\n", x, y);
	}

}
