package Implementation;

public class BinarySearchTree {

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    private Node root;

    public BinarySearchTree(){

    }

    public int height(Node node){
        if(node==null) return -1;
        return node.height;
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }

        if(value<node.value) node.left = insert(value, node.left);
        if(value>node.value) node.right = insert(value, node.right);

        node.height = Math.max(height(node.left), height(node.right))+1;

//        System.out.println("Height of "+node.value+" is "+node.height);

        return node;
    }

    public boolean isBalance(){
        return balance(root);
    }
    private boolean balance(Node node){
        if(node==null) return true;
        return Math.abs(height(node.left)-height(node.right)) <=1 && balance(node.left) && balance(node.right);
    }

    public void populate(int[] nums){
        for(int num : nums){
            insert(num);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length-1);
    }
    private void populateSorted(int[] nums, int st, int end){
        if(st>end) return;

        int mid = (st+end)/2;
        insert(nums[mid]);
        populateSorted(nums, st, mid-1);
        populateSorted(nums, mid+1, end);
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
