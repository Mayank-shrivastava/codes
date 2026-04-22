package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
     public int[][] insert(int[][] intervals, int[] newInterval) {
        // handle the edge case
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        // insert
        List<int[]> res = new ArrayList<>();
        boolean isInserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!isInserted && intervals[i][0] >= newInterval[0]) {
                res.add(newInterval);
                isInserted = true;
            } 
            res.add(intervals[i]);
        }

        // agar isInserted abhi bhi false hai is point tk new interval kabhi add hua nhi hai toh add krdo 
        if (!isInserted)
            res.add(newInterval);

        //for (int[] a : res) System.out.println(Arrays.toString(a));

        return mergeOverlappingIntervals(res);
    }

    static int[][] mergeOverlappingIntervals(List<int[]> intervals) {
        List<int[]> res = new ArrayList<>();
        int start1 = intervals.get(0)[0], end1 = intervals.get(0)[1];
        for (int i = 1; i < intervals.size(); i++) {
            int start2 = intervals.get(i)[0], end2 = intervals.get(i)[1];
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                res.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        res.add(new int[]{start1, end1});

        //return res.stream().toArray(int[][]::new);
        return convert(res);
    }

    static int[][] convert(List<int[]> list) {
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
