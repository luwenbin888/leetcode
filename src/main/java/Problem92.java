import utils.ListNode;

/**
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head, start = head;
        int i = 1;
        while (i++ < m) {
            start = p;
            p = p.next;
        }

        int count = n - m + 1;
        i = 1;
        ListNode end = null;
        ListNode newHead = null;
        ListNode subTail = null;
        while (i <= count) {
            if (i == count) {
                end = p.next;
            }
            if (i == 1) {
                subTail = p;
            }

            ListNode next = p.next;
            p.next = newHead;
            newHead = p;
            p = next;
            i++;
        }

        if (m == 1) {
            head = newHead;
        }
        else {
            start.next = newHead;
        }
        subTail.next = end;

        return head;
    }

    public static void main(String[] args) {
        /*
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        */

        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        a.next = b;

        ListNode h = a;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

        Problem92 problem92 = new Problem92();
        ListNode head = problem92.reverseBetween(a, 1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
