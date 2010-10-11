package graph;

import junit.framework.Assert;

import org.junit.Test;

public class DFSearchTest {
	@Test
	public void testDFS() {
		String graph = "3 2\n" + "0 1\n" + "0 2\n" + "1 2\n";

		DFSearch g = GraphTestHelper.getDFSearch(graph, true);

		g.dfs(0);

		for (int i = 0; i < 3; ++i) {
			Assert.assertTrue(g.discovered[i]);
			Assert.assertTrue(g.processed[i]);
		}
	}

	@Test
	public void testDFS1() {
		String graph = "6 7\n" +
			"0 1\n" + 
			"0 5\n" +
			"5 4\n" +
			"1 2\n" + 
			"2 3\n" + 
			"3 4\n" +
			"4 1\n" +
			"";

		DFSearch g = GraphTestHelper.getDFSearch(graph, true);

		g.dfs(0);

		String output = g.ps.toString();
		System.out.println(output);
	}
	
	@Test
	public void testDFS2() {
		String graph = "6 7\n" +
			"0 1\n" + 
			"0 5\n" +
			"5 4\n" +
			"1 2\n" + 
			"2 3\n" + 
			"3 4\n" +
			"4 1\n" +
			"";

		DFSearch g = GraphTestHelper.getDFSearch(graph, true);

		g.dfsRecursive(0);

		String output = g.ps.toString();
		System.out.println(output);
	}	

}
