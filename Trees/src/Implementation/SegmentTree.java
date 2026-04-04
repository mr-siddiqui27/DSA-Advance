package Implementation;

public class SegmentTree {

    public static void main(String[] args){
        int[] arr = {3,8,7,6,-2,-8,4,9};

        SegmentTree st = new SegmentTree(arr);

        st.display();
        System.out.println(st.query(1,4));
        st.update(4,14);
        st.display();

    }

    public static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr){

        root = new Node(0, arr.length-1);
        this.root = constructTree(arr,0, arr.length-1);
    }

    private Node constructTree(int[] arr, int st, int end){
        if(st==end){
            Node leaf = new Node(st, end);
            leaf.data = arr[st];
            return leaf;
        }
        Node node = new Node(st,end);
        int mid = (st+end)/2;

        node.left = constructTree(arr, st, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;

        return node;

    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) return;

        System.out.println("Interval=[" + node.startInterval + "-" + node.endInterval + "] -> " + node.data);

        display(node.left);
        display(node.right);
    }

    // query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // node is completely lying inside query
            return node.data;
        }
        else if (node.startInterval > qei || node.endInterval < qsi) {
            // completely outside
            return 0;
        }
        else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }
}
