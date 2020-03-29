/**
 * find sub-array with product value under a certain value
 */

public class FindSubArrayWithProductUnderLimit {
    public int solve(int[] numbers, int upperLimit) {
        if(upperLimit < 0) return 0;

        int prod = 1;
        int result = 0;

        int left = 0;
        int right = 0;

        while(right < numbers.length){
            prod = prod * numbers[right];

            while (prod >= upperLimit){
                prod = prod / numbers[left];
                left++;
            }

            result = result + right - left + 1;
            right ++;
        }
        return result;
    }

    int prod = 1;

    int right = 0;
    int size = 0;
    public int solve2(int[] numbers, int upperLimit) {
        if(upperLimit < 0) return 0;

        int result = 0;
        size = 0;
        right = 0;
        prod = 1;

        while(right < numbers.length){
            int newProd = prod * numbers[right];
            if(newProd >= upperLimit) {
                result += combo(size);
                restartAtNextValLessThanLimit(numbers, upperLimit);
            } else if(right == numbers.length - 1){
                if(newProd < upperLimit)
                    result += combo(size + 1);
                else{
                    System.out.printf("===" + combo(size));
                    result += combo(size);
                }
            } else {
                continueIt(numbers, right);
            }
            right++;
        }
        return result;
    }

    private void continueIt(int[] numbers, int right) {
        prod = prod*numbers[right];
        size++;
    }

    private void restartAtNextValLessThanLimit(int[] numbers, int limit) {
        while(right < numbers.length && numbers[right] >= limit){
            right++;
        }

        if(right == numbers.length) return;

        prod = numbers[right];
        size=1;
    }

    private int combo(int size) {
        int sum = 0;
        for(int i=1; i<=size; i++)
            sum += nCr(size, i);
        return sum;

    }

    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

}
