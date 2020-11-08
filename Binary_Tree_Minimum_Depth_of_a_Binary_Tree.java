/**
Find Minimum Depth of a Binary Tree


https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/

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
    public int minDepth(TreeNode root) {
        
        /*
        if(root != null){
            System.out.println("value:"+root.val);
            System.out.println("left:"+root.left+"; right:"+root.right);
        }else{
            System.out.println("null");
        }
        */

        if(root == null) return 0;
            
        if(root.left == null && root.right == null) return 1;
        
        if(root.left == null && root.right != null) return 1+minDepth(root.right);
        
        if(root.left != null && root.right == null) return 1+minDepth(root.left);
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        //System.out.println("left depth:"+leftDepth+"; right depth:"+rightDepth);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
