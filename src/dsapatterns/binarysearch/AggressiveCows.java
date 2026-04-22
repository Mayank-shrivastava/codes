package binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n-1];
        int ans = -1;
        while (low <= high) {
            int guess = (low+high)/2;
            if (isPossibleToPlaceKCowsOnGuessedDistance(stalls, k, guess)) {
                ans = guess;
                low = guess+1;
            } else {
                high = guess-1;
            }
        }
        
        return ans;
    }
    
    static boolean isPossibleToPlaceKCowsOnGuessedDistance(int[] arr, 
                int k, int d) {
        
        int cows = 1;
        int prevPos = arr[0]; // first cow is placed at arr[0]
        //System.out.println("Guesed Distance " + d);
        for (int i = 1; i < arr.length; i++) {
            int distanceBtwPrevPosCurrPos = arr[i]-prevPos;
            if (distanceBtwPrevPosCurrPos >= d) {
                cows++;
                prevPos = arr[i];
            }
        }
        
        //System.out.println("Number Of Cows " + cows);
        
        if (cows < k) return false;
        else return true;
    }
}


// c1  c2  c3
// 1 2 4 8 9

// d(c1, c2) => 4-1 => 3
// d(c2, c3) => 9-4 => 5
// k = 

// answer here is the distance btw adjacent cows
// every time we guess the distance btw adjacent cows
// check if it is possible to assign stalls to each cows using that distance
// if possible move high=guess-1
// else low = guess+1

// what is low and high? search space?
// it can't be 0 it should be 1 and max distance
// 
