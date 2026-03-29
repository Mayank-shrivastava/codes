package twopointers;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // handle duplicate in overall res
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // idhar bhi duplicates aaskte hai
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int lo = j + 1;
                int hi = nums.length - 1;

                while (lo < hi) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[lo];
                    sum += nums[hi];

                    if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo] == nums[lo - 1]) {
                            lo++;
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
