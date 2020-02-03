package org.abc;

public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists merger = new MergeTwoLists();
        Util.printLinkedList(merger.mergeTwoLists(
                new ListNode(1,new ListNode(3, new ListNode(5))),
                new ListNode(2,new ListNode(4))));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode head = null;
        if(l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }


        ListNode curr = head;

        curr = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
             curr.next = new ListNode(l1.val);
             l1 = l1.next;
            }else {
             curr.next = new ListNode(l2.val);
             l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 == null) {
            copyList(l2, curr);
        }else if(l2 == null) {
            copyList(l1, curr);
        }

        return head;
    }

    private void copyList(ListNode l2, ListNode curr) {
        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }
    }

}
