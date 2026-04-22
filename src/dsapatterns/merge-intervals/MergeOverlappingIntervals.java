package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
     public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // Sort array based on intervals[0][0];
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int start1 = intervals[0][0], end1 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0], end2 = intervals[i][1];
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                ans.add(new int[]{start1, end1});
                // if not merge move to the next interval
                start1 = start2;
                end1 = end2;
            }
        }
        
        // last interval is not added yet
        ans.add(new int[]{start1, end1}); 

        return ans.stream()
            .toArray(int[][]::new);
    }
}
