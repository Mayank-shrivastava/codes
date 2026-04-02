package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContigousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int zero = 0, one = 0, n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zero++;
            else one++;

            int diff = zero - one;
            if (diff == 0) {
                res = Math.max(res, i+1);
                continue;
            }

            if (!map.containsKey(diff)) {
                // if not present in map add in map
                map.put(diff, i);
            } else {
                int idx = map.get(diff);
                int len = i - idx;
                res = Math.max(res, len);
            }
        }

        return res;
    }
}
