package problems.problems11to20;

import java.util.HashMap;

public class Problem19 {

    /**
     * You are given the following information, but you may prefer to do some research for yourself.
     *
     * 1 Jan 1900 was a Monday.
     * Thirty days has September,
     * April, June and November.
     * All the rest have thirty-one,
     * Saving February alone,
     * Which has twenty-eight, rain or shine.
     * And on leap years, twenty-nine.
     * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
     * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
     */
    public static void main(String[] args) {
        int day0 = 0; // 1 Jan 1900 was a Monday
//        int day0_XX = day0 + getDaysOnMonths()
    }

    public static HashMap<Integer, Integer> getDaysOnMonths(boolean leapYear) {
        return new HashMap<Integer, Integer>() {{
            this.put(0, 31);
            this.put(1, leapYear ? 29 : 28);
            this.put(2, 31);
            this.put(3, 30);
            this.put(4, 31);
            this.put(5, 30);
            this.put(6, 31);
            this.put(7, 31);
            this.put(8, 30);
            this.put(9, 31);
            this.put(10, 30);
            this.put(11, 31);
        }};
    }

    public static boolean isLeapYear(int num) {
        return num % 4 == 0 && (num % 100 != 0 || num % 400 == 0);
    }

}
