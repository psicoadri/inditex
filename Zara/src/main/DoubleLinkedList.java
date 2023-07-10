package main;
public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
                if (currentNode == head && currentNode == tail) {
                    head = null;
                    tail = null;
                } else if (currentNode == head) {
                    head = head.next;
                    head.prev = null;
                } else if (currentNode == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public boolean contains(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Unit tests
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Print the list
        System.out.print("List: ");
        list.printList();

        // Remove an element
        list.remove(3);
        System.out.print("List after removing 3: ");
        list.printList();

        // Check if an element exists
        System.out.println("Does the list contain 2? " + list.contains(2));
        System.out.println("Does the list contain 6? " + list.contains(6));

        // Get the size of the list
        System.out.println("Size of the list: " + list.size());
        
    }
}

