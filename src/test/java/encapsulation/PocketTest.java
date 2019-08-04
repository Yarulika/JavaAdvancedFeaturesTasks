package encapsulation;

import org.junit.Assert;
import org.junit.Test;

public class PocketTest {
    // Test table usage
    @Test
    public void getMoney() {
        int[][] cases = new int[][]{
                {-1, 0},
                {0, 0},
                {5, 0},
                {10, 0},
                {11, 11},
        };
        for (int[] testCase : cases) {
            int input = testCase[0];
            int expectedResult = testCase[1];
            Pocket p = new Pocket(input);
            Assert.assertEquals("On error: wrong money returned for input: " + input, expectedResult, p.getMoney());
        }
    }

    @Test
    public void setMoney() {
        int defaultVal = 44;
        int[][] cases = new int[][]{
                {-1, defaultVal},
                {0, 0},
                {10, 0},
                {11, 11},
                {3000, 3000},
                {3001, defaultVal}
        };
        for (int[] testCase : cases) {
            int input = testCase[0];
            int expectedResult = testCase[1];
            Pocket p = new Pocket(defaultVal);
            p.setMoney(input);
            Assert.assertEquals("On error: check for input: " + input, expectedResult, p.getMoney());
        }
    }
}
