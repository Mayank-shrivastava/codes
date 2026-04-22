package stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("GeeksforGeeks"));
    }

    static String reverseString(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();

    }
}
