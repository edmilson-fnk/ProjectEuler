package problems.problems11to20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // day0 = 0, 1 Jan 1900 was a Monday and it's day zero
        int day0XX = (isLeapYear(1900) ? 366 : 365);

        // get num of days in XX
        int firstYear = 1901;
        int lastYear = 2000;
        int numYears = lastYear - firstYear + 1;
        int firstLeapYearXX = getFirstLeapYearAfter(firstYear);
        int lastLeapYearXX = getFirstLeapYearAfter(lastYear);
        int numLeapYears = (int) Math.ceil(((double) lastLeapYearXX - firstLeapYearXX + 1) / 4);
        int numNonLeapYears = numYears - numLeapYears;
        int numDays = numLeapYears * 366 + numNonLeapYears * 365;

        // build a boolean a1 array where true is 1st day of month
        boolean[] firstOfMonth = new boolean[numDays];
        Arrays.fill(firstOfMonth, false);
        firstOfMonth[0] = true;  // 1st of January, 1901
        for (int i = 0, m = 0, y = firstYear; ; m = (m+1)%12) {
            y += m / 11;
            int numDaysMonth = getNumDaysMonth(y, m);
            i += numDaysMonth;
            if (i < firstOfMonth.length) {
                firstOfMonth[i] = true;
            } else {
                System.out.println("broke");
                break;
            }
        }

        // build a boolean a2 array where true is sunday
        boolean[] itsSunday = new boolean[numDays];
        Arrays.fill(itsSunday, false);
        for (int i = getFirstSundayAfter(day0XX-1) - day0XX; i < itsSunday.length; i += 7) {
            itsSunday[i] = true;
        }

        // count positions i where a1[i] && a2[i]
        int firstMonthSundays = 0;
        for (int i = 0; i < numDays; i++) {
            if (itsSunday[i] && firstOfMonth[i]) {
                System.out.println(itsSunday[i]);
                System.out.println(firstOfMonth[i]);
                firstMonthSundays++;
            }
        }

        System.out.println("Number of Sundays that fell on the first of the month:");
        System.out.println(firstMonthSundays);
    }

    // Method below is inclusive
    public static int getFirstLeapYearAfter(int year) {
        int leapYear = year;
        while (!isLeapYear(leapYear)) {
            leapYear++;
        }
        return leapYear;
    }

    public static int getFirstSundayAfter(int day) {
        return day + (6 - day % 7);
    }

    public static boolean isSunday(int day) {
        return day % 7 == 6;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static int getNumDaysMonth(int year, int month) {
        HashMap<Integer, Integer> daysForMonths = new HashMap<Integer, Integer>() {{
            this.put(0, 31);
            this.put(1, isLeapYear(year) ? 29 : 28);
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

        return daysForMonths.get(month);
    }

}
