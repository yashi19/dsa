import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void shouldReturnSecondMaximumWithPositiveIntegers() {
        String[] numbers = new String[]{"2", "1", "5", "3"};
        assertEquals(3, Solution.secondMaximum(numbers));
    }

    @Test
    public void shouldReturnMinusOneWithEmptyArray() {
        String[] numbers = new String[1];
        assertEquals(-1, Solution.secondMaximum(numbers));
    }

    @Test
    public void shouldReturnMinusOneWithNull() {
        assertEquals(-1, Solution.secondMaximum(null));
    }

    @Test
    public void shouldReturnMinusOneWithInvalidInput() {
        String[] numbers = new String[]{"2", "1", null, "abc1233"};
        assertEquals(-1, Solution.secondMaximum(numbers));
    }


    @Test
    public void shouldReturnMinusOneWhenNoSecondMaximumIntegerExist() {
        String[] numbers = new String[]{"1", "1", "1"};
        assertEquals(-1, Solution.secondMaximum(numbers));
    }

    @Test
    public void shouldReturnSecondMaximumWithLargeNumbers() {
        String[] numbers = new String[]{"-214748364801","-214748364802"};
        assertEquals(-214748364802L, Solution.secondMaximum(numbers));
    }
}