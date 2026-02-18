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

        BinarySearchTree bst = new BinarySearchTree();
        int[] val = {1,2,3,4,5,6,7,8,9};
        bst.populateSorted(val);

        System.out.println(bst.isBalance());

        bst.prettyDisplay();

    }
}
