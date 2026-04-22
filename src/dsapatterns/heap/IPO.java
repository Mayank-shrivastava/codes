package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Pair> proj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            proj.add(new Pair(capital[i], profits[i]));
        }

        proj.sort((a,b) -> a.capital-b.capital);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        while (k > 0) {
            while (idx < n && proj.get(idx).capital <= w) {
                maxHeap.add(proj.get(idx).profit);
                idx++;
            }

            if (maxHeap.isEmpty()) return w;
            w = w + maxHeap.peek();
            maxHeap.poll();
            k--;
        }

        return w;
    }

    static class Pair {
        int capital;
        int profit;

        Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}
