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
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        check(root, k, 0);
        return res;
    }
    public int check(TreeNode root, int k, int count){
        if(root == null) return count;
        
        count = check(root.left, k, count);
        count++;
        if(count == k){
            res = root.val;
        }
        count = check(root.right, k, count);
        
        return count;
    }   
}
