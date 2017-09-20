import utils.ListNode;

/**
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Problem237 {

    // replace the current node's value with the node next to it and delete the next node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(6);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Problem237 problem237 = new Problem237();
        problem237.deleteNode(n3);
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }
}
