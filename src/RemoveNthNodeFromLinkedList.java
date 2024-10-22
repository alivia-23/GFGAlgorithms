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

    /**
     * Time complexity - O(L) - The algorithm makes two traversal of the list, first to calculate list length L and second to find the (L−n) th node.
     *                          There are 2L−n operations and time complexity is O(L)
     * Space complexity - O(1)
     */
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

    /**
     * Two pointer approach:-
     * Time complexity - O(L) - traverses one pass of L nodes
     * Space complexity - O(1)
     */
    public ListNode removeNthNodeTwoPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        //move fast pointer to the (n + 1)th node where we need to delete
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // now move both pointers together untill fast reaches null
        // when fast reaches null at that time slow will reach to the
        // node before the node to be deleted
        // then simply connect next pointer of slow to 2 step ahead
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

}
