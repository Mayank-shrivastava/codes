package binarysearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int guess = (low+high)/2; // guessed k ki values
            // here guess means ki koka 1 ghante mein guess number of bananas khaegi

            if (canKokoEatAllBananas(piles, h, guess)) {
                // possible answer
                ans = guess;
                // since i have to find min answer
                high = guess-1;   
            } else {
                low = guess+1;
            }
        }

        return ans;
    }

    // greedy method implementation for canKokoEatAllBananas
    static boolean canKokoEatAllBananas(int[] piles, int h, int k) {
        //System.out.println(k);
        long numberOfHrsInWhichAllPilesEaten = 0L;
        for (int i = 0; i < piles.length; i++) {
            int bananasToEat = piles[i];
            numberOfHrsInWhichAllPilesEaten += (bananasToEat/k);
            if (bananasToEat % k != 0) {
                numberOfHrsInWhichAllPilesEaten += 1;
            }  
        }

        //System.out.println(numberOfHrsInWhichAllPilesEaten);

        return numberOfHrsInWhichAllPilesEaten <= h; // true else false
    }
}
