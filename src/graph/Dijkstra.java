package graph;

public class Dijkstra {

	boolean[] intree;
	int[] distance;
	int[] parent;

	void dijkstra(AdjacencyLists g, int start) {
		
		init(g);

		int v = start;
		distance[v] = 0;
		
		while (!intree[v]) {
			intree[v] = true;
			
			EdgeNode p = g.edges[v];
			while (p != null) {
				int y = p.y;
				int weight = p.weight;
				
				if (distance[y] > distance[v] + weight) {
					distance[y] = distance[v] + weight;
					parent[y] = v;
				}
				
				p = p.next;
			}
			v = findMinimum(g);
		}
	}
	
	int findMinimum(AdjacencyLists g) {
		// Find the minimum of distance
		int v = 0;
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < g.nvertices; ++i) {
			if (!intree[i] && dist > distance[i]) {
				dist = distance[i];
				v = i;
			}
		}
		return v;
	}
	
	void init(AdjacencyLists g) {
		intree = new boolean[g.nvertices];
		distance = new int[g.nvertices];
		parent = new int[g.nvertices];
		
		for (int i = 0; i < g.nvertices; ++i) {
			intree[i] = false;
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
	}
}
