package util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Factors {

	public static BigInteger compose(Map<BigInteger, BigInteger> factors) {
		BigInteger number = BigInteger.ONE;
		for (BigInteger k : factors.keySet()) {
			number = number.multiply(k.pow(factors.get(k).intValue()));
		}
		
		return number;
	}
	
	public static Map<BigInteger, BigInteger> decompose(BigInteger num) {
		Map<BigInteger, BigInteger> decomposition = new TreeMap<BigInteger, BigInteger>();
//		decomposition.put(BigInteger.ONE, BigInteger.ONE);
		
		BigInteger i = BigInteger.ONE;
		while (!num.equals(BigInteger.ONE)) {
			i = Numbers.nextPrime(i);
			while (num.mod(i).equals(BigInteger.ZERO)) {
				num = num.divide(i);
				
				if (!decomposition.containsKey(i)) {
					decomposition.put(i, BigInteger.ZERO);
				}
				
				decomposition.put(i, decomposition.get(i).add(BigInteger.ONE));
			}
		}
		
		return decomposition;
	}

	public static Map<BigInteger, BigInteger> mmc(Map<BigInteger, BigInteger> n1, Map<BigInteger, BigInteger> n2) {
		Set<BigInteger> keys = new TreeSet<BigInteger>();
		keys.addAll(n1.keySet());
		keys.addAll(n2.keySet());
		
		Map<BigInteger, BigInteger> result = new HashMap<BigInteger, BigInteger>();
		for (BigInteger key : keys) {
			result.put(key, greatest(n1.get(key), n2.get(key)));
		}
		
		return result;
	}

	private static BigInteger greatest(BigInteger n1, BigInteger n2) {
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		return n1.compareTo(n2) > 0 ? n1 : n2;
	}

}
