package problems.problems11to20;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem14 {

	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger MILLION = new BigInteger("100");

	private static Map<BigInteger, BigInteger> sequence = new HashMap<BigInteger, BigInteger>();
	private static Map<BigInteger, BigInteger> quantity = new HashMap<BigInteger, BigInteger>();

	// TODO can be improved by counting and sequencing at the same time.
	public static void main(String[] args) {
		BigInteger start = ONE;
		BigInteger end = MILLION;
		
		System.out.println("Filling...");
		do {
			start = start.add(ONE);
			
			fillSequence(start);
			
		} while (!start.equals(end));
		
		System.out.println("Counting...");
		start = ONE;
		quantity.put(ONE, ZERO);
		do {
			start = start.add(ONE);
			
			quantity.put(start, count(start));
			
		} while (!start.equals(end));
		
		System.out.print("Greatest: ");
		BigInteger maxQtd = ZERO;
		BigInteger max = ZERO;
		for (Entry<BigInteger, BigInteger> e : quantity.entrySet()) {
			BigInteger v = e.getValue();
			
			if (v.compareTo(maxQtd) > 0) {
				maxQtd = v;
				max = e.getKey();
			}
		}
		
		System.out.println(max);
	}
	
	private static BigInteger count(BigInteger num) {
		if (quantity.containsKey(num)) {
			return quantity.get(num);
		} else {
			return count(next(num)).add(ONE);
		}
	}
	
	private static void fillSequence(BigInteger num) {
		if (!sequence.containsKey(num) && !num.equals(ONE)) {
			BigInteger next = next(num);
			sequence.put(num, next);
			
			fillSequence(next);
		}
	}

	private static BigInteger next(BigInteger n) {
		if (n.remainder(TWO).equals(ZERO)) {
			return n.divide(TWO);
		} else {
			return n.multiply(THREE).add(ONE);
		}
	}
	
}
