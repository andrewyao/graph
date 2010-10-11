package graph;

import junit.framework.Assert;

import org.junit.Test;

/**
 * AdjacencyListsTest
 * @author Andrew
 *
 */
public class AdjacencyListsTest {
	@Test
	public void testRead() {
		String graph = "3 2\n" + "0 1\n" + "1 2\n";

		AdjacencyLists g = GraphTestHelper.getAdjacencyLists(graph, true);

		Assert.assertEquals(3, g.nvertices);
		Assert.assertEquals(2, g.nedges);
		Assert.assertEquals(1, g.degrees[0]);
		Assert.assertEquals(1, g.degrees[1]);
		Assert.assertEquals(0, g.degrees[2]);
	}

	@Test
	public void testToString() {
		String graph = "3 2\n" + "0 1\n" + "1 2\n";

		AdjacencyLists g = GraphTestHelper.getAdjacencyLists(graph, true);

		String expected = "0:  1\n" + "1:  2\n" + "2: \n";

		Assert.assertEquals(expected, g.toString());
	}

	@Test
	public void testToString1() {
		String graph = "3 2\n" + "0 1\n" + "1 2\n";

		AdjacencyLists g = GraphTestHelper.getAdjacencyLists(graph, false);

		String expected = "0:  1\n" + "1:  2 0\n" + "2:  1\n";

		Assert.assertEquals(expected, g.toString());
	}

}
