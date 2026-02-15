package Implementation;

import java.util.Scanner;

public class BinaryTree {

    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.print("Enter root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(root, scanner);
    }

    private void populate(Node node, Scanner scanner){
        System.out.print("Do you have left child of "+node.value+" (true/false): ");
        boolean isLeft = scanner.nextBoolean();
        if(isLeft){
            System.out.print("Enter the left Node: ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left, scanner);
        }

        System.out.print("Do you have right child of "+node.value+" (true/false): ");
        boolean isRight = scanner.nextBoolean();
        if(isRight){
            System.out.print("Enter the right Node: ");
            int value = scanner.nextInt();
            node.right = new Node(value);

            populate(node.right, scanner);
        }
    }

    public void display(){
        display(this.root,"");
    }
    private void display(Node node, String indent){
        if(node==null) return;
        System.out.println(indent + node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root, 0);
    }
    private void prettyDisplay(Node node, int level){
        if(node==null) return;
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0; i<level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.value);
        } else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);
    }
}
