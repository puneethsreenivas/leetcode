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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int ans=0;
        Queue<pair>q=new LinkedList<>();
        
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int mmin=q.peek().idx;
            int fst=0;
            int lst=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur_idx=q.peek().idx-mmin;
                TreeNode temp=q.peek().node;
                if(i==0) fst=cur_idx;
                if(i==size-1) lst=cur_idx;
                q.poll();
                if(temp.left!=null){
                    q.offer(new pair(temp.left,cur_idx*2+1));
                }
                if(temp.right!=null){
                    q.offer(new pair(temp.right,cur_idx*2+2));
                }
               
            }
             ans=Math.max(ans,lst-fst+1);
            
        }

        return ans;
    }
    class pair{
        TreeNode node;
        int idx;
        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
}