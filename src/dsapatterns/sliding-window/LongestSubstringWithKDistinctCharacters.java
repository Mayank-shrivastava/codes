package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe", 3));
    }


      public static int longestKSubstr(String s, int k) {
        // code here
        
        Map<Character,Integer> map = new HashMap<>();
        int lo = 0, hi= 0, n = s.length();
        int res = -1;
        for (hi = 0; hi < n; hi++) {
            
            map.put(s.charAt(hi), map.getOrDefault(s.charAt(hi), 0) + 1); // add information
            
            while (map.size() > k) {
                // shrinking
                map.put(s.charAt(lo), map.get(s.charAt(lo)) - 1);
                if (map.get(s.charAt(lo)) == 0) {
                    map.remove(s.charAt(lo));
                }
                System.out.println("LO" + lo);
                lo++;
                
            }
            
            // exactly ki wajah se compare krna padega
            if (map.size() == k) {
                int len = hi - lo + 1;
                res = Math.max(len, res);
            }
            System.out.println(hi);
        }
        
        return res;
    }
}
