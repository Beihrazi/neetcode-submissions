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

class Solution {
    int pre_index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int left, int right){

        if(left > right) return null;

        TreeNode node = new TreeNode(preorder[pre_index]);

        int reqIndex = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preorder[pre_index]){
                reqIndex = i;
            }
        }
        pre_index++;

        node.left = buildTree(preorder, inorder, left, reqIndex-1);
        node.right = buildTree(preorder, inorder, reqIndex+1, right);
        
        return node;
    }
}
