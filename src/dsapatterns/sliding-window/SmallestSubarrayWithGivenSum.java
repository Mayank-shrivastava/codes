package slidingwindow;

public class SmallestSubarrayWithGivenSum {

    // https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int lo = 0, hi = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (hi = 0; hi < n; hi++) {
            sum = sum + nums[hi]; // add hi in information
            // shrink the size of window
            while (sum >= target) {
                // kaam hone lg gya fire kro
                int len = hi - lo + 1;
                res = Math.min(len, res);
                // System.out.println(len + " " + res);
                sum = sum - nums[lo];
                lo++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
    public static int smallestSubWithSum(int target, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int lo = 0, hi = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (hi = 0; hi < n; hi++) {
            sum = sum + arr[hi]; // add hi in information
            // shrink the size of window
            while (sum > target) {
                // kaam hone lg gya fire kro
                int len = hi - lo + 1;
                res = Math.min(len, res);
                // System.out.println(len + " " + res);
                sum = sum - arr[lo];
                lo++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

//variable size sliding window

