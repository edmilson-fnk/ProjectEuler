package problems;

import java.math.BigInteger;

import util.Numbers;

public class Problem3 {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29
	 * 
	 * What is the largest prime factor of the number 600851475143?
	 */
	public static void main(String[] args) {
		BigInteger num = new BigInteger("600851475143"); // 1471 * 839 * 71 * 6857
		
		BigInteger max = BigInteger.ONE;
		
		for (BigInteger i = new BigInteger("3"); i.compareTo(num) <= 0; i = i.add(new BigInteger("2"))) {
			
			if (num.mod(i).equals(BigInteger.ZERO) && Numbers.isPrime(i)) {
				num = num.divide(i);
				max = i;
			}
		}
		
		System.out.println(max);
	}
	
}
