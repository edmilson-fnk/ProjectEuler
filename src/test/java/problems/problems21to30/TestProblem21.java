package problems.problems21to30;

import org.junit.Assert;
import org.junit.Test;
import problems.Problems21to30.Problem21;

public class TestProblem21 {

    @Test
    public void testD10000() {
        int d = Problem21.d(10000);
        Assert.assertEquals(14211, d);
    }

    @Test
    public void testD220() {
        int d = Problem21.d(220);
        Assert.assertEquals(284, d);
    }

    @Test
    public void testD284() {
        int d = Problem21.d(284);
        Assert.assertEquals(220, d);
    }

}
