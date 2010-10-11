package graph;

public class ConnectedComponents extends BFSearch {

	ConnectedComponents(boolean directed) {
		super(directed);
	}

	@Override
	void run() {

		int c = 0;

		for (int i = 0; i < g.nvertices; ++i) {
			if (!discovered[i]) {
				c = c + 1;
				ps.printf("Component %d:", c);
				bfs(i);
				ps.printf("\n");
			}
		}
	}

	@Override
	void processVertexEarly(int v) {
		ps.printf(" %d", v);
	}

	@Override
	void processEdge(int x, int y) {
	}
}
