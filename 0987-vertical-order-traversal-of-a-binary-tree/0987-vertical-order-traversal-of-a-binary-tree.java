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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0,0));
        while(!q.isEmpty()){
            pair p=q.poll();
            TreeNode temp=p.root;
            int col=p.col;
            int row=p.row;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).add(temp.val);
            if(temp.left!=null){
                q.add(new pair(temp.left,col-1,row+1));
            }
            if(temp.right!=null){
                q.add(new pair(temp.right,col+1,row+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> row : map.values()){
            List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer>pq:row.values()){
                while(!pq.isEmpty()){
                list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
        
    }
    class pair{
        TreeNode root;
        int col;
        int row;
        pair(TreeNode root,int col,int row){
            this.root=root;
            this.col=col;
            this.row=row;
        }
    }
}