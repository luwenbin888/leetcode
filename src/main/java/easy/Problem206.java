package easy;

import utils.ListNode;

/**
 Reverse a singly linked list.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        return method1(head);
    }

    private ListNode method1(ListNode head) {
        if (head == null) return null;

        ListNode p, q;
        q = head;
        p = q.next;
        while (p != null) {
            ListNode next = p.next;
            p.next = q;
            q = p;
            p = next;
        }

        head.next = null;
        head = q;

        return head;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        n3.next = n4;
        ListNode n5 = new ListNode(6);
        n4.next = n5;
        n5.next = null;

        Problem206 problem206 = new Problem206();
        problem206.printList(head);
        head = problem206.reverseList(head);
        problem206.printList(head);
    }
}
