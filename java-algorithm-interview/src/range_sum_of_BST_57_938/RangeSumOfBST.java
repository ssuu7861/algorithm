package range_sum_of_BST_57_938;

public class RangeSumOfBST {

    public int rangeSumBST1(TreeNode root, int low, int high) { // DFS + Brute force
        if(root == null) return 0;
        int result = 0;
        if(low <= root.val && root.val >= high) result = root.val;
        result += rangeSumBST1(root.left, low, high);
        result += rangeSumBST1(root.right, low, high);
        
        return result;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) { // DFS + Pruning
        if(root == null) return 0;
        if(root.val < low) return rangeSumBST2(root.right, low, high);
        if(root.val > high) return rangeSumBST2(root.left, low, high);
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
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