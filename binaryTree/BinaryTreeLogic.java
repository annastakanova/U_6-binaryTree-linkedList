package by.epam.unit06;

public class BinaryTreeLogic{

    public void addNode(int value, BinaryTree bt){
        if (bt.getRoot() == null){
            bt.setRoot(new Node(value));
            return;
        }
        addNode(bt.getRoot(), value);
    }

    private void addNode (Node currentNode, int value){
        if (value > currentNode.getValue()){
            if (currentNode.getRightChild() == null){
                currentNode.setRightChild(new Node(value));
            } else {
                addNode(currentNode.getRightChild(), value);
            }
        }
        if (value < currentNode.getValue()){
            if (currentNode.getLeftChild() == null){
                currentNode.setLeftChild(new Node(value));
            } else {
                addNode(currentNode.getLeftChild(), value);
            }
        }
    }

    public Node nodeSearch(int value, BinaryTree binaryTree) {
        if (binaryTree.getRoot() == null) {
            return null;
        }
        return nodeSearch(value, binaryTree.getRoot());

    }
    private Node nodeSearch(int value, Node node) {
        if (node == null) {
            return null;
        }
        if (value == node.getValue()) {
            return node;
        }
        if (value > node.getValue()) {
            return nodeSearch(value, node.getRightChild());
        } else {
            return nodeSearch(value, node.getLeftChild());
        }
    }

    public Node maxNode(BinaryTree binaryTree) {
        if (binaryTree.getRoot() != null)
            return maxNode(binaryTree.getRoot());
        return null;
    }

    private Node maxNode(Node node) {
        if (node.getRightChild() == null)
            return node;
        return maxNode(node.getRightChild());
    }

    public Node searchParent(int value, BinaryTree binaryTree) {
        if (binaryTree.getRoot() == null) {
            return null;
        }
        if (binaryTree.getRoot().getValue() == value) {
            return null;
        }
        return searchParent(value, binaryTree.getRoot());
    }

    private Node searchParent(int value, Node node) {
        if (value > node.getValue()) {
            if (node.getRightChild() == null) {
                return null;
            }
            if (node.getRightChild().getValue() == value) {
                return node;
            }
            return searchParent(value, node.getRightChild());
        } else {
            if (node.getLeftChild() == null) {
                return null;
            }
            if (node.getLeftChild().getValue() == value) {
                return node;
            }
            return searchParent(value, node.getLeftChild());
        }
    }
    public Node removeItem(int value, BinaryTree binaryTree) {
        if (binaryTree.getRoot() == null) {
            return null;
        }
        Node parentItem = searchParent(value, binaryTree.getRoot());
        Node removeItem = nodeSearch(value, binaryTree.getRoot());
        if (parentItem == null || removeItem == null) {
            return null;
        }
        Node parentLink;
        if (removeItem.getRightChild() == null && removeItem.getLeftChild() == null) {
            parentLink = null;
        } else if (removeItem.getLeftChild() == null && removeItem.getRightChild() != null) {
            parentLink = removeItem.getRightChild();
        } else if (removeItem.getLeftChild() != null && removeItem.getRightChild() == null) {
            parentLink = removeItem.getLeftChild();
        } else {
            parentLink = removeItem.getLeftChild();
            Node maxItem = maxNode(removeItem.getLeftChild());
            maxItem.setRightChild(removeItem.getRightChild());
        }
        if (parentItem.getRightChild() == removeItem) {
            parentItem.setRightChild(parentLink);
        } else {
            parentItem.setLeftChild(parentLink);
        }
        return removeItem;
    }

    Printer pr = new Printer();
    public void inOrderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            inOrderTraverseTree(currentNode.getLeftChild());
            pr.printNode(currentNode);
            inOrderTraverseTree(currentNode.getRightChild());
        }
    }
    public void preorderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            pr.printNode(currentNode);
            preorderTraverseTree(currentNode.getLeftChild());
            preorderTraverseTree(currentNode.getRightChild());
        }
    }
    public void postOrderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            postOrderTraverseTree(currentNode.getLeftChild());
            postOrderTraverseTree(currentNode.getRightChild());
            pr.printNode(currentNode);
        }
    }
}