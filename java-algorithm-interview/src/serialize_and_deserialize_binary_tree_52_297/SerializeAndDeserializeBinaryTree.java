package serialize_and_deserialize_binary_tree_52_297;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf("#," + root.val));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
                sb.append("," + node.left.val);
            }
            else sb.append(",#");
            if(node.right != null) {
                queue.add(node.right);
                sb.append("," + node.right.val);
            }
            else sb.append(",#");
        }
        
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 2;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index++;
            if(!nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index++;
        }
        
        return root;
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