package problems.problems01to09;

import java.math.BigInteger;

import util.Numbers;

public class Problem7 {

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * 
	 * What is the 10 001st prime number?
	 */
	public static void main(String[] args) {
		// TODO  this is dumb code, implement something using the Sieve of Eratosthenes
		int n = 10001;
		
		BigInteger prime = new BigInteger("2");
		for (int i = 1; i < n; i++) {
			prime = Numbers.nextPrime(prime);
		}
		
		System.out.println(prime);
	}
	
}
