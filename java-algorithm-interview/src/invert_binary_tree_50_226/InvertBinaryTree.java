package invert_binary_tree_50_226;

public class InvertBinaryTree {

    public static TreeNode invertTree1(TreeNode root) { // 값만 가져오는 새로운 TreeNode 생성
        if(root == null) return null;

        TreeNode node = new TreeNode(root.val);
        node.left = invertTree1(root.right);
        node.right = invertTree1(root.left);

        return node;
    }

    public static TreeNode invertTree2(TreeNode root) { // 위에서 내려가면서 바꾸고 다시 내려가고를 반복
        if(root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree2(root.left);
            invertTree2(root.right);
        }
        return root; // 재귀에선 리턴을 다시 사용하지 않으므로 마지막 전체 트리만 리턴하는 것과 같음
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