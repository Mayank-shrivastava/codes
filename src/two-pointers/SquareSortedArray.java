import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> negs = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int i : nums) {
            if (i >= 0) 
                pos.add(i);
            else {
                int curr = (-1*i);
                negs.add(curr);
               
            }
        }

        if (pos.size() == n) {
            for (int i = 0; i < n; i++) 
                nums[i] = nums[i]*nums[i];
        }

        Collections.reverse(negs);

        int[] ans = mergeTwoSortedArray(negs, pos);
        return ans;
    }

    public int[] mergeTwoSortedArray(List<Integer> a, List<Integer> b) {
        int i = 0, j = 0, k = 0, n = a.size(), m = b.size();
        int[] ans = new int[m+n];
    
        while (i < n && j < m) {
            if (a.get(i) >= b.get(j)) {
                ans[k] = b.get(j) * b.get(j);
                j++;
            } else {
                ans[k] = a.get(i) * a.get(i);
                i++;
            }
            k++;
        }

        while (i < n) {
            ans[k] = a.get(i) * a.get(i);
            i++;
            k++;
        }

        while (j < m) {
            ans[k] = b.get(j) * b.get(j);
            j++;
            k++;
        }

        return ans;

    }
}
