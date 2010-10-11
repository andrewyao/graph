package graph;

import junit.framework.Assert;

import org.junit.Test;

public class BFSearchTest {

	@Test
	public void testBFS() {
		String graph = "3 2\n" + "0 1\n" + "1 2\n";

		BFSearch g = GraphTestHelper.getBFSearch(graph, true);
		
		g.bfs(0);

		for (int i = 0; i < 3; ++i)
		{
			Assert.assertTrue(g.discovered[i]);
			Assert.assertTrue(g.processed[i]);
			Assert.assertEquals(i-1, g.parent[i]);
		}
	}

	@Test
	public void testBFS1() {
		String graph = "3 3\n" + "0 1\n" + "1 2\n" + "2 0\n";

		BFSearch g = GraphTestHelper.getBFSearch(graph, true);
		
		g.bfs(1);

		for (int i = 0; i < 3; ++i)
		{
			Assert.assertTrue(g.discovered[i]);
			Assert.assertTrue(g.processed[i]);
		}
		Assert.assertEquals(2, g.parent[0]);
		Assert.assertEquals(-1, g.parent[1]);
		Assert.assertEquals(1, g.parent[2]);
		
		String output = g.ps.toString();
		System.out.println(output);
	}
}
