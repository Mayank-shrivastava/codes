package kadanes;

public class MaxSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int i = 0, maxEndingHere = nums[0], minEndingHere = nums[0], maxSum = nums[0], minSum = nums[0];
        int totalSum = nums[0];

        for (i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);

            maxSum = Math.max(maxSum, maxEndingHere);
            minSum = Math.min(minSum, minEndingHere);

            totalSum += nums[i];
        }

        // System.out.println
        // (String.format("%d, %d, %d", totalSum, maxSum, totalSum-Math.abs(minSum)));

        if (maxSum < 0)
            return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}