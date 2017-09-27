import utils.ListNode;

/**
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast.next != null) fast = fast.next;
            else return null;

            if (slow == fast) break;
        }

        if (fast == null) return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Problem142 problem142 = new Problem142();
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

        ListNode start = problem142.detectCycle(a);
        System.out.println(start != null?start.val:"");
    }
}
