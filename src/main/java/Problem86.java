import utils.ListNode;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessThan = new ListNode(0);
        ListNode moreThan = new ListNode(0);

        ListNode p = lessThan;
        ListNode q = moreThan;

        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                p.next = head;
                p = p.next;
            }
            else {
                q.next = head;
                q = q.next;
            }
            head = next;
        }

        p.next = moreThan.next;
        return lessThan.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        Problem86 problem86 = new Problem86();
        ListNode result = problem86.partition(a, 3);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
