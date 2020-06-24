import java.util.HashSet;
import java.util.Set;

class DupString2 {
    public String longestDupSubstring(String S) {
        int n = S.length();

        int left = 1;
        int right = n;
        String ans = "";
        while(left <= right){
            int mid = left + (right-left)/2;
            String x = findDup(S, mid);
            if(x != ""){
                ans = x;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private String findDup(String S, int len){
        String dup = "";
        long mult = 1;
        for(int i=1; i<len; i++){
            mult*=26;
        }
        int n = S.length();

        Set<Long> hashes = new HashSet();
        long hash = hash(S.substring(0, len));
        hashes.add(hash);
        for(int i = 1; i <= n-len; i++ ){
            int old = S.charAt(i-1);
            int next = S.charAt(i+len-1);
            hash = (hash - old*mult)*26 + next;
            System.out.println("len:" + len + ";next hash:" + hash);
            if(!hashes.add(hash)){
                dup = S.substring(i, i+len);

                break;
            }
        }
        System.out.println("findDup for len: " + len + " is " + dup);
        return dup;
    }

    private long hash(String s){
        int n = s.length();
        long mult = 1;
        long h = 0;
        for(int i=n-1; i>=0; i--){
            int c = s.charAt(i);
            h += c*mult;
            mult *= 26;
        }
        System.out.println("hash of " + s + ": " + h);
        return h;
    }
}
