package recursion;

public class RemoveOccurenceOfChar {
    public void removeCharacter(StringBuilder s, char c) {
        // code here
        helper(s, 0, c);
    }

    void helper(StringBuilder s, int i, char c) {
        if (i == s.length())
            return;

        if (s.charAt(i) == c) {
            s.deleteCharAt(i);
            helper(s, i, c);
        } else {
            helper(s, i + 1, c);
        }
    }
}
