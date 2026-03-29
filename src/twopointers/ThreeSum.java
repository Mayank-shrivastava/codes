package twopointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};    
        List<List<Integer>> ans = threeSum(nums);
        for (List<Integer> li : ans) {
            System.out.println(li);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -1 * nums[i];

            // 2 sum start
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    // pehla answer mil gya idhar
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    // // duplicates handle krne hoge
                    // while (c)
                    while (nums[lo] == nums[lo - 1] && lo < hi)
                        lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }

        return ans;
    }

}
