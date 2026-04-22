package binarysearch;

public class FindCeil {
    public int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] >= x) {
                // correct baad horhi hai
                res = guess;
                // check at left side
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }
}
