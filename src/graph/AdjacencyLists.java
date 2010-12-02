package graph;

import java.io.InputStream;
import java.util.Scanner;

public class AdjacencyLists {
	public AdjacencyLists(boolean directed) {
		this.directed = directed;
	}

	EdgeNode[] edges;
	int[] degrees;
	int nvertices;
	int nedges;
	boolean directed;

	public void insertEdge(int x, int y, boolean directed) {
		EdgeNode p = new EdgeNode();

		p.y = y;
		p.next = this.edges[x];
		this.edges[x] = p;
		this.degrees[x]++;

		if (!directed) {
			insertEdge(y, x, true);
		} else {
			nedges++;
		}
	}

	public void read(InputStream s) {
		Scanner scanner = new Scanner(s);

		// number of edges
		int m;
		int x, y;

		nvertices = scanner.nextInt();
		degrees = new int[nvertices];
		edges = new EdgeNode[nvertices];
		
		m = scanner.nextInt();
		for (int i = 0; i < m; ++i) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			insertEdge(x, y, directed);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < this.nvertices; ++i) {
			b.append(i).append(": ");
			EdgeNode p = edges[i];
			while (p != null) {
				b.append(" ").append(p.y);
				p = p.next;
			}
			b.append("\n");
		}
		return b.toString();
	}
}
