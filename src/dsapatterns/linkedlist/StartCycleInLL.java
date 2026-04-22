package linkedlist;

public class StartCycleInLL {
    // “After meeting, reset one pointer to head — move both at same speed — where
    // they meet again is the cycle start.”

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }

        return null;
    }
}
