package graph;

public class SetUnion {
	int[] parent;
	int[] size;

	void init(int n) {
		parent = new int[n];
		size = new int[n];
	}

	int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}

	void union(int s1, int s2) {
		int r1, r2;
		r1 = find(s1);
		r2 = find(s2);

		if (r1 == r2) {
			return;
		}

		if (size[r1] > size[r2]) {
			size[r1] = size[r1] + size[r2];
			parent[r2] = r1;
		} else {
			size[r2] = size[r1] + size[r2];
			parent[r1] = r2;
		}
	}

	boolean sameComponent(int s1, int s2) {
		return (find(s1) == find(s2));
	}

}
