class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];

        int[] dvis=new int[n];
        int[] safe=new int[n];
        for(int i=0;i<n;i++){
            dfs(i,graph,vis,dvis,safe);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int node,int[][] adj,int[] vis,int[] dvis,int[] safe){
        vis[node]=1;
        dvis[node]=1;

        for(int it: adj[node]){
            if(vis[it]==0){
                vis[it]=1;
                dvis[it]=1;
                if(dfs(it,adj,vis,dvis,safe)) return true;
            }
            else if(dvis[it]==1) return true;

        }
        dvis[node]=0;
        safe[node]=1;
        return false;
    }
}