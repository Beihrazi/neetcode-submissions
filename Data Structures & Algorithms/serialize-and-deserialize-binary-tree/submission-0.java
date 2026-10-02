/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        process(root, sb);
        return String.valueOf(sb);
    }
    private void process(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
       }

       sb.append(root.val);
       sb.append(",");

       process(root.left, sb);
       process(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        return compute(res);
    }
    public TreeNode compute(String[] res){
        if(res[i].equals("null")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(res[i++]));

        node.left = compute(res);
        node.right = compute(res);

        return node;
    }
}
