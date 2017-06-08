package problems;

public class Problem9 {

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
	 *                    a^2 + b^2 = c^2
	 * 
	 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 */
	public static void main(String[] args) {
		// a + b + c = 1000
		// a < b < c
		// a^2 + b^2 = c^2
		
		int MAX = 1000;
		int MIN = 100;
		
		for (int c = MAX; c >= MIN; c--) {
			for (int b = MAX - c; b >= MIN; b--) {
				int a = MAX - c - b;
				if (a > 100 && a*a + b*b == c*c) {
					System.out.printf("A: %d\nB: %d\nC: %d\n\n", a, b, c);
					System.out.println(a*b*c);
					break;
				}
			}
		}
	}
	
}
