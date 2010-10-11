package graph;

import org.junit.Test;

public class ArticulationVerticesTest {

	@Test
	public void testAV() {
		String graph = "12 15\n" +
			"0 1\n" + 
			"1 2\n" +
			"0 2\n" +
			"2 3\n" +
			"3 4\n" + 
			"3 5\n" + 
			"4 5\n" +
			"0 6\n" +
			"6 7\n" +
			"0 7\n" +
			"7 8\n" +
			"7 9\n" +
			"8 9\n" +
			"9 10\n" +
			"8 10\n" +
			"";

		ArticulationVertices g = GraphTestHelper.getArticulationVertices(graph, false);

		g.dfs(0);

		String output = g.ps.toString();
		System.out.println(output);
	}	
	
}
