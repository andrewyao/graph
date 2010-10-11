package graph;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class GraphTestHelper {

	static void readFromString(AdjacencyLists g, String s) {
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(s.getBytes("UTF-8"));
			g.read(is);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static AdjacencyLists getAdjacencyLists(String s, boolean directed) {
		AdjacencyLists g = new AdjacencyLists(directed);
		readFromString(g, s);
		return g;
	}

	public static BFSearch getBFSearch(String s, boolean directed) {
		BFSearch bfs = new BFSearch(directed);
		readFromString(bfs.g, s);
		bfs.init();
		bfs.ps = getPrintStream();
		return bfs;
	}

	public static DFSearch getDFSearch(String s, boolean directed) {
		DFSearch dfs = new DFSearch(directed);
		readFromString(dfs.g, s);
		dfs.init();
		dfs.ps = getPrintStream();
		return dfs;
	}
	
	public static ConnectedComponents getConnectedComponents(String s, boolean directed) {
		ConnectedComponents cc = new ConnectedComponents(directed);
		readFromString(cc.g, s);
		cc.init();
		cc.ps = getPrintStream();
		return cc;
	}
	
	public static ArticulationVertices getArticulationVertices(String s, boolean directed) {
		ArticulationVertices av = new ArticulationVertices(directed);
		readFromString(av.g, s);
		av.init();
		av.ps = getPrintStream();
		return av;
	}

	public static TwoColor getTwoColor(String s, boolean directed)
	{
		TwoColor tc = new TwoColor(directed);
		readFromString(tc.g, s);
		tc.init();
		tc.ps = getPrintStream();
		return tc;
	}
	
	public static PrintStream getPrintStream() {
		return new MyPrintStream();
	}

}
