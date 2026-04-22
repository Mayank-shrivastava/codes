package binarysearch;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            // peak element hone ki condition kya hoskti hai
            // possible: arr[guess] > arr[guess+1]

            if (arr[guess] > arr[guess + 1]) {
                // possible peak
                res = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }
}
