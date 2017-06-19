package problems.problems01to09;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {

	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
	 * By starting with 1 and 2, the first 10 terms will be:
	 *  
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 *  
	 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
	 * find the sum of the even-valued terms.
	 */
	public static void main(String[] args) {
		System.out.println("https://projecteuler.net/problem=2\n");
		
		int max = 4000000;
		
		List<Integer> fib = fibonacci(max);
		System.out.println(fib);
		
		sumFibonacci(max);
	}		

	private static List<Integer> fibonacci(int max) {
		List<Integer> fib = new LinkedList<Integer>();
		
		int num1 = 1;
		int num2 = 2;
		
		fib.add(num1);
		fib.add(num2);
		
		int next = num1 + num2;
		while (next < max) {
			fib.add(next);
			next = next + num2;
			num2 = next - num2;
		}
		
		return fib;
	}
	
	private static void sumFibonacci(int max) {
		int num1 = 1;
		int num2 = 2;
		
		int next = num1 + num2;
		int sum = 2;
		while (next < max) {
			if (next % 2 == 0) sum += next;
			
			next = next + num2;
			num2 = next - num2;
		}
		
		System.out.println("Sum of even: " + sum);
	}

	
}