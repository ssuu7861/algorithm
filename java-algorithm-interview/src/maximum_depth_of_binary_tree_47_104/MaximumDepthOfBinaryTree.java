package maximum_depth_of_binary_tree_47_104;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    //DFS
    public static int maxDepthDFS(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepthDFS(root.left);
        int right = maxDepthDFS(root.right);
        
        return Math.max(left, right) + 1;
    }

    //BFS
    public static int maxDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size(); // 해당 레벨의 모든 노드 수
            
            for(int i = 0 ; i < size ; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }
        return depth;
    } 
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
