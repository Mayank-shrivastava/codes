package slidingwindows;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int lo = 0;
        int res = 0;
        int maxFreq = 0;

        for (int hi = 0; hi < n; hi++) {
            char ch = s.charAt(hi);
            hash[ch - 'A']++;

            maxFreq = Math.max(maxFreq, hash[ch - 'A']);

            int len = hi - lo + 1;
            int diff = len - maxFreq;

            while (diff > k) {
                char loch = s.charAt(lo);
                hash[loch - 'A']--;
                lo++;
                len = hi - lo + 1;
                diff = len - maxFreq;
            }
            res = Math.max(res, hi - lo + 1);
        }

        return res;
    }
}
