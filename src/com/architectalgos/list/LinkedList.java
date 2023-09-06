package com.architectalgos.list;

/**
 * Linked list representation of a Node.
 * @param <T>
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Created On : 8/21/23.
 *
 * @author : madstuff
 */
public class LinkedList<T> {
    private Node<T> head;
    int size;

    public LinkedList() {
        head = new Node<>(null);
        size = 0;
    }

    /**
     * Insert an element at the beginning of the List.
     * @param data
     */
    public void insertAtBeginning(T data) {
        Node<T> node = new Node<>(data);

        Node<T> temp = head.next;
        head.next = node;
        node.next = temp;

        size++;
    }

    /**
     * Insert an element at the end of the list.
     * @param data
     */
    public void insertAtEnd(T data) {
        Node<T> node = new Node<>(data);

        System.out.println("Node to be added: " + node.data + " : " + node);

        if (head.next == null) {
            head.next = node;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        System.out.println("Current Value: " + current.data);

        current.next = node;

        size++;
    }

    /**
     * If data is present then delete that node containing the data or else return.
     * @param value
     */
    public void delete(T value) {
        // Empty list.
        if (head.next == null) return;

        // First element needs to get deleted.
        if (head.next.data == value) {
            head.next = head.next.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) return;

        if (current.next.data == value){
            current.next = current.next.next;
        }
    }

    /**
     * Search for a value and return a boolean based on whether the value is found
     * or not found.
     * @param value
     * @return
     */
    public boolean search(T value) {
        if (head.next == null) return false;

        Node<T> temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) return false;

        return true;
    }

    public void reverse() {
        if (head.next == null) return;

        Node<T> previous = null;
        Node<T> current = head.next;
        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head.next = previous;
    }

    /**
     * A helper function to print out the list at any given state.
     */
    private void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtEnd(4);

        list.printList();

        list.delete(2);
        list.delete(1);
        list.delete(4);

        list.printList();

        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtEnd(4);

        list.printList();

        list.reverse();
        list.printList();

        System.out.println(list.search(5));
    }
}
