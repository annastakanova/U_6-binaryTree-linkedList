package by.epam.unit06;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public void print(BinaryTree binaryTree) {
        if (binaryTree.getRoot() == null)
            return;
        print(binaryTree.getRoot(), 0);
    }

    private void print(Node node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
            }
            System.out.print(node.getValue() + " ");
            print(node.getLeftChild(), level + 1);
            print(node.getRightChild(), level + 1);
        }
    }

    public void printByLevel(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) {
                System.out.print(root + " ");
                if (root.getLeftChild() != null) {
                    q.offer(root.getLeftChild());
                }
                if (root.getRightChild() != null) {
                    q.offer(root.getRightChild());
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.offer(null);
                }
            }
        }
        System.out.println("\n");
    }

    public void printNode (Node currentNode) {
        System.out.println(currentNode);
    }
}