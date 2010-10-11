package graph;

import junit.framework.Assert;

import org.junit.Test;

public class TwoColorTest {

	@Test
	public void testTwoColor() {
		String graph = "6 4\n" + "0 1\n" + "1 2\n" + "3 4\n" + "4 5\n";

		TwoColor g = GraphTestHelper.getTwoColor(graph, true);

		g.run();

		String s = g.ps.toString();
		Assert.assertEquals("The graph is a bipartite.", s);
	}

	@Test
	public void testTwoColor1() {
		String graph = "6 3\n" + "0 1\n" + "1 2\n" + "2 0\n";

		TwoColor g = GraphTestHelper.getTwoColor(graph, true);

		g.run();

		String s = g.ps.toString();
		Assert.assertEquals("The graph is not a bipartite.", s);
	}
	
}
