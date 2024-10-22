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
//        sll.head = new ListNode(10);     // assign head having a value of 10
//        ListNode second = new ListNode(1); // second node having value as 1
//        ListNode third = new ListNode(8); // third node having value as 8
//        ListNode fourth = new ListNode(11); // fourth node having value as 11
//
//        // Now we connect them together to form a chain
//        sll.head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = null;

//        sll.insertAtFront(6);
//        sll.insertAtFront(5);
//        sll.insertAtFront(4);
//        sll.insertAtFront(3);
//        sll.insertAtFront(2);
//        sll.insertAtFront(1);
        sll.insertAtEnd(10);
        sll.insertAtEnd(15);
        sll.insertAtEnd(25);
        sll.insertAtEnd(30);

        sll.printList();
        System.out.println("");
        System.out.println("Length of the LinkedList = "+sll.length());
    }

    /**
     * Function to Print the values in a linkedlist
     */
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    /**
     * Find the length of a linkedlist
     */
    public int length() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int count = 0;  // tracks the counts of the nodes
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Function to insert a node at the Beginning of a linkedlist
     */
    public void insertAtFront(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Function to insert a node at the End of a linkedlist
     */
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head; // temporary current node which keeps traversing through the list until it finds a node whose next is pointing to null
        while (current.next != null) {
            current = current.next;
        }
        // if the condition is met that means we've found the node whose next pointer is null so we'll attach our node with that
        current.next = newNode;
    }

}
