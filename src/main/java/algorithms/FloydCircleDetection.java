package algorithms;

import utils.ListNode;

/**
 * http://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
 * http://www.siafoo.net/algorithm/10
 The algorithm thus maintains two pointers into the given sequence, one (the tortoise) at xi, and the other (the hare) at x2i.
 At each step of the algorithm, it increases i by one, moving the tortoise one step forward and the hare two steps forward
 in the sequence, and then compares the sequence values at these two pointers.
 The smallest value of i > 0 for which the tortoise and hare point to equal values is the desired value ν.
 */
public class FloydCircleDetection {
    public boolean detectCircle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head.next, fast = head.next;

        while (fast != null) {
            if (fast.next == null) return false;
            fast = fast.next;

            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next;
        }

        return false;
    }

    public int detectCircleLength(ListNode head) {
        if (head == null) return 0;

        ListNode slow = head.next, fast = head.next;

        int length = 0;

        while (fast != null) {
            if (fast.next == null) return length;
            fast = fast.next;

            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // anchor slow, move fast one pointer at a time until they meet
        fast = fast.next;
        length++;
        while (slow != fast) {
            length++;
            fast = fast.next;
        }

        return length;
    }

    // https://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work
    public ListNode detectCircleStart(ListNode head) {
        if (head == null) return null;

        ListNode slow = head.next, fast = head.next;

        while (fast != null) {
            if (fast.next == null) return null;
            fast = fast.next;

            if (slow == fast) {
                break;
            }

            slow = slow.next;
            fast = fast.next;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
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

        FloydCircleDetection solution = new FloydCircleDetection();
        boolean result = solution.detectCircle(a);
        System.out.println(result);

        int length = solution.detectCircleLength(a);
        System.out.println(length);

        ListNode startNode = solution.detectCircleStart(a);
        System.out.println(startNode.val);
    }
}
