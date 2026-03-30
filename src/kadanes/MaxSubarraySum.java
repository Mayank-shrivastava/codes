package kadanes;

public class MaxSubarraySum {
    public static void main(String[] args) {
        
    }

    public static int maxSubarraySum(int[] arr, int n) {
        int i = 0, bestEnding = arr[i], ans = arr[i];

        for (i = 1; i < n; i++) {
            int choice1 = arr[i] + bestEnding;
            int choice2 = arr[i];
            bestEnding = Math.max(choice1, choice2);
            ans = Math.max(ans, bestEnding);
        }


        return ans;
    } 
}