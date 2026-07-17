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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
        
    }
    public TreeNode helper(int[] preorder,int pst,int ped,int[] inorder,int ist,int ied,HashMap<Integer,Integer>map){
        if(pst>ped || ist>ied) return null;
        TreeNode root=new TreeNode(preorder[pst]);
        int inroot=map.get(root.val);
        int numslft=inroot-ist;
        root.left=helper(preorder,pst+1,pst+numslft,inorder,ist,inroot-1,map);
        root.right=helper(preorder,pst+numslft+1,ped,inorder,inroot+1,ied,map);
        return root;
    }
}