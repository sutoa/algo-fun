import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@RunWith(JUnitParamsRunner.class)
public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists<Integer> task = new MergeTwoSortedLists<>();

    @Test
    @Parameters(method = "testData")
    public void mergesSortedLists(String scenario,
                                  LinkedNode<Integer> sortedList1,
                                  LinkedNode<Integer> sortedList2,
                                  List<Integer> expected) {

        LinkedNode<Integer> mergedList = task.merge(sortedList1, sortedList2);

        if (expected == null)
            assertThat(mergedList).isNull();
        else
            assertThat(mergedList.dumpVals()).containsExactlyElementsOf(expected);
    }

    private Object[] testData() {
        return new Object[]{
                new Object[]{"2 lists overlap",
                        chainedNodes(1, 3, 5, 10, 18),
                        chainedNodes(2, 4, 6, 8),
                        newArrayList(1, 2, 3, 4, 5, 6, 8, 10, 18)},
                new Object[]{"duplicated values are not dropped",
                        chainedNodes(1, 3, 5, 6, 18),
                        chainedNodes(2, 4, 6, 8, 17, 18, 19),
                        newArrayList(1, 2, 3, 4, 5, 6, 6, 8, 17, 18, 18, 19)},
                new Object[]{"first list is after the first one",
                        chainedNodes(9, 19),
                        chainedNodes(2, 4, 6, 8),
                        newArrayList(2, 4, 6, 8, 9, 19)},
                new Object[]{"second list is after the first one",
                        chainedNodes(1, 3, 5, 10),
                        chainedNodes(18, 19),
                        newArrayList(1, 3, 5, 10, 18, 19)},
                new Object[]{"first list is null",
                        null,
                        chainedNodes(18, 19),
                        newArrayList(18, 19)},
                new Object[]{"second list is null",
                        chainedNodes(18, 19),
                        null,
                        newArrayList(18, 19)},
                new Object[]{"both lists are null",
                        null,
                        null,
                        null},
        };
    }

    private LinkedNode<Integer> chainedNodes(int... vals) {
        LinkedNode<Integer> head = new LinkedNode(-1);
        LinkedNode<Integer> tail = head;

        for (int val : vals) {
            tail.next = new LinkedNode<>(val);
            tail = tail.next;
        }

        return head.next;
    }
}
