package Leetcode150.LinkedList;

public class ReverseNodeInkGroups {
    public ListNode reverNode(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevg = dummy;

        while (true) {
            // find kth node
            ListNode kth = prevg;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null)
                break;

            ListNode curr = prevg.next;

            // reverse k nodes (k-1 operations) head-insertion technique
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prevg.next;
                prevg.next = temp;
            }

            prevg = curr;
        }

        return dummy.next;
    }
}
