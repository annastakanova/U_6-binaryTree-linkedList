package by.epam.unit06;

public class Node {
    private int value;
    private Node rightChild;
    private Node leftChild;

    public Node(int value) {
        this.value = value;
        this.rightChild = null;
        this.leftChild = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int data) {
        this.value = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

}
