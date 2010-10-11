package graph;

public class TwoColor extends BFSearch {

	TwoColor(boolean directed) {
		super(directed);
	}

	private Color[] color;
	private boolean bipartite;

	@Override
	void init() {
		color = new Color[g.nvertices];
		for (int i = 0; i < g.nvertices; ++i) {
			color[i] = Color.UNCOLORED;
		}

		bipartite = true;

	}

	@Override
	void run() {
		for (int i = 0; i < g.nvertices; ++i) {
			if (!discovered[i]) {
				color[i] = Color.WHITE;
				bfs(i);
			}
		}
		if (bipartite) {
			ps.printf("The graph is a bipartite.");
		} else {
			ps.printf("The graph is not a bipartite.");
		}
	}

	@Override
	void processEdge(int x, int y) {
		if (color[x] == color[y]) {
			bipartite = false;
		}
		color[y] = complement(color[x]);
	}

	Color complement(Color c) {
		if (c == Color.WHITE) {
			return Color.BLACK;
		} else if (c == Color.BLACK) {
			return Color.WHITE;
		} else {
			return Color.UNCOLORED;
		}
	}

	@Override
	void processVertexEarly(int v) {
	}

	enum Color {
		WHITE, BLACK, UNCOLORED;
	}
}
