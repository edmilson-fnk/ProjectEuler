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

	@Test
	public void testDigitalRoot1() {
		Assert.assertEquals(1, Numbers.getDigitalRoot(100));
	}

	@Test
	public void testDigitalRoot2() {
		Assert.assertEquals(1, Numbers.getDigitalRoot(1999));
	}

	@Test
	public void testDigitalRoot3() {
		Assert.assertEquals(8, Numbers.getDigitalRoot(1934));
	}

	@Test
	public void testDigitalRoot4() {
		Assert.assertEquals(3, Numbers.getDigitalRoot(59934));
	}

	@Test
	public void testPerfectSquare1() {
		Assert.assertTrue(Numbers.isPerfectSquare(7*7));
	}

	@Test
	public void testPerfectSquare2() {
		Assert.assertTrue(Numbers.isPerfectSquare(9*9));
	}

	@Test
	public void testPerfectSquare3() {
		Assert.assertTrue(Numbers.isPerfectSquare(100*100));
	}

	@Test
	public void testPerfectSquare4() {
		Assert.assertFalse(Numbers.isPerfectSquare(1000*1001));
	}

	@Test
	public void testPerfectSquare5() {
		Assert.assertFalse(Numbers.isPerfectSquare(997*997 + 1));
	}

	@Test
	public void testSumDigits10() {
		Assert.assertEquals(10, Numbers.sumDigits(new BigInteger("1009")));
	}

	@Test
	public void testSumDigitsLower10() {
		Assert.assertEquals(8, Numbers.sumDigits(new BigInteger("12311")));
	}

	@Test
	public void testSumDigitsGreater10() {
		Assert.assertEquals(13, Numbers.sumDigits(new BigInteger("123115")));
	}
	
}
