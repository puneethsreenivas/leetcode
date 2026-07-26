class Solution {
    int[] dr={-1,0,+1,0};
    int[] dc={0,+1,0,-1};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(char[][] grid,int row,int col,boolean[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && !vis[nr][nc]){
                dfs(grid,nr,nc,vis);
            }
        }
    }
}