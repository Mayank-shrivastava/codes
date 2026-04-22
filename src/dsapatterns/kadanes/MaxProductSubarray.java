package kadanes;

public class MaxProductSubarray {

    public static int maxSubarrayProduct(int[] arr, int n) {
        int i = 0, minEnding = arr[i], maxEnding = arr[i], ans = arr[i];

        for (i = 1; i < n; i++) {
            int choice1 = arr[i] * minEnding;
            int choice2 = arr[i];
            int choice3 = arr[i] * maxEnding;
            maxEnding = Math.max(choice1, Math.max(choice2, choice3));
            minEnding = Math.min(choice1, Math.min(choice2, choice3));
            ans = Math.max(ans, Math.max(maxEnding, minEnding));
        }

        return ans;
    }
}
