package Leetcode150.LinkedList;

import java.util.HashMap;

public class CopyListWithRamdonPointers {
    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode curr = head;

        // Pass 1: create all ListNodes
        while (curr != null) {
            map.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        // Pass 2: assign next and random pointers
        curr = head;
        while (curr != null) {
            ListNode copy = map.get(curr);
            copy.next = map.get(curr.next);
            // copy.random = map.get(curr.random); ListNode should i have random pointers
            curr = curr.next;
        }

        return map.get(head);
    }
}
