package graph;

public class Prim {

	/**
	 * Prim's algorithm grows the minimum spanning tree in stages, starting from a given vertex. 
	 * At each iteration, we add one new vertex into the spanning tree.
	 * 
	 * We always add the lowest weight edge linking a vertex in 
	 * the tree to a vertex on the outside.
	 * 
	 * @param g
	 * @param start
	 */
	void prim(AdjacencyLists g, int start)
	{
		// whether the node is in the tree or not.
		boolean[] intree = new boolean[g.nvertices];
		
		// the cost of adding the edge to the tree
		int[] distance = new int[g.nvertices];
		
		int[] parent = new int[g.nvertices]; 
		
		for (int i = 0; i < g.nvertices; ++i) {
			intree[i] = false;
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		
		distance[start] = 0;
		
		// current vertex to process
		int v = start;
		// candidate next vertex
		int w; 
		// edge weight
		int weight;
		// best current distance from start
		int dist;
		
		while (!intree[v]) {
			intree[v] = true;
			
			EdgeNode p = g.edges[v];
			
			// for each node w that is not in the tree
			// identify the lowest cost
			while (p != null) {
				w = p.y;
				weight = p.weight;
				if (!intree[w] && distance[w] > weight) {
					// pick the edge that is lowest cost from v.
					distance[w] = weight;
					parent[w] = v;
				}
				p = p.next;
			}
			
			// find the node that is not in the list, 
			// and has the smallest distance value.
			v = 0;
			dist = Integer.MAX_VALUE;
			for (int i = 0; i < g.nvertices; ++i) {
				if (!intree[i] && dist > distance[i]) {
					dist = distance[i];
					v = i;
				}
			}
		}
	}
}
