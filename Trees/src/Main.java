

// practice


import java.util.Scanner;




//class BT{
//
//    class Node{
//        int val;
//        Node left;
//        Node right;
//        Node(int val){
//            this.val = val;
//        }
//    }
//
//    Node root;
//
//    public void populate(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter value: ");
//        int val = sc.nextInt();
//        root= new Node(val);
//        populate(sc, root);
//    }
//
//    void populate(Scanner sc, Node node){
//        System.out.print("Do you have left Node: ");
//        boolean isLeft = sc.nextBoolean();
//        if(isLeft){
//            System.out.print("Enter value: ");
//            int val = sc.nextInt();
//            node.left = new Node(val);
//            populate(sc, node.left);
//        }
//        System.out.print("Do you have right Node: ");
//        boolean isRight = sc.nextBoolean();
//        if(isRight){
//            System.out.print("Enter value: ");
//            int val = sc.nextInt();
//            node.right = new Node(val);
//            populate(sc, node.right);
//        }
//    }
//
//    public void prettyDisplay(){
//        prettyDisplay(this.root, 0);
//    }
//    private void prettyDisplay(Node node, int level){
//        if(node==null) return;
//        prettyDisplay(node.right,level+1);
//        if(level!=0){
//            for(int i=0; i<level-1; i++){
//                System.out.print("|\t\t");
//            }
//            System.out.println("|------>"+node.val);
//        } else{
//            System.out.println(node.val);
//        }
//        prettyDisplay(node.left, level+1);
//    }
//
//}


class BST{

    class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;
        public Node(int val){
            this.val = val;
        }
        int getVal(){
            return this.val;
        }
    }

    public int getHeight(Node node){
        if(node==null) return -1;
        return node.height;
    }

    private Node root;
    public void populate(int[] arr){
         for(int num: arr){
            root = populate(num, root);
        }
    }

    Node populate(int val, Node node){
        if(node==null){
            return new Node(val);
        }
        if(node.getVal()<val) node.right = populate(val, node.right);
        if(node.getVal()>=val) node.left = populate(val, node.left);

        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;

        return node;
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
            System.out.println("|------>"+node.val);
        } else{
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level+1);
    }
}











public class Main {
    public static void main(String[] args) {
//    BT bt = new BT();
//    bt.populate();
//
//    bt.prettyDisplay();

        BST bst = new BST();
        int[] arr = {10,24,2,3,0,1,6,4};
        bst.populate(arr);
        bst.prettyDisplay();



    }


}