package mergeintervals;

import java.util.Arrays;

public class MeetingRoom {
     public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0, res = 0, room = 0;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                room++;
                res = Math.max(res, room);
                i++;
            } else {
                room--;
                j++;
            }
        }
        
        return res;
        
    }
}
