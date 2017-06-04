package problems;

import java.math.BigInteger;

public class Problem8 {

	/**
	 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
	 * 
	 * 73167176531330624919225119674426574742355349194934
	 * 96983520312774506326239578318016984801869478851843
	 * 85861560789112949495459501737958331952853208805511
	 * 12540698747158523863050715693290963295227443043557
	 * 66896648950445244523161731856403098711121722383113
	 * 62229893423380308135336276614282806444486645238749
	 * 30358907296290491560440772390713810515859307960866
	 * 70172427121883998797908792274921901699720888093776
	 * 65727333001053367881220235421809751254540594752243
	 * 52584907711670556013604839586446706324415722155397
	 * 53697817977846174064955149290862569321978468622482
	 * 83972241375657056057490261407972968652414535100474
	 * 82166370484403199890008895243450658541227588666881
	 * 16427171479924442928230863465674813919123162824586
	 * 17866458359124566529476545682848912883142607690042
	 * 24219022671055626321111109370544217506941658960408
	 * 07198403850962455444362981230987879927244284909188
	 * 84580156166097919133875499200524063689912560717606
	 * 05886116467109405077541002256983155200055935729725
	 * 71636269561882670428252483600823257530420752963450
	 * 
	 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	 */
	public static void main(String[] args) {
		String sequence = 
				"73167176531330624919225119674426574742355349194934" +
				"96983520312774506326239578318016984801869478851843" +
				"85861560789112949495459501737958331952853208805511" +
				"12540698747158523863050715693290963295227443043557" +
				"66896648950445244523161731856403098711121722383113" +
				"62229893423380308135336276614282806444486645238749" +
				"30358907296290491560440772390713810515859307960866" +
				"70172427121883998797908792274921901699720888093776" +
				"65727333001053367881220235421809751254540594752243" +
				"52584907711670556013604839586446706324415722155397" +
				"53697817977846174064955149290862569321978468622482" +
				"83972241375657056057490261407972968652414535100474" +
				"82166370484403199890008895243450658541227588666881" +
				"16427171479924442928230863465674813919123162824586" +
				"17866458359124566529476545682848912883142607690042" +
				"24219022671055626321111109370544217506941658960408" +
				"07198403850962455444362981230987879927244284909188" +
				"84580156166097919133875499200524063689912560717606" +
				"05886116467109405077541002256983155200055935729725" +
				"71636269561882670428252483600823257530420752963450";
		int length = 13;
		
//		int times = 500;
//		long t0, tf, mean = 0;
//		
//		for (int i = 0; i < times; i++) {
//			t0 = System.nanoTime();
//			char[] digits = searchMethod(sequence.toCharArray(), length);
//			tf = System.nanoTime();
//			mean += (tf-t0)/times;
//		}
//		
//		System.out.println("Mean time: " + mean);
		
		char[] result = breakMethod(sequence, length);
		showResult(result);
	}

	static BigInteger maxProd = BigInteger.ONE;
	
	private static char[] breakMethod(String sequence, int length) {
		String[] splits = sequence.split("0");
		BigInteger localMaxProd = BigInteger.ONE;
		char[] maxDigits = new char[length];
		
		for (String split : splits) {
			if (split.length() > length) {
				char[] result = searchMethod(sequence.toCharArray(), length);
				if (maxProd.compareTo(localMaxProd) > 0) {
					System.arraycopy(result, 0, maxDigits, 0, result.length);
					localMaxProd = maxProd;
				}
			}
		}
		
		maxProd = localMaxProd;
		
		return maxDigits;
	}

	private static void showResult(char[] digits) {
		for (char c : digits) {
			System.out.print(c + " ");
		}
		System.out.println("Product: " + product(digits) +" \n");
	}

	private static char[] searchMethod(char[] sequence, int length) {
		// iterate to get the sequences with no zeros
		int max = sequence.length - length - 1;
		
		char[] digits = new char[length];
		char[] maxDigits = new char[length];
		
		for (int i = 0; i < max; i++) {
			for (int j = i; j < i + length; j++) {
				char element = sequence[j];
				if (element == '0') {
					i = j;
					break;
				} else {
					digits[j - i] = sequence[j];
				}
				
				if (j - i == length - 1) {
					BigInteger prod = product(digits);
					if (prod.compareTo(maxProd) > 0) {
						System.arraycopy(digits, 0, maxDigits, 0, digits.length);
						maxProd = prod;
					}
				}
			}
		}
		
		return maxDigits;
	}

	private static BigInteger product(char[] digits) {
		BigInteger prod = BigInteger.ONE;
		for (char c : digits) {
			prod = prod.multiply(new BigInteger(Character.toString(c)));
		}
		
		return prod;
	}
	
}
