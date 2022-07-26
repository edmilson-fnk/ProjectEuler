package problems.problems01to10;

public class Problem1 {

	/**
	 * Multiples of 3 and 5
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	public static void main(String[] args) {
		System.out.println("https://projecteuler.net/problem=1\n");
		
		int num1 = 3;
		int num2 = 5;
		
		int start = 0;
		int end = 1000;
		
		long t0 = System.nanoTime();
		smartCode(num1, num2, start, end);
		long tf = System.nanoTime();
		System.out.println((tf - t0) + " nano\n");
		
		t0 = System.nanoTime();
		bruteCode(num1, num2, start, end);
		tf = System.nanoTime();
		System.out.println((tf - t0) + " nano");
	}

	private static void bruteCode(int num1, int num2, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			if (i%num1 == 0 || i%num2 == 0) {
				sum += i;
			}
		}
		
		System.out.println("Sum by brute code: " + sum);
	}
	
	private static void smartCode(int num1, int num2, int start, int end) {
		int sum1 = sum(num1, start, end);
		int sum2 = sum(num2, start, end);
		int sum3 = sum(num1 * num2, start, end);
		
		int finalsum = sum1 - sum3 + sum2;
		
		System.out.println("Sum by smart code: " + finalsum);
	}

	private static int sum(int num, int start, int end) {
		int sum = 0, a = start;
		while (a % num != 0) {
			a++;
		}
		
		for (int i = a; i < end; i += num) {
			sum += i;
		}
		
		return sum;
	}
	
}
