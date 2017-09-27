import utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class Problem138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        RandomListNode oldHead = head;
        RandomListNode newHead = null;
        RandomListNode p = null;

        while (oldHead != null) {
            RandomListNode node = new RandomListNode(oldHead.label);
            if (p == null) {
                newHead = node;
                p = node;
            }
            else {
                p.next = node;
                p = p.next;
            }
            nodeMap.put(oldHead, node);
            oldHead = oldHead.next;
        }

        oldHead = head;
        p = newHead;
        while (oldHead != null) {
            RandomListNode oldRandomPtr = oldHead.random;
            RandomListNode newRandomPtr = nodeMap.getOrDefault(oldRandomPtr, null);
            if (newRandomPtr != null) {
                p.random = newRandomPtr;
            }
            else {
                p.random = null;
            }
            oldHead = oldHead.next;
            p = p.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Problem138 problem138 = new Problem138();
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = c;
        b.random = d;
        c.random = c;
        d.random = null;
        e.random = d;

        RandomListNode head = problem138.copyRandomList(a);

        while (head != null) {
            System.out.print("(");
            System.out.print(head.label);
            System.out.print(",");
            if (head.random != null) {
                System.out.print(head.random.label);
            }
            System.out.print(")--->");
            head = head.next;
        }
    }
}
