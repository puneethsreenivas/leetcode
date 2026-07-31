class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int[] vis=new int[n];
        int ans=-1;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                HashMap<Integer,Integer> map=new HashMap<>();
                int node=i;
                int step=0;
                while(node!=-1 && vis[node]==0){
                    vis[node]=1;
                    map.put(node,step++);
                    node=edges[node];
                    
                    if(node!=-1 &&map.containsKey(node)){
                        ans=Math.max(ans,step-map.get(node));
                        break;
                    }

                }
            }
        }
        return ans;
    }
}