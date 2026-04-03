package stackpattern;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PreviousGreaterElement {
     static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(arr[0]);
        
        for (int i = 1; i < n; i++) {
            
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans.add(-1); 
            } else {
                ans.add(st.peek());
            }
            
            st.push(arr[i]);

        }
        
        return ans;

    }
}
