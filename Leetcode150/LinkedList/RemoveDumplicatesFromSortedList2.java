package Leetcode150.LinkedList;

public class RemoveDumplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // detect duplicate block
            if (curr.next != null && curr.val == curr.next.val) {
                int dupVal = curr.val;

                // skip all nodes with dupVal
                while (curr != null && curr.val == dupVal) {
                    curr = curr.next;
                }

                prev.next = curr; // remove entire block
            } else {
                prev = curr; // safe unique node
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
