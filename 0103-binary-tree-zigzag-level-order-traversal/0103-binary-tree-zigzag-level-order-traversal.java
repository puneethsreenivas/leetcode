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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean lr=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> res=new ArrayList<>();
           
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
                if(lr){
                    res.add(temp.val);

                }
                if(!lr){
                    res.add(0,temp.val);
                }
            }
            lr=!lr;

            result.add(res);
        }

        return result;
    }
}