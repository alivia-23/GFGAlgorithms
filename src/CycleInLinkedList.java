import java.util.*;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 */
public class CycleInLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Using Hash Table(Set) which tracks the nodes
     *
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }
}
