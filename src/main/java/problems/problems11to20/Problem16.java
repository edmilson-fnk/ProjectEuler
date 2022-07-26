package problems.problems11to20;

import java.math.BigInteger;

import util.Numbers;

public class Problem16 {

	/**
	 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * 
	 * What is the sum of the digits of the number 2^1000?
	 * 
	 */
	public static void main(String[] args) {
		BigInteger two = new BigInteger("2");
		
		BigInteger result = two.pow(1000);
		
		System.out.println(Numbers.sumDigits(result));
	}
	
}
