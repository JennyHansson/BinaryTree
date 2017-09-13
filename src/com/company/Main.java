package com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(7);
        tree.insert(12);
        tree.insert(25);
        tree.insert(11);
        tree.insert(4);
        tree.insert(7);
        tree.insert(7);
        tree.insert(26);
        tree.insert(19);
        tree.insert(3);

        System.out.println("\nPreorder: ");
        tree.preorder();
        System.out.println("\nInorder: ");
        tree.inorder();
        System.out.println("\nPostorder: ");
        tree.postorder();

        System.out.println("\nBalance: " + tree.balance());

        System.out.println("Sum: " + tree.sum());

        System.out.println("Quantity of 7: " + tree.quantity(7));
        System.out.println("Quantity of 12: " + tree.quantity(12));

        System.out.println("\nDelete 7");
        tree.delete(7);
        System.out.println("Quantity of 7: " + tree.quantity(7));
        System.out.println("Sum: " + tree.sum());
        System.out.println("Balance: " + tree.balance());
    }
}
