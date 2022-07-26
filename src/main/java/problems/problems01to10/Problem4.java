package problems.problems01to10;

import util.Numbers;

public class Problem4 {

	/**
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digt number is 9009 = 91 * 99
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(String[] args) {
		dumbCode();
		dumbCode2();
	}

	
	private static long dumbCode2() {
		long t0 = System.nanoTime();
		boolean foundit = false;
		
		int i = 999*999;
		while (!foundit) {
			if (Numbers.isPalindrome(i)) {
				for (int j = 999; j > 100; j--) {
					if (i % j == 0) {
						int q = i / j;
						if (q > 100 && q < 999) {
							foundit = true;
							break;
						}
					}
				}
			}
			
			i--;
		}
		
		long tf = System.nanoTime();
		
		System.out.println("N: " + (i+1));
		
		return tf - t0;
		
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
		
		System.out.println("N: " + max);
		
		return tf - t0;
	}
	
}
