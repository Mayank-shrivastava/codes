package binarysearch;

public class BookAllocationProblem {

    public static void main(String[] args) {
        int[] arr = {15, 10,19, 10, 5, 18, 7};
        int k = 5;
        System.out.println(findPages(arr, k));
    }


    static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;

        if (k > n) return -1;
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int ans = -1;

        while (low <= high) {
            int guess = (low + high) / 2;
            // guess means the max number of pages assigned to one student
            if (isPossibleToAllocateAllBookToKStudentWithGuessedPages(arr, k, guess)) {
                ans = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }

        return ans;
    }

    static boolean isPossibleToAllocateAllBookToKStudentWithGuessedPages(int[] arr, int k, int pages) {
        System.out.println("Number Of Pages " + pages);
        int pagesTillNow = 0;
        int students = 1;
        for (int i = 0; i < arr.length; i++) {
            if (pagesTillNow + arr[i] <= pages) {
                pagesTillNow += arr[i];
            } else {
                students++;
                pagesTillNow = arr[i];

                if (students > k) {
                    return false;
                }
            }
        }

        System.out.println("Number Of Students " + students);
        return true;
    }
}
