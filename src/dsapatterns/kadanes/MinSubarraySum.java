package kadanes;

public class MinSubarraySum {
    

    public static int minSubarraySum(int[] arr, int n) {
        int i = 0, bestEnding = arr[i], ans = arr[i];

        for (i = 1; i < n; i++) {
            int choice1 = arr[i] + bestEnding;
            int choice2 = arr[i];
            bestEnding = Math.min(choice1, choice2);
            ans = Math.min(ans, bestEnding);
        }

        return ans;
    }
}
