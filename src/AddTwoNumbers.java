/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){} // default constructor
        ListNode(int val) { // constructor to create a node with the value
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0 + carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // calclate the carry and sum
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            current.next = node;
            current = current.next;
        }

        // if l1 and l2 is null and I am remaining with a carry
        if (carry != 0) {
            ListNode node = new ListNode(1);
            current.next = node;
            current = current.next;
        }
        return dummy.next;
    }
}


/**
 * Approach:
 * result node -> store the addition of two listnode numbers
 * variable carry -> which stores the carry after every addition if there's one
 * variable sum -> stores the sum of the listnode's value
 * run a loop, while l1 != null or l2 != null
 * calculate the sum by adding l1 and l2
 * calculate the carry if the sum is in tens
 * create a node having the current sum value
 * attach current sum node with the result node
 * at the end if there's a carry remaining we'll create a node with the value of carry
 * attach the carry node in the result
 * return the next pointer to the result
 */
