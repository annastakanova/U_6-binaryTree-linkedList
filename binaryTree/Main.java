package by.epam.unit06;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        BinaryTreeLogic logic = new BinaryTreeLogic();
        logic.addNode(50, bt);
        logic.addNode(66, bt);
        logic.addNode(74, bt);
        logic.addNode(92, bt);
        logic.addNode(108, bt);
        logic.addNode(245, bt);
        logic.addNode(998, bt);

        System.out.print("\nПоиск по значению: ");
        try {
            System.out.println(logic.nodeSearch(108, bt).getValue() + " ");
        } catch (NullPointerException npe) {
            System.out.print(bt);
        }

        logic.removeItem(92, bt);
        System.out.println("\nДанные после удаления: ");
        Printer pt = new Printer();
        pt.print(bt);

        //pt.printByLevel(bt.getRoot());
    }
}

