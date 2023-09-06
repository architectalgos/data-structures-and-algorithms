package com.architectalgos.list.application;

/**
 * Created On : 8/22/23.
 *
 * @author : madstuff
 */
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDeque {
    Node front;
    Node rear;
    int size = 0;
    int maxSize = 0;
    public CircularDeque(int k) {
        this.maxSize = k;
    }

    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }

        Node node = new Node(value);
        if (size == 0) {
            front = node;
            rear = front;
        } else {
            Node temp = front;
            node.next = front;
            temp.prev = node;
            front = node;
        }

        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }

        Node node = new Node(value);
        if (size == 0) {
            front = node;
            rear = front;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        if (front == rear) {
            front = null;
            rear = null;
            size = 0;
        } else {
            front = front.next;
            front.prev = null;
            size--;
        }

        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        if (front == rear) {
            front = null;
            rear = null;
            size = 0;
        } else {
            Node temp = rear.prev;
            temp.next = null;
            rear = temp;
            size--;
        }

        return true;
    }

    public int getFront() {
        if (size == 0) return -1;
        else return front.data;
    }

    public int getRear() {
        if (size == 0) return -1;
        else return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}