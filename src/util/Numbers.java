package util;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Numbers {

	// TODO this is dumb code, make it smarter
	public static boolean isPrime(BigInteger num) {
		BigInteger two = new BigInteger("2");
		
		if (num.compareTo(two) <= 0) return true;
		
		BigInteger division = num.divide(two);
		
		for (BigInteger i = two; i.compareTo(division) < 0; i = i.add(BigInteger.ONE)) {
			if (num.mod(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		
		return true;
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
	
	public static Map<Integer, Integer> decompose(int num) {
		Map<Integer, Integer> decomposition = new TreeMap<Integer, Integer>();
		
		while (num > 1) {
			
		}
		
		return decomposition;
	}
	
}
