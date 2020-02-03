package org.abc;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class ReverseLinkedListRecursion {

    public static void main(String[] args) {
        ReverseLinkedListRecursion obj = new ReverseLinkedListRecursion();
        ListNode list = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4,null))));

        ListNode head = obj.reverseList(list);
        SwapAdjacentNodes.printLinkedList(head);
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newTail = head.next;
        final ListNode newHead = reverseList(newTail);
        newTail.next = head;
        head.next = null;

        return newHead;
    }
}

