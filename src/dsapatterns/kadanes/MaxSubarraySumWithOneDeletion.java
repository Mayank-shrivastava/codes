package kadanes;

public class MaxSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int i = 0, bestWithNoDelete = arr[0], bestWithDelete = 0, ans = arr[0];
        for (i = 1; i < arr.length; i++) {
            // possible options with delete are either bestwithnodelete or
            // bestwithdelete+arr[i]
            bestWithDelete = Math.max(bestWithNoDelete, bestWithDelete + arr[i]);
            bestWithNoDelete = Math.max(arr[i], bestWithNoDelete + arr[i]);
            ans = Math.max(ans, Math.max(bestWithNoDelete, bestWithDelete));
        }

        return ans;
    }
}
