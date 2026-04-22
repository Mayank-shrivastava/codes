package recursion;

public class IsArraySorted {
    public boolean isSorted(int[] arr) {
        // code here

        if (arr.length == 1)
            return true;

        if (arr.length == 2) {
            if (arr[0] > arr[1])
                return false;
            return true;
        }

        return isSortedRec(arr, 0, 1);
    }

    boolean isSortedRec(int[] arr, int prev, int next) {
        if (next >= arr.length)
            return true; // is point tk pahunchna mtlb complete array traverse hojana

        if (arr[prev] > arr[next])
            return false; // prev

        return isSortedRec(arr, prev + 1, next + 1);
    }
}
