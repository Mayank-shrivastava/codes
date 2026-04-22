package twopointers;

public class Segregate01 {
    public void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            if (arr[low] == 0) {
                low++;
            } else if (arr[high] == 1) {
                high--;
            } else {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// TC: O(N)
// SC: O(1)