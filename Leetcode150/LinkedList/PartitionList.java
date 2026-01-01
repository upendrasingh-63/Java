package Leetcode150.LinkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0);
        ListNode dummyGE = new ListNode(0);

        ListNode less = dummyL;
        ListNode great = dummyGE;

        while (head != null) {
            ListNode next = head.next;

            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                great.next = head;
                great = great.next;
            }

            head.next = null;
            head = next;
        }
        less.next = dummyGE.next;
        dummyGE.next = null;

        return dummyL.next;
    }
}
