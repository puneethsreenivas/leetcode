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
    int ans=0;
    class Node{
        int min;
        int max;
        int sum;
        Node(int min,int max,int sum){
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
    Node helper(TreeNode root){
        if(root==null){
            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Node left=helper(root.left);
        Node right=helper(root.right);
        boolean bst=left.max<root.val && root.val<right.min;
        if(bst){
            int sum=left.sum+right.sum+root.val;
            ans=Math.max(ans,sum);
            int currmin=Math.min(left.min,root.val);
            int currmax=Math.max(right.max,root.val);
            return new Node (currmin,currmax,sum);
        }
        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    }
}