package graph;

import org.junit.Test;

public class Categorize {

	public enum Category {
		Low, Medium, High;
	}
	
	Category getCategory(int n)
	{
		if (n < 10) {
			return Category.Low;
		} else if (n < 20) {
			return Category.Medium;
		} else {
			return Category.High;
		}
	}
	
	void categorize(int[] n) {
		
		int lend = 0;
		int hstart = n.length;
		
		int i = 0;
		debug(n);
		while (i < hstart) {
			Category c = getCategory(n[i]);
			if (c == Category.Low) {
				swap(n, i++, lend++);
			} else if (c == Category.High) {
				swap(n, i, --hstart);
			} else if (c == Category.Medium){
				i++;
			}
			// debug(n);
			// System.out.println("i " + i + " lend:" + lend + " hstart:" + hstart);
		}
		System.out.println("Done");
	}
	
	void swap(int[] n, int i, int j) {
		int t = n[i];
		n[i] = n[j];
		n[j] = t;
	}
	
	void debug(int[] n) {
		for (int i = 0; i < n.length; ++i) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
	
	@Test
	public void test() {
		
		int[] n = new int[100];
		for (int i = 0; i < n.length; ++i) {
			n[i] = (int) (Math.random() * 30);
		}
		categorize(n);
		debug(n);
	}
}
