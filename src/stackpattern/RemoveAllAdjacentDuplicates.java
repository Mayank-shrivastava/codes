package stackpattern;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicates {
     public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair> st = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().count++; // increase the counter
                if (st.peek().count == k) { // remove k duplicates
                    st.pop();
                }
            } else {
                st.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            Pair top = st.peek();
            for (int i = 0; i < top.count; i++) {
                sb.append(top.ch);
            }
            st.pop();
        }

        return sb.reverse().toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
