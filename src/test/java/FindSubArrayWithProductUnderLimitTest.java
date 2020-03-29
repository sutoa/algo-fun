import org.junit.Test;

import static org.junit.Assert.*;

public class FindSubArrayWithProductUnderLimitTest {

    private FindSubArrayWithProductUnderLimit solution = new FindSubArrayWithProductUnderLimit();

    @Test
    public void solve() {

        int[] numbers = {10, 5, 2, 3, 20, 2, 6, 30, 20};
        int maxProduct = 20;

        assertEquals(solution.solve2(numbers, maxProduct), 9);
    }
}