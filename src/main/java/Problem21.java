import utils.ListNode;

/**
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmpHeader = new ListNode(0);
        ListNode p = tmpHeader;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }

        return tmpHeader.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(6);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(0);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(7);
        d.next = e;
        e.next = f;

        Problem21 problem21 = new Problem21();
        ListNode head = problem21.mergeTwoLists(a, d);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
