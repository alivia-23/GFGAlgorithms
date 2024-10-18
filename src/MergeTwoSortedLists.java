/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */

import java.util.List;

/**
 * 1st approach : Time complexity - O(n) Space complexity - O(n)
 * create an empty array nums[]
 * compare both the lists and place it in the array -> {1, 1, 2, 3, 4, 4}
 * convert the array to list and return
 *
 * 2nd approach : Time Complexity - O(n + m) where n is the number of elements in list1 and m is the number of elements in list2
 *                Space complexity - O(1) since we are not using any extra space except a dummy node which is constant
 * create a dummy node and a pointer pointing to dummy node which keeps track of the nodes attached with the dummy node
 * Also we will have two pointers for list 1 and list 2 which tracks for list 1 and list 2
 * we'll basically point the dummy nodes pointer for l1 and l2 in sorted manner
 * at the end we return pointer to the next of dummy node
 */
public class MergeTwoSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {} // default empty constructor

        ListNode(int val) { // constructor to  create a ListNode with a default value
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

       // if l1 has reached null and l2 is not then attach l2 to next of current pointer and vice versa for l1
        current.next = l1 == null ? l2 : l1;

        return dummy.next;
    }




}
