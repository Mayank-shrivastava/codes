package binarysearch;

public class NumberOfOccurence {
    int countFreq(int[] arr, int target) {
        // code here
        int firstPos = firstOccurence(arr, target);
        if (firstPos == -1)
            return 0;
        int lastPos = lastOccurrence(arr, target);
        return lastPos - firstPos + 1;

    }

    static int firstOccurence(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] == x) {
                res = guess;
                high = guess - 1;
            } else if (arr[guess] > x) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }

    static int lastOccurrence(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] == x) {
                res = guess;
                low = guess + 1;
            } else if (arr[guess] > x) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }
}
