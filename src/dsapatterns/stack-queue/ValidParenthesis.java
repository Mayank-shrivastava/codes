package stackqueue;

import java.util.ArrayDeque;

public class ValidParenthesis {
     public boolean isValid(String s) {
        int n = s.length();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // opening braces
            char brace = s.charAt(i);
            if (brace == '{' || brace == '[' || brace == '(') {
                st.push(brace);
            } else {
                // closing braces
                if (st.isEmpty()) {
                    return false;
                } else {
                    // matching
                    char top = st.peek();
                    if ((brace == '}' && top == '{') || (brace == ']' && top == '[') || (brace == ')' && top == '(')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return st.isEmpty();
    }
}
