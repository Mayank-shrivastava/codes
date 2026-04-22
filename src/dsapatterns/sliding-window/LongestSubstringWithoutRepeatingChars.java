package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), lo = 0;
        int res = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for (int hi = 0; hi < n; hi++) {
            char ch = s.charAt(hi);
            map.put(ch, map.getOrDefault(ch,0)+1);
            int k = hi - lo + 1; 
            // length of the substring we will compare this with map size if equals means that we have
            // idhar longest mein bhi shrinking thodi si alag tarah se hogi joki galt answer pr hogi kyuki k size variable hai
            while (map.size() < k) {
                char lowch = s.charAt(lo);
                map.put(lowch, map.get(lowch)-1);
                if (map.get(lowch) == 0) {
                    map.remove(lowch);
                }
                lo++;
                k = hi - lo + 1;
            }

            int len = hi - lo + 1;
            res = Math.max(len, res);
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}