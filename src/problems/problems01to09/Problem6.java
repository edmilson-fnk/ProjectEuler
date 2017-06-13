package problems.problems01to09;

import java.math.BigInteger;

public class Problem6 {

	/**
	 * The sum of the squares of the first ten natural numbers is,
	 * 
	 *       1^2 + 2^2 + ... + 10^2 = 385
	 * 
	 * The square of the sum of the first ten natural numbers is,
	 * 
	 *       (1 + 2 + ... + 10)^2 = 55^2 = 3025
	 * 
	 * Hence the difference between the sum of the squares of the first ten
	 * natural numbers and the square of the sum is 3025 - 385 = 2640
	 *  
	 * Find the difference between the sum of the squares of the first one 
	 * hundred natural numbers and the square of the sum.
	 */
	public static void main(String[] args) {
		BigInteger n = new BigInteger("100");
		
		solveIt(n);
	}

	private static void solveIt(BigInteger n) {
		BigInteger sum1 = sumSquares(n);
		BigInteger sum2 = squareSum(n);
		
		System.out.println(sum2.subtract(sum1));
	}

	private static BigInteger squareSum(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			sum = sum.add(i);
		}
		
		return sum.pow(2);
	}

	private static BigInteger sumSquares(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			sum = sum.add(i.pow(2));
		}
		
		return sum;
	}
	
}
