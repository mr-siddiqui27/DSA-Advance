package Practice;

import Model.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Q 1    LeetCode 102
public class LevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for(int i=0; i<levelSize; i++){
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left!=null) queue.offer(currentNode.left);
                    if(currentNode.right!=null) queue.offer(currentNode.right);
                }
                result.add(currentLevel);
            }
            return result;
        }
    }


// class Solution {
//     public List<List<Integer>> levelOrder(Model.TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         levelOrderTrav(root, list, 0);
//         return list;
//     }

//     void levelOrderTrav(Model.TreeNode node, List<List<Integer>> list, int level){
//         if (node==null) return;

//         if (list.size() <= level) {
//             list.add(new ArrayList<>());
//         }
//         list.get(level).add(node.val);

//         levelOrderTrav(node.left, list, level+1);
//         levelOrderTrav(node.right, list, level+1);
//     }
// }
}
