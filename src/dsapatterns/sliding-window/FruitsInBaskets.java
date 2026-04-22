package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBaskets {
        public int totalFruit(int[] fruits) {
        // longest subarray with atmost 2 distinct numbers
        int n = fruits.length;
        int k = 2;
        int lo = 0;
        int res = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int hi = 0; hi < n; hi++) {
            map.put(fruits[hi], map.getOrDefault(fruits[hi], 0)+1);
            while (map.size() > k) {
                map.put(fruits[lo], map.get(fruits[lo]) - 1); // shrink
                if (map.get(fruits[lo]) == 0) {
                    map.remove(fruits[lo]);
                }
                lo++;
            }

            int len = hi - lo + 1;
            res = Math.max(len, res);
        }

        return res;
    }
}
