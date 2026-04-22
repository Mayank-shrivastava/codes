package binarysearch;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurence(nums, target);
        ans[1] = lastOccurence(nums, target);

        return ans;
    }

    static int firstOccurence(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] == target) {
                // check kro in left part
                res = guess;
                high = guess - 1;
            } else if (arr[guess] > target) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }

    static int lastOccurence(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (low + high) / 2;
            if (arr[guess] == target) {
                res = guess;
                low = guess + 1;
            } else if (arr[guess] > target) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return res;
    }
}
