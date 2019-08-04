package encapsulation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// Parameterized tests
@RunWith(Parameterized.class)
public class DogWeightTest {
    static int weightDefault = 5;
    @Parameterized.Parameter(0)
    public int inputWeight;
    @Parameterized.Parameter(1)
    public int expectedResult;

    //test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object data[][] = new Object[][]{
                {-1, weightDefault},
                {0, weightDefault},
                {1, 1},
                {99, 99},
                {100, weightDefault}
        };
        return Arrays.asList(data);
    }

    @Test
    public void setWeight() {
        Dog d = new Dog("D", 1, "male", true, weightDefault);
        d.setWeight(inputWeight);
        Assert.assertEquals("Test failure for input: " + inputWeight, expectedResult, d.getWeight());
    }
}
