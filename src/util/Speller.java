package util;

import java.util.LinkedList;

public class Speller {

	public static void main(String[] args) {
		System.out.println(spell(1500));
	}
	
	/**
	 * Spell from 0 to a thousand;
	 * 
	 */
	public static String spell(int num) {
		LinkedList<String> list = new LinkedList<String>();
		
		if (num < 10) list.add(unit(num));
		
		String[] result = Integer.toString(num).split("");
		
		for (int i = 0; i < result.length; i++) {
			if (result.length - i > 3) {
				list.add(greaterThanAHundred(Integer.valueOf(result[i]), "thousand"));
			} else if (result.length - i > 2) {
				list.add(greaterThanAHundred(Integer.valueOf(result[i]), "hundred"));
			} else if (result.length - i > 1) {
				list.add(dozens(Integer.valueOf(result[i]), Integer.valueOf(result[i+1])));
			}
		}
		
		return unify(list);
	}
	
	private static String unify(LinkedList<String> list) {
		
		
		String last = "";
		if (list.size() > 1) {
			last = list.removeLast();
		}
		
		String name = list.stream().reduce((a, b) -> a.concat(", ").concat(b)).get();
		
		if (name.length() > 0 && last.length() > 0) name += " and ";
		
		name += last;
		
		return name;
	}

	private static String unit(int num) {
		StringBuilder r = new StringBuilder();
		
		switch (num) {
			case 1: r.append("one"); break;
			case 2: r.append("two"); break;
			case 3: r.append("three"); break;
			case 4: r.append("four"); break;
			case 5: r.append("five"); break;
			case 6: r.append("six"); break;
			case 7: r.append("seven"); break;
			case 8: r.append("eight"); break;
			case 9: r.append("nine"); break;
		}
		
		return r.toString();
	}
	
	private static String dozens(int dozen, int unit) {
		StringBuilder r = new StringBuilder();
		
		switch (dozen) {
			case 0: r.append(unit(unit)); break;
			case 1: r.append(fromTenOn(unit)); break;
			case 2: r.append("twenty"); break;
			case 3: r.append("thirty"); break;
			case 4: r.append("fourty"); break;
			case 5: r.append("fifty"); break;
			case 6: r.append("sixty"); break;
			case 7: r.append("seventy"); break;
			case 8: r.append("eighty"); break;
			case 9: r.append("ninety"); break;
		}
		
		if (dozen > 1 && unit > 0) r.append(" ");
		if (dozen > 1) r.append(unit(unit));
		
		return r.toString();
	}

	private static String greaterThanAHundred(int t, String name) {
		StringBuilder r = new StringBuilder();
		
		if (t > 0) {
			r.append(unit(t));
			r.append(" ");
			r.append(name);
		}
		
		return r.toString();
	}
	
	private static String fromTenOn(int unit) {
		StringBuilder r = new StringBuilder();
		switch (unit) {
			case 0: r.append("ten"); break;
			case 1: r.append("eleven"); break;
			case 2: r.append("twelve"); break;
			case 3: r.append("thirteen"); break;
			case 4: r.append("fourteen"); break;
			case 5: r.append("fifteen"); break;
			case 6: r.append("sixteen"); break;
			case 7: r.append("seventeen"); break;
			case 8: r.append("eighteen"); break;
			case 9: r.append("nineteen"); break;
		}
		
		return r.toString();
	}

}
