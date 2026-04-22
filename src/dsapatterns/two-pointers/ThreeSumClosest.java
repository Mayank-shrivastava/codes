package twopointers;
import java.util.Arrays;

public class ThreeSumClosest {
     public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n-2; i++) {
            int lo = i+1, hi = n-1;
            while (lo < hi) {
                int sum = nums[i]+nums[lo]+nums[hi];
                int currDiff = Math.abs(target-sum);
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    res = sum;
                }
            
                if (sum >= target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        
        return res;
    }
}
