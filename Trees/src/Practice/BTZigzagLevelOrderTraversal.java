package Practice;

import Model.TreeNode;

import java.util.*;
// 4  leetcode 103
public class BTZigzagLevelOrderTraversal {

    // More optimal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int level =0;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize; i++){
                if(level%2==0){
                    TreeNode currentNode = deque.removeFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left!=null) deque.addLast(currentNode.left);
                    if(currentNode.right!=null) deque.addLast(currentNode.right);
                }else{
                    TreeNode currentNode = deque.removeLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right!=null) deque.addFirst(currentNode.right);
                    if(currentNode.left!=null) deque.addFirst(currentNode.left);
                }
            }
            result.add(currentLevel);
            level++;
        }
        return result;
    }




    // by reversing list
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
            }
            if(level%2==0) ans.add(currentLevel);
            else {
                Collections.reverse(currentLevel);
                ans.add(currentLevel);
            }
            level++;
        }
        return ans;
    }
}
