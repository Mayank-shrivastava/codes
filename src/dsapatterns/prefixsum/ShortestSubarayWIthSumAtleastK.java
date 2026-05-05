package prefixsum;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarayWIthSumAtleastK {
    public int shortestSubarray(int[] nums, int k)  {
        int n = nums.length;
        Deque<Integer> deq = new ArrayDeque<>();
        long[] prefix = new long[n];
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            if (right == 0) {
                prefix[right] = nums[right];
            } else {
                prefix[right] = prefix[right-1] + nums[right];
            }

            if (prefix[right] >= k) {
                result = Math.min(result, right + 1);
            }

            // shrinking
            while (!deq.isEmpty() && prefix[right] - prefix[deq.peekFirst()] >= k) {
                result = Math.min(result, right - deq.peekFirst());
                deq.removeFirst();
            }

            while (!deq.isEmpty() && prefix[right] >= prefix[deq.peekLast()]) {
                deq.removeLast();
            }

            deq.addLast(right);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    } 
}
