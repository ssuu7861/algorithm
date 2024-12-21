package convert_sorted_array_to_binary_search_tree_55_108;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -7, -3, 0, 5, 7, 9};
        TreeNode root = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public static TreeNode recursion(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursion(nums, start, mid - 1);
        node.right = recursion(nums, mid + 1, end);

        return node;
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