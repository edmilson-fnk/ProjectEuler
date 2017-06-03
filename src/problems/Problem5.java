package problems;

import java.math.BigInteger;
import java.util.Map;

import util.Factors;

public class Problem5 {

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible [1] by all of the numbers from 1 to 20?
	 * 
	 * [1] Divisible with no remainder
	 * 
	 */
	public static void main(String[] args) {
		BigInteger twenty = new BigInteger("20");
		
		showResult(twenty);
	}

	private static void showResult(BigInteger twenty) {
		Map<BigInteger, BigInteger> start = Factors.decompose(BigInteger.ONE);
		for (BigInteger i = new BigInteger("2"); i.compareTo(twenty) < 0 ; i = i.add(BigInteger.ONE)) {
			start = Factors.mmc(start, Factors.decompose(i));
		}
		
		System.out.println(Factors.compose(start));
	}
	
}
