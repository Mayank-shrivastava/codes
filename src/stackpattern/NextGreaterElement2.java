package stackpattern;

import java.util.ArrayDeque;

public class NextGreaterElement2 {
    // Array is circular in this question
     public int[] nextGreaterElements(int[] nums) {
        // next greater nikalna hai toh right to left move krna hoga
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] res = new int[n];
        // fill the stack for possible data set for n-1th index
        for (int i = n-2; i >= 0; i--) {
            st.push(nums[i]);
        }

        for (int i = n-1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(nums[i]);
        }

        return res;
    }
}
