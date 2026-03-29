package twopointers;
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // since array is already sorted
        int n = numbers.length;
        int lo = 0, hi = n - 1;
        int[] ans = { -1, -1 };
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                ans[0] = lo + 1;
                ans[1] = hi + 1;
                return ans;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }

        return ans;
    }
}

// TC: O(N)
// SC: O(1)
