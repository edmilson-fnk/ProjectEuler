package problems.problems11to20;

import org.junit.Assert;
import org.junit.Test;

public class TestProblem19 {

    @Test
    public void testLeapYearFalseCase1() {
        Assert.assertFalse(Problem19.isLeapYear(2022));
    }

    @Test
    public void testLeapYearFalseCase2() {
        Assert.assertFalse(Problem19.isLeapYear(2300));
    }

    @Test
    public void testLeapYearTrueCase1() {
        Assert.assertTrue(Problem19.isLeapYear(2024));
    }

    @Test
    public void testLeapYearTrueCase2() {
        Assert.assertTrue(Problem19.isLeapYear(2000));
    }

}
