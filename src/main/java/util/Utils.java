package util;

import java.util.Arrays;

public class Utils {

	public static void show(Object[] array) {
		System.out.println(arrayToString(array));
	}

	public static void show(Object[][] array) {
		Arrays.stream(array).forEach(it -> show(it));
	}
	
	private static String arrayToString(Object[] array) {
		StringBuilder sb = new StringBuilder();
		
		Arrays.stream(array).forEach(it -> sb.append(it.toString() + " "));
		
		return sb.toString();
	}
	
}
