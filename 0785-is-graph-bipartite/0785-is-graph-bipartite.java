class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] set=new int [graph.length];
        for(int i=0;i<graph.length;i++){
            set[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            if(set[i]==-1){
               if(dfs(i,graph,0,set)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int[][] graph,int col,int[] set){
        set[node]=col;
        for(int it: graph[node]){
            if(set[it]==-1){
               if( dfs(it,graph,1-col,set)==false) return false;
            }
            else if(set[node] ==set[it]){
                return false;
            }
        }
        return true;
    }
}