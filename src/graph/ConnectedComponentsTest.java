package graph;

import junit.framework.Assert;

import org.junit.Test;

public class ConnectedComponentsTest {

	@Test
	public void testConnectedComponents() {
		String graph = "6 4\n" + "0 1\n" + "1 2\n" + "3 4\n" + "4 5\n";

		ConnectedComponents g = GraphTestHelper.getConnectedComponents(graph, true);

		g.run();

		for (int i = 0; i < 3; ++i) {
			Assert.assertTrue(g.discovered[i]);
			Assert.assertTrue(g.processed[i]);
			Assert.assertEquals(i - 1, g.parent[i]);
		}
		
		String s = g.ps.toString();
		System.out.println(s);
	}

}
