package encapsulation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// Parameterized tests
@RunWith(Parameterized.class)
public class DogAgeTest {
    static int ageDefault = 5;
    @Parameterized.Parameter(0)
    public int inputAge;
    @Parameterized.Parameter(1)
    public int expectedResult;

    //Test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object data[][] = new Object[][]{
                {0, 0},
                {1, 1},
                {19, 19},
                {-1, ageDefault},
                {20, ageDefault}
        };
        return Arrays.asList(data);
    }

    @Test
    public void setAge() {
        Dog d = new Dog("D", ageDefault, "male", true, 25);
        d.setAge(inputAge);
        Assert.assertEquals("Test failure for input: " + inputAge, expectedResult, d.getAge());
    }
}
