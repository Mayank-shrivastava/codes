package binarysearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (nums[guess] > nums[n - 1]) {
                // left part
                if (nums[guess] == target) {
                    return guess;
                } else if (nums[guess] > target) {
                    if (target <= nums[n - 1]) {
                        low = guess + 1;
                    } else {
                        high = guess - 1;
                    }
                } else {
                    low = guess + 1;
                }
            } else {
                // right part: it behaves like a normal sorted array
                if (nums[guess] == target) {
                    return guess;
                } else if (nums[guess] > target) {
                    high = guess - 1;
                } else {
                    if (target <= nums[n - 1]) {
                        low = guess + 1;
                    } else {
                        high = guess - 1;
                    }
                }
            }
        }

        return -1;
    }
}
