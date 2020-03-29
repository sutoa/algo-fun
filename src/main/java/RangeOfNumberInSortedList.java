import java.util.List;

import static java.util.Arrays.asList;

/**
 * find the first and last occurrence of a given number in a sorted array
 */
public class RangeOfNumberInSortedList {
    public List<Integer> findRange(int[] sorted, int target) {
        if (sorted.length == 0) return asList(-1, -1);

        int left = idxGtOrEq(sorted, target);
        int right = idxGtOrEq(sorted, target + 1) - 1;

        if(left <= right)
            return asList(left, right);
        return asList(-1, -1);
    }

    private int idxGtOrEq(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;
        int idx = sorted.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(target <= sorted[mid]){
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}
