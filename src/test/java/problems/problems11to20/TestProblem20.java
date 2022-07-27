package problems.problems11to20;

import org.junit.Assert;
import org.junit.Test;

public class TestProblem20 {

    @Test
    public void testSimpleMultiplication() {
        Integer[] number = new Integer[]{3, 2, 1};
        int multiplyByThis = 5;

        Problem20.multiply(number, multiplyByThis);

        Assert.assertEquals(5, (int) number[0]);
        Assert.assertEquals(1, (int) number[1]);
        Assert.assertEquals(6, (int) number[2]);
    }

    @Test
    public void testComplexMultiplication() {
        Integer[] number = new Integer[5];
        number[0] = 1;
        number[1] = 2;
        number[2] = 3;
        number[3] = 0;
        number[4] = 0;
        int multiplyByThis = 5;

        Problem20.multiply(number, multiplyByThis);

        Assert.assertEquals(5, (int) number[0]);
        Assert.assertEquals(0, (int) number[1]);
        Assert.assertEquals(6, (int) number[2]);
        Assert.assertEquals(1, (int) number[3]);
    }

}
