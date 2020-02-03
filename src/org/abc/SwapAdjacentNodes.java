package org.abc;

public class SwapAdjacentNodes {

    public static void main(String[] args) {
        SwapAdjacentNodes ex = new SwapAdjacentNodes();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ListNode listNode = ex.swapPairs(head);
        printLinkedList(listNode);

    }

    public static void printLinkedList(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println("null");
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this(data,null);
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}


