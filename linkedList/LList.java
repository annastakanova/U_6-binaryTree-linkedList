package by.epam;

public class LList {

    private Node first;
    private Node last;
    private int size;

    public LList() {
        first = null;
        last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addAtEnd(int element) {
        Node node = new Node(element);
        if (first == null) {
            node.next = null;
            node.previous = null;
            first = node;
            last = node;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    public void addByIndex(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        if (index == 0) {
            addAtEnd(element);
        }
        if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        Node oldNode = first;
        for (int i = 0; i < index; i++) {
            oldNode = oldNode.next;
        }
        Node oldPrevious = oldNode.previous;
        oldPrevious.next = newNode;
        oldNode.previous = newNode;

        newNode.previous = oldPrevious;
        newNode.next = oldNode;
        size++;
    }


    public void removeData(int i) {
        Node previous = null;
        Node current = first;
        while (current != null) {
            if (current.getData() == i) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node node = findNodeBeforeByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        //return false;
    }

    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }

    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public String getStringOfList() {
        StringBuilder result = new StringBuilder();
        Node current = first;
        while (current != null) {
            result.append(current.getData() + " ");
            current = current.getNext();
        }
        return result.toString();
    }

}