package dsapatterns.linkedlist;

public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static class ListNode {
        int data;
        ListNode next;
    }
}
