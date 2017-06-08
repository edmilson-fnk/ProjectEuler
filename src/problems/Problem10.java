package problems;

import java.math.BigInteger;

public class Problem10 {

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below two million.
	 */
	public static void main(String[] args) {
		int limit = 2000000;
		
		boolean[] numbers = new boolean[limit + 1];
		for (int i = 0; i <= limit; i++) {
			numbers[i] = true;
		}
		
		BigInteger sum = BigInteger.ZERO;
		for (int i = 2; i <= limit; i++) {
			int pos = i*2;
			if (numbers[i]) sum = sum.add(BigInteger.valueOf(i));
			while (pos <= limit) {
				numbers[pos] = false;
				pos += i;
			}
		}
		
		showArray(numbers);
		System.out.println("Sum: " + sum);
	}

	private static void showArray(boolean[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]) System.out.printf("Number %d: %b\n", i, numbers[i]);
		}
	}
	
}
