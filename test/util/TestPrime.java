package util;

import org.junit.Test;

import java.math.BigInteger;

import org.junit.Assert;

public class TestPrime {

	@Test
	public void testEvenPrime() {
		Assert.assertEquals(true, Prime.isPrime(new BigInteger("2")));
	}

	/**
	 * www.bigprimes.net
	 */
	@Test
	public void testBigPrime() {
		Assert.assertEquals(true, Prime.isPrime(new BigInteger("15485867")));
	}
	
}
