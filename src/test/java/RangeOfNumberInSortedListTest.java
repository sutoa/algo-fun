import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


@RunWith(JUnitParamsRunner.class)
public class RangeOfNumberInSortedListTest {
    private RangeOfNumberInSortedList task = new RangeOfNumberInSortedList();

    @Test
    @Parameters(method = "testData")
    public void findsBeginEndOfNumberInSortedList(int[] nums, int target, List<Integer> range) {
        assertThat(task.findRange(nums, target)).containsExactlyElementsOf(range);
    }

    Object[] testData() {
        return new Object[]{
                new Object[]{new int[]{1, 7, 9, 13, 13, 15}, 13, newArrayList(3, 4)},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 8, newArrayList(-1, -1)},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 17, newArrayList(-1, -1)},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 1, newArrayList(0, 0)},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 0, newArrayList(-1, -1)},
        };
    }
}