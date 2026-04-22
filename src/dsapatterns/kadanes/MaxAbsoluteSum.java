package kadanes;

public class MaxAbsoluteSum {
    public static void main(String[] args) {
        
    }

    public int maxAbsoluteSum(int[] nums) {
        int i = 0, minEndingHere = nums[0], maxEndingHere = nums[0], minSum = nums[0], maxSum = nums[0];

        for (i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSum = Math.max(maxSum, maxEndingHere);
            minSum = Math.min(minSum, minEndingHere);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}