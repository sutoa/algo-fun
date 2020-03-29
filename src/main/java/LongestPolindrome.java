public class LongestPolindrome extends RangeOfNumberInSortedList {
    public String findPolindromeWithOddNumberLen(String s) {
        int n = s.length();
        int pLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < n - 1; i++) {
            int size = 0;
            while (i - size - 1 >= 0 && i + size + 1 <= n - 1) {
                if (s.charAt(i - size - 1) != s.charAt(i + size + 1)) {
                    break;
                }
                size++;
            }

            int newPLen = 2 * (size) + 1;
            if (size > 0 && newPLen > pLen) {
                pLen = newPLen;
                left = i - size;
                right = i + size;
            }
        }

        return left == right ? "" : s.substring(left, right + 1);
    }

    public String findPolindromeWithEvenNumberLen(String s) {
        int n = s.length();
        int pLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            int size = 0;
            while (i - (size + 1) + 1  >= 0 && i + size + 1 <= n - 1) {
                if (s.charAt(i - size) != s.charAt(i + size + 1)) {
                    break;
                }
                size++;
            }

            int newPLen = 2 * size;
            if (newPLen > pLen) {
                pLen = newPLen;
                left = i - size + 1;
                right = i + size;
            }
        }

        return left == right ? "" : s.substring(left, right + 1);
    }
}
