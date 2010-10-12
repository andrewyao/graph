package graph;

public class Kruskal {

	void kruskal(AdjacencyLists g) {
		SetUnion s = new SetUnion();
		EdgePair[] e;
		
		s.init(g.nvertices);
		
		int j = 0;
		e = new EdgePair[g.nedges];
		for (int i = 0; i < g.nvertices; ++i) {
			EdgeNode p = g.edges[i];
			while (p != null) {
				int x = i;
				int y = p.y;
				
				e[j++] = new EdgePair(x, y);
				p = p.next;
			}
		}
		
		for (int i = 0; i < g.nedges; ++i) {
			if (s.sameComponent(e[i].x, e[i].y)) {
				s.union(e[i].x, e[i].y);
			}
		}
	}
	
	public static class EdgePair {
		public int x;
		public int y;
		
		public EdgePair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
