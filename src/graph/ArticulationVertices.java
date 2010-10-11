package graph;

public class ArticulationVertices extends DFSearch {

	ArticulationVertices(boolean directed) {
		super(directed);
	}

	int[] reachableAncestor;
	int[] treeOutDegree;

	@Override
	void processVertexEarly(int v) {
		super.processVertexEarly(v);
		reachableAncestor[v] = v;
	}

	@Override
	void init() {
		super.init();
		reachableAncestor = new int[g.nvertices];
		treeOutDegree = new int[g.nvertices];
	}

	@Override
	void processEdge(int x, int y) {

		super.processEdge(x, y);
		
		Edge c = edgeClassification(x, y);

		if (c == Edge.TREE) {
			treeOutDegree[x] = treeOutDegree[x] + 1;
		}

		if (c == Edge.BACK && parent[x] != y) {
			if (entry_time[y] < entry_time[reachableAncestor[x]]) {
				reachableAncestor[x] = y;
			}
		}
	}

	Edge edgeClassification(int x, int y) {
		if (parent[y] == x) {
			return Edge.TREE;
		}
		if (discovered[y] && !processed[y]) {
			return Edge.BACK;
		}

		if (processed[y] && (entry_time[y] > entry_time[x])) {
			return Edge.FORWARD;
		}
		
		if (processed[y] && (entry_time[y] < entry_time[x])) {
			return Edge.CROSS;
		}

		ps.printf("Warning: unclassified edge (%d, %d)\n", x, y);

		return Edge.UNCLASSIFIED;
	}

	@Override
	void processVertexLate(int v) {
		
		super.processVertexLate(v);
		
		boolean root;
		int time_v;
		int time_parent;

		if (parent[v] < 1) {
			if (treeOutDegree[v] > 1) {
				ps.printf("root articulation vertex: %d \n", v);
			}
			return;
		}

		root = parent[parent[v]] < 1;

		if (reachableAncestor[v] == parent[v] && !root) {
			ps.printf("parent articulation vertex: %d \n", parent[v]);
		}
		
		if (reachableAncestor[v] == v) {
			ps.printf("bridge articulation vertex: %d \n", parent[v]);

			if (treeOutDegree[v] > 0) {
				ps.printf("bridge articulation vertex: %d \n", v);
			}
		}

		time_v = entry_time[reachableAncestor[v]];
		time_parent = entry_time[reachableAncestor[parent[v]]];

		if (time_v < time_parent) {
			reachableAncestor[parent[v]] = reachableAncestor[v];
		}
	}

	enum Edge {
		BACK, TREE, FORWARD, CROSS, UNCLASSIFIED;
	}
}
