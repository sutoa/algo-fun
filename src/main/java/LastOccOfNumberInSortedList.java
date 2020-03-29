public class LastOccOfNumberInSortedList extends RangeOfNumberInSortedList {
    public int findLastIdxLtOrEq(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int lastOcc = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                lastOcc = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastOcc;
    }
}
