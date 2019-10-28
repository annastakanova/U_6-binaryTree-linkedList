package by.epam;

import java.util.Objects;

public class Node {
    int data;
    Node next;
    Node previous;

    public Node(int data) {
        this.data = data;
        next = null;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(int data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data &&
                Objects.equals(next, node.next) &&
                Objects.equals(previous, node.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next, previous);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}