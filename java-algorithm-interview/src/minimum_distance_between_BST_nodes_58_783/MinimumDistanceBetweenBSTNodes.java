package minimum_distance_between_BST_nodes_58_783;

public class MinimumDistanceBetweenBSTNodes {
    
    int prev = Integer.MIN_VALUE + 100000;
    int diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;

        minDiffInBST(root.left);

        diff = Math.min((root.val - prev), diff);
        prev = root.val;

        minDiffInBST(root.right);

        return diff;
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