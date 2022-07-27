package problems.problems11to20;

import java.util.Arrays;

public class Problem20 {

    /**
     * n! means n × (n − 1) × ... × 3 × 2 × 1
     *
     * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
     * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
     *
     * Find the sum of the digits in the number 100!
     */
    public static void main(String[] args) {
        int lower = 1;
        int upper = 100;

        Integer[] number = new Integer[1000];
        Arrays.fill(number, 0);
        number[0] = 1;
        for (int i = lower; i <= upper; i++) {
            multiply(number, i);
        }

        int sum = 0;
        for (Integer integer : number) {
            sum += integer;
        }

        System.out.println("Sum: " + sum);
    }

    public static void multiply(Integer[] thisNumber, Integer byThisNumber) {
        int carry = 0;
        for (int i = 0; i < thisNumber.length; i++) {
            int result = carry + thisNumber[i] * byThisNumber;
            carry = result / 10;
            thisNumber[i] = result % 10;
        }
    }

}
