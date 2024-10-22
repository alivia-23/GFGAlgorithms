package LinkedList;

/**
 * A singly linkedlist is a data structure which stores collection of data
 *
 */
public class SinglyLinkedList {

    private ListNode head;  // head is instance variable
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) { // constructor to create a node with a value
            this.val = val;
            this.next = null; // whenever a new node is created the node's next pointer points to null
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();  // as we initialize the singly linkedlist the value of our head is initially null
        sll.head = new ListNode(10);     // assign head having a value of 10
        ListNode second = new ListNode(1); // second node having value as 1
        ListNode third = new ListNode(8); // third node having value as 8
        ListNode fourth = new ListNode(11); // fourth node having value as 11

        // Now we connect them together to form a chain
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        sll.printList();
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }


}
