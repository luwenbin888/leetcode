package easy;

import utils.ListNode;

/**
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head, q = head;
        while (p != null) {
            if (p.val == val) {
                if (p == head) {
                    head = head.next;
                    p = head;
                    q = p;
                }
                else {
                    q.next = p.next;
                    p = q.next;
                }
            }
            else {
                q = p;
                p = q.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        Problem203 problem203 = new Problem203();
        ListNode head = problem203.getList(nums);
        head = problem203.removeElements(head, 6);
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }

    private ListNode getList(int[] arr) {
        ListNode head = null;
        ListNode p = null;
        for (int num: arr) {
            if (head == null) {
                head = new ListNode(num);
                p = head;
                head.next = null;
            }
            else {
                p.next = new ListNode(num);
                p = p.next;
                p.next = null;
            }
        }

        return head;
    }
}
