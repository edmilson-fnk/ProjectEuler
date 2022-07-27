package problems.Problems21to30;

import java.util.Arrays;

public class Problem21 {

    /**
     * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
     * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
     *
     * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
     *
     * Evaluate the sum of all the amicable numbers under 10000.
     */
    public static void main(String[] args) {
        int upper = 10000;

        int[] dOf = new int[upper+1];
        for (int i = 1; i <= upper; i++) {
            dOf[i] = d(i);
        }

        boolean[] isAmicable = new boolean[upper + 1];
        Arrays.fill(isAmicable, false);
        for (int i = 1; i <= upper; i++) {
            if (dOf[i] <= upper && dOf[i] != i && dOf[dOf[i]] == i) {
                isAmicable[i] = true;
            }
        }

        int sum = 0;
        for (int i = 1; i <= upper; i++) {
            if (isAmicable[i]) {
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    }

    public static int d(int n) {
        int d = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                d += i;
            }
        }
        return d;
    }

}
