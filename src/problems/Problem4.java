package problems;

import util.Numbers;

public class Problem4 {

	/**
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digt number is 9009 = 91 * 99
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(String[] args) {
		int times = 50;
		long sum = 0;
		
		for (int i = 0; i < times; i++) {
			sum += dumbCode();
		}
		
		System.out.println("Mean time: " + (sum / times));
	}

	// TODO make it smarter
	private static long dumbCode() {
		long t0 = System.nanoTime();
		int max = 99;
		
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				int prod = i * j;
				
				if (!Numbers.isPalindrome(prod)) continue;
				
				if (prod > max) {
					max = prod;
				} else {
					break;
				}
			}
		}
		long tf = System.nanoTime();
		
//		System.out.println(max);
		
		return tf - t0;
	}
	
}
