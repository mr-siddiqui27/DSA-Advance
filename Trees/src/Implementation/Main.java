package Implementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        BinaryTree bt = new BinaryTree();
//        bt.populate(scanner);
//
//        bt.prettyDisplay();
        int[] val = {1,2,3,4,5,6,7,8,9};

        System.out.println("BST: ");
        BinarySearchTree bst = new BinarySearchTree();
        bst.populate(val);
        System.out.println(bst.isBalance());
        bst.prettyDisplay();


        System.out.println("AVL: ");
        AVL avl = new AVL();
        avl.populate(val);
        System.out.println(avl.isBalance());
        avl.prettyDisplay();

    }
}
