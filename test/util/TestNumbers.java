package util;

import org.junit.Test;

import java.math.BigInteger;

import org.junit.Assert;

public class TestNumbers {

	@Test
	public void testEvenPrime() {
		Assert.assertTrue(Numbers.isPrime(new BigInteger("2")));
	}

	@Test
	public void testEvenPrime4() {
		Assert.assertFalse(Numbers.isPrime(new BigInteger("4")));
	}

	/**
	 * www.bigprimes.net
	 */
	@Test
	public void testBigPrime() {
		Assert.assertTrue(Numbers.isPrime(new BigInteger("15485867")));
	}

	@Test
	public void testPalindrome() {
		Assert.assertTrue(Numbers.isPalindrome(1001));
	}

	@Test
	public void testNotPalindrome() {
		Assert.assertFalse(Numbers.isPalindrome(1002));
	}

	@Test
	public void testBigPalindrome() {
		Assert.assertTrue(Numbers.isPalindrome(1234321));
	}

	@Test
	public void testEvenBiggerPalindrome() {
		Assert.assertTrue(Numbers.isPalindrome(12344321));
	}

	@Test
	public void testBigNotPalindrome() {
		Assert.assertFalse(Numbers.isPalindrome(123443210));
	}

	@Test
	public void testNinePalindrome() {
		Assert.assertTrue(Numbers.isPalindrome(999999999));
	}

	@Test
	public void testNextPrime1() {
		Assert.assertEquals(new BigInteger("2"), Numbers.nextPrime(BigInteger.ONE));
	}

	@Test
	public void testNextPrime2() {
		Assert.assertEquals(new BigInteger("3"), Numbers.nextPrime(new BigInteger("2")));
	}

	@Test
	public void testNextPrime3() {
		Assert.assertEquals(new BigInteger("5"), Numbers.nextPrime(new BigInteger("3")));
	}

	@Test
	public void testNextPrimeBigNum() {
		Assert.assertEquals(new BigInteger("7933"), Numbers.nextPrime(new BigInteger("7927")));
	}
	
}
