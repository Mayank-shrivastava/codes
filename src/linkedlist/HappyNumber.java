package linkedlist;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (f(n) == 1) {
            return true;
        }

        int slow = n, fast = n;
        while (fast != 1) {
            slow = f(slow);
            fast = f(fast);
            fast = f(fast);

            if (slow == fast) {
                return false;
            }
        }

        return true;
    }

    private int f(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n /= 10;
        }

        return sum;
    }
}
