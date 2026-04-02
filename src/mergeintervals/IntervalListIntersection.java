package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
     public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0, n = firstList.length, m = secondList.length;
        while (i < n && j < m) {
            int start1 = firstList[i][0], end1 = firstList[i][1];
            int start2 = secondList[j][0], end2 = secondList[j][1];

            if (start1 <= start2) {
                if (end1 >= start2) {
                    // overlapping
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s,e});
                } 
            } else {
                if (end2 >= start1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    //System.out.println(s + " " + e);
                    //if (s == 5 && e == 5) System.out.println(s + " " + e);
                    res.add(new int[]{s,e});
                }
            }

            if (end1 <= end2) 
                i++;
            else 
                j++;
        }

        return res.stream().toArray(int[][]::new); // :: method referencing
    }
}
