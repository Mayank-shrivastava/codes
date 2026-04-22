package heap;

import java.util.*;
 
public class KthSmallest {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        int n = arr.length;
        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // add first k elements in the max heap
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        
        for (int i = k; i < n; i++) {
            
            if (arr[i] >= pq.peek()) {
                continue; // 
            }
            
            pq.poll();
            pq.add(arr[i]);
        }
        
        return pq.peek();
    }
}