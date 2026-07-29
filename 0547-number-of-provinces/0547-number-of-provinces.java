class Solution {
    int[] dr={-1,0,+1,0};
    int[] dc={0,+1,0,-1};
    public int findCircleNum(int[][] isConnected) {

        int n=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        int[] vis=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,adj,vis);
                cnt++;
            }
        }
       return cnt;
    }
    public void dfs(int node,List<List<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis);
            }
        }
    }
    
}