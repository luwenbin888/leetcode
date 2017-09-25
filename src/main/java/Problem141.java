import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class Problem141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeVals = new HashSet<>();

        while (head != null) {
            if (listNodeVals.contains(head)) return true;
            else listNodeVals.add(head);
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = c;

        Problem141 problem141 = new Problem141();
        boolean result = problem141.hasCycle(a);
        System.out.println(result);
    }
}
