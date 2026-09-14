package dsa.arrays;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Array before swapping :" + Arrays.toString(arr));
        swap(arr, 1, 2);
        System.out.println("Array after swapping : " + Arrays.toString(arr));

        // reverse
        System.out.println("Array before reverse :" + Arrays.toString(arr));
        reverseArray(arr, 0, arr.length-1);
        System.out.println("Array after reverse :" + Arrays.toString(arr));
    }

    // Ques 1: Swap positions in array
    // TC: O(1) SC: O(1)
    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    // Ques 2: Reverse the array
    // TC: O(N) SC: O(1)
    static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    // Ques 3: Rotate the array (Right by k)
    // arr: [1,2,3,4,5], k = 2
    // o/p: [4,5,1,2,3]
    // TC: O(N), SC: O(1)

    static void rotateArrayRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }


    // Ques 4: Rotate the array (Left by k)
    // arr: [1,2,3,4,5], k = 2
    // o/p: [3,4,5,1,2]
    // TC: O(N), SC: O(1)

    static void rotateArrayLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
    }
}
