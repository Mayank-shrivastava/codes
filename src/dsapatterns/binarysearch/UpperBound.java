package binarysearch;

public class UpperBound {
    int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] > target) {
                ans = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return ans;
    }
}

// if no elements are greater than target, then return n (this is the upper bound)
// Time complexity: O(logn)


