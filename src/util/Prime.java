package util;

import java.math.BigInteger;

public class Prime {

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
	
}
