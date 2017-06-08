package util;

import java.math.BigInteger;

public class Numbers {

	// TODO this is dumb code, make it smarter
	public static boolean isPrime(BigInteger num) {
		BigInteger two = new BigInteger("2");
		
		if (num.compareTo(two) <= 0) return true;
		if (num.mod(two).equals(BigInteger.ZERO)) return false;
		
		BigInteger division = num.divide(two);
		
		for (BigInteger i = two; i.compareTo(division) < 0; i = i.add(BigInteger.ONE)) {
			if (num.mod(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @return Gives you the lowest prime greater than i
	 */
	public static BigInteger nextPrime(BigInteger i) {
		BigInteger two = new BigInteger("2");
		
		if (i.compareTo(BigInteger.ONE) == 0)  return two;
		if (i.compareTo(two) == 0) return new BigInteger("3");
		
		do {
			i = i.add(two);
		} while (!isPrime(i));
		
		return i;
	}
	
	public static boolean isPalindrome(int num) {
		int p = 0;
		int[] array = new int[10];
		
		while (num > 0) {
			int i = num % 10;
			num = num / 10;
			array[p++] = i;
		}
		
		int half = p/2;
		int i = 0;
		while (p > half) {
			if (array[--p] != array[i++]) return false;
		}
		
		return true;
	}

	public static boolean isPerfectSquare(int num) {
		int end = num % 10;
		if (end == 2 || end == 3 || end == 7 || end == 8) {
			return false;
		} else {
			int root = getDigitalRoot(num);
			if (root != 0 && root != 1 && root != 4 && root != 7) {
				return false;
			} else {
				int sqrt = (int) Math.sqrt(num);
				return num == sqrt*sqrt;
			}
		}
	}

	public static int getDigitalRoot(int num) {
		int root = 0;
		while (num > 0) {
			root += num % 10;
			num = num/10;
			if (root >= 9) root -= 9;
		}
		
		return root;
	}
	
}
