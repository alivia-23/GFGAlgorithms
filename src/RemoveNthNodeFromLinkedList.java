import java.util.List;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Approach 1:
 * First find the length of the linkedlist then subtract n with the linkedlist
 * Then we will get the position where we need to remove the node
 */
public class RemoveNthNodeFromLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }
        length = length - n;
        current = dummy;
        while (length > 0) {
            current = current.next;
        }
        current = current.next.next;
        return dummy.next;
    }

}
