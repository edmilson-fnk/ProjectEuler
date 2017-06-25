package util;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestSpeller {

	private int number;
	private String spelled;
	
	public TestSpeller(int number, String spelled) {
		this.number = number;
		this.spelled = spelled;
	}
	
	@Parameters(name="test({index})")
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {
					{1, "one"},
					{2, "two"},
					{3, "three"},
					{4, "four"},
					{5, "five"},
					{6, "six"},
					{7, "seven"},
					{8, "eight"},
					{9, "nine"},
					{10, "ten"},
					{11, "eleven"},
					{12, "twelve"},
					{13, "thirteen"},
					{14, "fourteen"},
					{15, "fifteen"},
					{16, "sixteen"},
					{17, "seventeen"},
					{18, "eighteen"},
					{19, "nineteen"},
					{20, "twenty"},
					{32, "thirty two"},
					{69, "sixty nine"},
					{80, "eighty"},
					{100, "one hundred"},
					{110, "one hundred and ten"},
					{472, "four hundred and seventy two"},
					{1500, "one thousand and five hundred"},
					{9999, "nine thousand, nine hundred and ninety nine"}
				}
				);
	}

	@Test
	public void testNumbers() {
		Assert.assertEquals(spelled, Speller.spell(number));
	}
	
}
