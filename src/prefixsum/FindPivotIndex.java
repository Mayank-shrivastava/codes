package prefixsum;

import java.util.Arrays;

public class FindPivotIndex {
      public int pivotIndex(int[] nums) {
        int ls = 0, rs = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            rs -= nums[i];
            if (ls == rs) return i;
            ls += nums[i];
        }

        return -1;
    }
}