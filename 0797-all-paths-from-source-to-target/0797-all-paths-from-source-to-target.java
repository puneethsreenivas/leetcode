class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int v=graph.length;
        int[] vis=new int[v];
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(0,graph,vis,path);
        return ans;

    }
    public void dfs(int node,int [][] grid,int[] vis,List<Integer> path){
        int v=grid.length;
        vis[node]=1;
        if(node==v-1){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int next: grid[node]){
            if(vis[next]==0){
                vis[next]=1;
                path.add(next);
                dfs(next,grid,vis,path);

                vis[next]=0;
                path.remove(path.size()-1);
            }

        }
    }
}