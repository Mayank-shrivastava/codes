package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
      public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        generateParenthesisRec(n, 0, 0, "",ans);

        return ans;
    }
    
    private void generateParenthesisRec(int n, int nob, int ncb, String p, List<String> res) {
        // base case
        if (nob == n && ncb == n) {
            res.add(p);
            return;
        }

        if (nob < ncb || nob > n) return;

        // recursive condition
        // opening
        generateParenthesisRec(n, nob+1, ncb, p +'(', res);
        // closing
        generateParenthesisRec(n, nob, ncb+1, p +')', res);

    }
}
