public class LongestPolindrome extends RangeOfNumberInSortedList {
    public String findIt(String s) {
        int n = s.length();
        int pLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < n - 1; i++) {
            int maybePSize = 1;
            while (i - maybePSize >= 0 && i + maybePSize <= n - 1) {
                if (s.charAt(i - maybePSize) != s.charAt(i + maybePSize)) {
                    break;
                }
                maybePSize++;
            }

            int size = maybePSize - 1;
            int newPLen = 2 * (size) + 1;
            if (size > 0 && newPLen > pLen) {
                pLen = newPLen;
                left = i - size;
                right = i + size;
            }
        }

        return left == right ? "" : s.substring(left, right + 1);
    }
}
