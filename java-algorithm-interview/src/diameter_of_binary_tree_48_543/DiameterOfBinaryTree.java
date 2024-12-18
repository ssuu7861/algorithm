package diameter_of_binary_tree_48_543;

public class DiameterOfBinaryTree {

    static int diameter = 0;
    
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public static int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
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
