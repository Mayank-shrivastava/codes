package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
     public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> {
            return a.value-b.value;
        });
        
        int n = mat.length, m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(mat[i][0], i, 0));
        }
        
        while (!minHeap.isEmpty()) {
            Node currNode = minHeap.poll(); 
            ans.add(currNode.value);
            
            int row = currNode.row, col = currNode.col;
        
            if (currNode.col < m-1) {
                minHeap.add(new Node(mat[row][col+1], row, col+1));
            }
        }
        
        return ans;
        
    }
    
    static class Node {
        int value;
        int row;
        int col;
        
        Node(int val, int r, int c) {
            value = val;
            row = r;
            col = c;
        }
    }
}
