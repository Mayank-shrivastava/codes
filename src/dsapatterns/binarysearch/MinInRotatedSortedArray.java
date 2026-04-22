package binarysearch;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int minIdx = 0;
        while (low <= high) {
            int guess = (low + high) / 2;
            // yeh guess ya toh left part mein hogya ya right part mein hoga
            // how to check if it is in left or right part
            if (nums[guess] > nums[n - 1]) {
                // left part mein
                low = guess + 1;
            } else {
                // right part
                minIdx = guess; // possible minindex
                high = guess - 1;
            }
        }

        return nums[minIdx];
    }

    // another variation of this question could be the find kth rotation
    // Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
    // Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
    // After 1st Rotation : [9, 2, 4, 6]
    // After 2nd Rotation : [6, 9, 2, 4]
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = 0;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] > arr[n - 1]) {
                // left part
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }
}
