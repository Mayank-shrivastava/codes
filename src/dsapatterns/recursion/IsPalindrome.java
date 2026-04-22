package recursion;

public class IsPalindrome {
    boolean isPalindrome(String s) {
        // code here

        return isPalindromeRec(s, 0, s.length() - 1);

    }

    boolean isPalindromeRec(String s, int left, int right) {
        if (left >= right)
            return true;

        if (s.charAt(left) != s.charAt(right))
            return false;

        return isPalindromeRec(s, left + 1, right - 1);
    }
}
