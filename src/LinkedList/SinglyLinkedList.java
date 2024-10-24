package LinkedList;

import java.util.List;

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
        ListNode fifth = new ListNode(20); // fourth node having value as 11

        // Now we connect them together to form a chain
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

//        sll.insertAtFront(6);
//        sll.insertAtFront(5);
//        sll.insertAtFront(4);
//        sll.insertAtFront(3);
//        sll.insertAtFront(2);
//        sll.insertAtFront(1);
//        sll.insertAtEnd(10);
//        sll.insertAtEnd(15);
//        sll.insertAtEnd(25);
//        sll.insertAtEnd(30);

//        sll.insertAtIndex(8, 1);
//        sll.insertAtIndex(10, 2);
//        sll.insertAtIndex(20, 3);
//        sll.insertAtIndex(5, 4);
//        sll.insertAtIndex(6, 3);
//        sll.insertAtIndex(2, 2);

//        sll.deleteFirst(); // deletes 8
//        sll.deleteFirst(); // deletes 2

//        sll.deleteLast();
//        sll.deleteLast();

//        sll.deleteAtIndex(4);


//        System.out.println(sll.searchElement(7));
//        System.out.println(sll.searchElement(20));

        //sll.reverseList();

        sll.printList();
        System.out.println("");
        System.out.println("Length of the LinkedList = "+sll.length());

        // Get Nth node from End of a linkedlist
        ListNode nthNode = sll.findNthNode(sll.head, 2);
        System.out.println(nthNode.val); // print nth node from last

        // Remove nth node
        ListNode head = sll.removeNthFromEnd(sll.head, 2);
        System.out.println(head);
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

    /**
     * Function to insert a node at a given position
     */
    public void insertAtIndex(int val, int index) {
        ListNode node = new ListNode(val);
        if (index == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode prev = head;
            int count = 1;
            while (count < index - 1) {
                count++;
                prev = prev.next;
            }
            ListNode current = prev.next;
            prev.next = node;
            node.next = current;
        }
    }

    /**
     * Function to delete first node from a linkedlist
     */
    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    /**
     * Delete last node of a linkedlist
     */
    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    /**
     * Delete a node at given position
     */
    public void deleteAtIndex(int index) {
        ListNode current = head;
        int count = 1;

        if (head == null) {
            return;
        }

        while (count < index - 1) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    /**
     * Search an element in a linkedlist
     */
    public boolean searchElement(int val) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Reverse a linkedlist
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Find the middle of a linkedlist
     */
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Find nth node from the end of a linkedlist
     */
    public ListNode findNthNode(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;
        while (count <= n) {
            fast = fast.next;
            count++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Remove nth node from end of linkedlist
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        while (count <= n + 1) {
            fast = fast.next;
            count++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
