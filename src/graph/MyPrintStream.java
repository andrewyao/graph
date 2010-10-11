package graph;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyPrintStream extends PrintStream {

	private ByteArrayOutputStream stream;
	
	public MyPrintStream()
	{
		super(new ByteArrayOutputStream());
		this.stream = (ByteArrayOutputStream) out;
	}
	
	@Override
	public String toString()
	{
		return this.stream.toString();
	}
}
