import utils.ListNode;

/**
 Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:

 A:          a1 → a2
                    ↘
                    c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3

 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLinkedListLength(headA);
        int len2 = getLinkedListLength(headB);

        ListNode longList = null;
        ListNode shortList = null;
        int shortLen, longLen;
        if (len1 > len2) {
            shortList = headB;
            longList = headA;
            longLen = len1;
            shortLen = len2;
        }
        else {
            shortList = headA;
            longList = headB;
            longLen = len2;
            shortLen = len1;
        }

        int lenDiff = longLen - shortLen;
        while (lenDiff > 0) {
            longList = longList.next;
            lenDiff--;
        }

        while (shortList != null && longList != null) {
            if (shortList == longList) {
                return shortList;
            }

            shortList = shortList.next;
            longList = longList.next;
        }

        return null;
    }

    private int getLinkedListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static void main(String[] args) {
        Problem160 problem160 = new Problem160();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);

        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        c1.next = c2;
        c2.next = c3;
        a.next = b;
        b.next = c1;

        ListNode d = new ListNode (0);
        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2);
        d.next = e;
        e.next = f;
        f.next = c1;

        ListNode result = problem160.getIntersectionNode(a, d);
        System.out.println(result.val);
    }
}
