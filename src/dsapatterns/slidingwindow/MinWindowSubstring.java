package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
     public String minWindow(String s, String t) {
        Map<Character, Integer> required = new HashMap<>();
        
        // freq map for the required characters for distinctions
        for (char ch : t.toCharArray()) {
            required.put(ch, required.getOrDefault(ch,0)+1);
        }

        int low = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int numberOfValidCharsInWindow = 0;
        int numberOfValidCharsActual = required.size();

        Map<Character, Integer> window = new HashMap<>();

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            window.put(ch, window.getOrDefault(ch,0)+1); // expanding window

            if (required.containsKey(ch) && (int)window.get(ch) == (int)required.get(ch)) {
                //  kya jo ch window mein add kiya required ka part with freq equals
                //  if yes increase size of 
                numberOfValidCharsInWindow++;
            }

            // window expand krte krte ek point aisa aayega jb all required characters window mein honge 
            // to uske baad shrinking start krna hai 

            while (numberOfValidCharsInWindow == numberOfValidCharsActual) {
                
                // potential answer calculation
                int currLen = high-low+1;
                if (currLen < minLen) {
                    minLen = currLen;
                    System.out.println(minLen);
                    start = low; // since we get new min length update the low for substring 
                }

                // shrink
                char lowChar = s.charAt(low);
                window.put(lowChar, window.get(lowChar)-1); 

                // since shrinking happend formed could change
                if (required.containsKey(lowChar) && (int)window.get(lowChar)
                        < (int)required.get(lowChar)) {
                    numberOfValidCharsInWindow--;
                }

                low++;
            }
        }

        //System.out.println(minLen + " " + start);
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
