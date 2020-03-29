import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


@RunWith(JUnitParamsRunner.class)
public class LastOccurrenceOfANumberInSortedListTest {
    private LastOccOfNumberInSortedList task = new LastOccOfNumberInSortedList();

    @Test
    @Parameters(method = "testData")
    public void findsLastOccLessThanOrEqInSortedList(int[] nums, int target, int lastIdx) {
        assertThat(task.findLastIdxLtOrEq(nums, target)).isEqualTo(lastIdx);
    }

    Object[] testData() {
        return new Object[]{
                new Object[]{new int[]{1, 7, 9, 13, 13, 15}, 13, 4},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 8, 1},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 17, 4},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 1, 0},
                new Object[]{new int[]{1, 7, 9, 13, 15}, 15, 4},
        };
    }
}