package slidingwindow;

public class MaxSubarraySumOfLenK {
    

    class Solution {
        public int maxSubarraySum(int[] arr, int k) {
            // Code here

            int n = arr.length;

            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }

            int currSum = windowSum;

            int lo = 0, hi = k - 1;
            while (hi < n) {
                windowSum = Math.max(windowSum, currSum);
                lo++;
                hi++;
                currSum = currSum - arr[lo - 1];
                if (hi < n)
                    currSum = currSum + arr[hi];
            }

            return windowSum;
        }
    }

    // tc: O(N)
    // sc: O(1)
}
