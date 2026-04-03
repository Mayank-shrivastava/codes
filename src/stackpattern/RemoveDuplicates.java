package stackpattern;

import java.util.ArrayDeque;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }

            if (st.peek() == s.charAt(i)) {
                // agar stack ka top ith character ke barabar hai toh stack ke top ko uda do
                st.pop();
                continue;
            }

            st.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            // char top = st.peek();
            // sb.append(top);
            // st.pop();
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
