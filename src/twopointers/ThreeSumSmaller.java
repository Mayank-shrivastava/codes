package twopointers;
import java.util.Arrays;

public class ThreeSumSmaller {
     long countTriplets(int n, int target, long arr[]) {
        Arrays.sort(arr);
        long res = 0;
        for (int i=0; i<n-2; i++) {
            int lo=i+1, hi=n-1;
            
            while (lo < hi) {
               long sum = arr[i]+arr[lo]+arr[hi];
               if (sum >= target) {
                    hi--;
                } else {
                    res += (hi-lo);
                    lo++;
                }
            }
        }
        
        return res;
    }
}
