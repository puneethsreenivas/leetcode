class Solution {
    class Node{
        int row;
        int col;
        int dist;
        Node(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
       
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1 ) return -1;
        boolean[][] vis=new boolean[n][n];
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(0,0,1));
        vis[0][0]=true;
        int[] dr={-1,-1,-1,0,1,1,1,0};
        int[] dc={-1,0,+1,+1,+1,0,-1,-1};
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.row==n-1 && curr.col==n-1){
                return curr.dist;
            }
            for(int i=0;i<8;i++){
                int nr=curr.row+dr[i];
                int nc=curr.col+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && vis[nr][nc]==false && grid[nr][nc]==0){
                    vis[nr][nc]=true;
                    q.offer(new Node(nr,nc,curr.dist+1));
                }
            }
        }
        return -1;
    }
}