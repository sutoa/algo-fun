import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsK {

    private Map<String, List<Integer>> dp = new HashMap();

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        List<Integer> cnt = calc(n-1, k, nums);
        return cnt.get(0) + cnt.get(1);

    }

    private List<Integer> calc(int i, int sum, int[] nums) {
        List<Integer> cnts = new ArrayList();
Math.log
        (100);
        if(i<0){
            cnts.add(0); cnts.add(0);
            return cnts;
        }
        if(i==0){
            if(sum==nums[0]){
                cnts.add(0); cnts.add(1);
                return cnts;
            }
            else{
                cnts.add(0); cnts.add(0);
                return cnts;
            }
        }
        String key = i + "," + sum;
        cnts = dp.get(key);
        if(cnts != null) return cnts;
        List<Integer> prev = calc(i-1, sum, nums);
        cnts = new ArrayList();
        cnts.add(prev.get(0) + prev.get(1));

        prev = calc(i-1, sum-nums[i], nums);
//        System.out.println(cnts + "---" + prev + "--" + (nums[i]==sum? 1 :0));
//        System.out.println("===" + (prev.get(1) + (nums[i]==sum? 1 :0)));
        cnts.add(prev.get(1) + (nums[i]==sum? 1 :0));

//        System.out.println(key + "->" + cnts);
        dp.put(key, cnts);
        return cnts;
    }
}