package Practice;

//Given a binary tree and a target node, find the level order successor of the given node.
//
//The level order successor is the node that appears immediately after the given node in level order traversal.

import Model.TreeNode;

import java.util.LinkedList;

import java.util.Queue;

// Q3
public class NextRightNode {
    public TreeNode levelOrder(TreeNode root, int n) {
        if(root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
                if(currentNode.val == n)
                    if(!queue.isEmpty()) return queue.peek();
                    else return null;

        }
        return null;
    }
}
